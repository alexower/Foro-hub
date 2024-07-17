package com.alura.foro_hub.domain.topicos;
import com.alura.foro_hub.domain.curso.Curso;
import com.alura.foro_hub.domain.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record DatosTopicoLista(
        Long id,
        String titulo,
        String mensaje,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime fecha,
        Boolean estatus,
        Usuario autor,
        Curso curso

) {

        public DatosTopicoLista(Topico topico) {
                this(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getFecha(),
                        topico.getEstatus(),topico.getAutor(),topico.getCurso());
        }
}
