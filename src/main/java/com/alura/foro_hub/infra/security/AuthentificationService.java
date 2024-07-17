package com.alura.foro_hub.infra.security;

import com.alura.foro_hub.domain.usuario.IUsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthentificationService implements UserDetailsService {

    @Autowired
    private IUsuarioRepository iUsuarioRepositoryuser;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return iUsuarioRepositoryuser.findByName(name);
    }
}