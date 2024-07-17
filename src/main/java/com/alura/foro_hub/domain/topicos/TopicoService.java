package com.alura.foro_hub.domain.topicos;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class TopicoService {
    @Autowired
    private TopicoRespository topicoRepository;

    public DatosTopicoLista getTopicById(Long id) {
        Optional<Topico> topicEnt = topicoRepository.findById(id);
        if (topicEnt.isPresent()) {
            Topico topico = topicEnt.get();
            return new DatosTopicoLista(topico.getId(), topico.getTitulo(), topico.getMensaje(),
                    topico.getFecha(), topico.getEstatus(), topico.getAutor(),
                    topico.getCurso());
        }
        return null;
    }


    public void borrarTopic(Long id) {
        Optional<Topico> topicEnt = topicoRepository.findById(id);
        if (topicEnt.isPresent()) {
            topicoRepository.deleteById(id);
        }
    }
}