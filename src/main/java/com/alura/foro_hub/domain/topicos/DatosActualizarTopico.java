package com.alura.foro_hub.domain.topicos;

import com.alura.foro_hub.domain.curso.Curso;
import com.alura.foro_hub.domain.usuario.DatosUsuario;
import org.jetbrains.annotations.NotNull;

public record DatosActualizarTopico(
        @NotNull
        Long id,
        String titulo,
        String mensaje,
        DatosUsuario autor,
        Curso curso

        ) {
}
