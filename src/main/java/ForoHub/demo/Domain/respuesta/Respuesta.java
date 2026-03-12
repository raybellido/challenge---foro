package ForoHub.demo.Domain.respuesta;

import ForoHub.demo.Domain.topico.Topico;
import ForoHub.demo.Domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode(of = "id")
    @Table(name = "respuestas")
    @Entity(name = "Respuesta")

    public class Respuesta {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String mensaje;

        private LocalDateTime fechaCreacion;

        @ManyToOne
        @JoinColumn(name = "usuario_id")
        private Usuario autor;

        @ManyToOne
        @JoinColumn(name = "topico_id")
        private Topico topico;

        public Respuesta(String mensaje, Usuario autor, Topico topico) {
            this.mensaje = mensaje;
            this.autor = autor;
            this.topico = topico;
        }

        @PrePersist
        public void prePersist() {
            this.fechaCreacion = LocalDateTime.now();
        }


    }