package com.alura.foro_hub.domain.respuesta;

import com.alura.foro_hub.domain.usuario.DatosUsuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRespuesta(
        @NotBlank
        String mensaje,
        @NotNull @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime fecha,
        @NotNull Boolean solucion,
        @NotNull @Valid DatosUsuario autor
) {

}
