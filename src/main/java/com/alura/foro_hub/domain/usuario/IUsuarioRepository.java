package com.alura.foro_hub.domain.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface IUsuarioRepository extends JpaRepository <Usuario, Long> {

    UserDetails findByName(String nombre);
}
