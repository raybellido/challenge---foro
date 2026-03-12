package ForoHub.demo.Domain.topico;

import ForoHub.demo.Domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaDeCreacion;

    @Enumerated(EnumType.STRING)
    private Estado status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario autor;

    private String curso;

    public Topico(DatosRegistroForo datos) {
        this.id=null;
        this.titulo= datos.titulo();
        this.mensaje=datos.mensaje();
        this.status=datos.status();
        this.autor=datos.autor();
        this.curso= datos.curso();
    }

    @PrePersist
    public void prePersist() {
        this.fechaDeCreacion = LocalDateTime.now();
        
    }

    public void actualizarDatosInformacion(@Valid DatosActualizarForo datos) {
        if (datos.titulo() != null) {
            this.titulo = datos.titulo();
        }

        if (datos.mensaje() != null) {
            this.mensaje = datos.mensaje();
        }

        if (datos.curso() != null) {
            this.curso = datos.curso();
        }

        if (datos.status() != null) {
            this.status = datos.status();
        }
    }
}
