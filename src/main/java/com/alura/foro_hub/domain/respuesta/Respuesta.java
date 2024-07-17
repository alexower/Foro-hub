package com.alura.foro_hub.domain.respuesta;


import com.alura.foro_hub.domain.topicos.Topico;
import com.alura.foro_hub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "respuestas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;
    private LocalDateTime fecha;
    private Boolean solucion;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "topico_id", referencedColumnName = "id")
    private Topico topico;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "autor_id", referencedColumnName = "id")
    private Usuario autor;


    public Respuesta(DatosRespuesta data, Topico topico) {
        this.mensaje = data.mensaje();
        this.fecha = data.fecha();
        this.solucion = data.solucion();
        this.topico = topico;
        this.autor = new Usuario(data.autor());
    }
}
