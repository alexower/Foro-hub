package com.alura.foro_hub.domain.topicos;
import com.alura.foro_hub.domain.curso.Curso;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record DatosTopicoLista(
        Long id,
        String titulo,
        String mensaje,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime fecha,
        Boolean estatus,
        String autor,
        Curso curso

) {
}
