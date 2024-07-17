package com.alura.foro_hub.infra.security;

import com.alura.foro_hub.domain.usuario.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthentificationService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepositoryuser;

    @Override
    public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
        return usuarioRepositoryuser.findByNombre(nombre);
    }
}