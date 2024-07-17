package com.alura.foro_hub.controller;


import com.alura.foro_hub.domain.topicos.*;

import com.alura.foro_hub.domain.usuario.service.UsuarioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


import java.net.URI;

@RestController
@RequestMapping("/topics")
public class TopicoController {
    @Autowired
    private TopicoRespository topicRepository;
    @Autowired
    private TopicoService topicService;
    @Autowired
    private UsuarioService userService;


    @PostMapping
    @Transactional

    public ResponseEntity<DatosTopicoLista> postTopic(@RequestBody @Valid DatosTopico data,
                                                      UriComponentsBuilder uri) {

        Topico topic = topicRepository.save(new Topico(data));

        userService.encryptPassword(topic);

        DatosTopicoLista topicListDto = new DatosTopicoLista(topic.getId(), topic.getTitulo(),
                topic.getMensaje(), topic.getFecha(), topic.getEstatus(), topic.getAutor(),
                topic.getCurso());
        URI url = uri.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(url).body(topicListDto);
    }

    @GetMapping
    public ResponseEntity<Page<DatosTopicoLista>> listTopics(
            @PageableDefault() Pageable paginacion) {
        return ResponseEntity.ok(topicRepository.findAll(paginacion).map(DatosTopicoLista::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosTopicoLista> pickTopicById(@PathVariable Long id) {
        return ResponseEntity.ok(topicService.getTopicById(id));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosTopicoLista> putTopic(@RequestBody @Valid DatosActualizarTopico data,
                                                 @PathVariable Long id) {
        return ResponseEntity.ok(topicService.actualizarTopico(data, id));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eraseTopic(@PathVariable Long id) {
        topicService.borrarTopic(id);
        return ResponseEntity.noContent().build();
    }
}
