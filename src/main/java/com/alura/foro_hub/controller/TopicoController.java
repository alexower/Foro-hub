package com.alura.foro_hub.controller;


import com.alura.foro_hub.domain.topicos.*;
import com.alura.foro_hub.domain.usuario.service.UsuarioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/topics")
public class TopicController {
    @Autowired
    private TopicoRespository topicRepository;
    @Autowired
    private TopicoService topicService;
    @Autowired
    private UsuarioService usuarioService;


    @PostMapping
    @Transactional
    public ResponseEntity<DatosTopicoLista> postTopic(@RequestBody @Valid DatosTopico data,
                                                      UriComponentsBuilder uri) {

        Topico topic = topicRepository.save(new Topico(data));

        //para encriptar clave
        usuarioService.encryptPassword(topic);

        DatosTopicoLista topicListDto = new DatosTopicoLista(topic.getId(), topic.getTitle(),
                topic.getMessage(), topic.getDate(), topic.getStatus(), topic.getAuthor().getName(),
                topic.getCourse());
        URI url = uri.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(url).body(topicListDto);
    }

    @GetMapping
    public ResponseEntity<Page<TopicListDto>> listTopics(
            @PageableDefault(size = 2, sort = "date") Pageable pagination) {
        return ResponseEntity.ok(topicRepository.findAll(pagination)
                .map(TopicListDto::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicListDto> pickTopicById(@PathVariable Long id) {
        return ResponseEntity.ok(topicService.getTopicById(id));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicListDto> putTopic(@RequestBody @Valid TopicUpdateDto data,
                                                 @PathVariable Long id) {
        return ResponseEntity.ok(topicService.updateTopic(data, id));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eraseTopic(@PathVariable Long id) {
        topicService.deleteTopic(id);
        return ResponseEntity.noContent().build();
    }

}