package com.alura.foro_hub.domain.usuario;

import jakarta.validation.constraints.NotBlank;

import javax.swing.*;

public record DatosAuteticacionUsuario(
        @NotBlank
        String nombre,
        @NotBlank
        String clave
) {
}
