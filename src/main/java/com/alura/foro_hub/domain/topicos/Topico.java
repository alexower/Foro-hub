package com.alura.foro_hub.domain.topicos;

import com.alura.foro_hub.domain.curso.Curso;
import com.alura.foro_hub.domain.respuesta.Respuesta;
import com.alura.foro_hub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity(name = "topico")
@Table(name = "topicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    @Column(unique = true)
    private String mensaje;
    private LocalDateTime fecha;
    private Boolean estatus;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "autor_id", referencedColumnName = "id")
    private Usuario autor;
    @Enumerated(EnumType.STRING)
    private Curso curso;
    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Respuesta> responses = new ArrayList<>();



    //constructor
    public Topico(String titulo, String mensaje, Usuario autor, Curso curso) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fecha = LocalDateTime.now();
        this.estatus = false;
        this.autor = autor;
        this.curso = curso;
    }

    public Topico (DatosTopico data) {
        this.titulo = data.titulo();
        this.mensaje = data.mensaje();
        this.fecha = data.fecha();
        this.estatus = true;
        this.autor = new Usuario(data.autor());
        this.curso = data.curso();
        this.responses = data.respuestas().stream()
                .map(r -> new Respuesta(r, this))
                .collect(Collectors.toList());
    }

}
