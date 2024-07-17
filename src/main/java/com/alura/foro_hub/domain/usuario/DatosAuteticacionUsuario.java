package com.alura.foro_hub.domain.usuario;

import jakarta.validation.constraints.NotBlank;

import javax.swing.*;

public record DatosAuteticacionUsuario(
        @NotBlank
        Spring nombre,
        @NotBlank
        String clave
) {
}
