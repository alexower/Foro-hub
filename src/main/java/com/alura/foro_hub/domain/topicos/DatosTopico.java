package com.alura.foro_hub.domain.topicos;

import com.alura.foro_hub.domain.curso.Curso;
import com.alura.foro_hub.domain.respuesta.DatosRespuesta;
import com.alura.foro_hub.domain.usuario.DatosUsuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record DatosTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime fecha,
        Boolean estatus,
        @NotNull @Valid
        DatosUsuario autor,
        @NotNull
        Curso curso,
        @Valid
        List<DatosRespuesta> respuestas

) {
}
