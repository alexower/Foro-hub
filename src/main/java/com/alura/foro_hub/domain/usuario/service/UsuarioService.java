package com.alura.foro_hub.domain.usuario.service;

import com.alura.foro_hub.domain.topicos.Topico;
import com.alura.foro_hub.domain.topicos.TopicoRespository;
import com.alura.foro_hub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private TopicoRespository topicoRespository;

    public void encryptPassword(Topico topico) {
        topico.getAutor().setClave(passwordEncoder.encode(topico.getAutor().getPassword()));
        topico.getResponses()
                .forEach(r -> r.getAutor().setClave(passwordEncoder.encode(r.getAutor().getPassword())));
        userRepository.save(topico.getAutor());
        topicoRespository.save(topico);
    }
}