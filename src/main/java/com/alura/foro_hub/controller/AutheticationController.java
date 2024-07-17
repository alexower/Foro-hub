package com.alura.foro_hub.controller;

import com.alura.foro_hub.domain.usuario.DatosAuteticacionUsuario;
import com.alura.foro_hub.domain.usuario.Usuario;
import com.alura.foro_hub.infra.security.DatosJWToken;
import com.alura.foro_hub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutheticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;


    @PostMapping
    public ResponseEntity UserAuthentication(@RequestBody @Valid DatosAuteticacionUsuario datosAuteticacionUsuario) {

        Authentication authToken = new UsernamePasswordAuthenticationToken(
                datosAuteticacionUsuario.nombre(), datosAuteticacionUsuario.clave());

        var authenticatedUser = authenticationManager.authenticate(authToken);

        var JWToken = tokenService.generateToken((Usuario) authenticatedUser.getPrincipal());

        return ResponseEntity.ok(new DatosJWToken(JWToken));
    }

}