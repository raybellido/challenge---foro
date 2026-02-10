package ForoHub.demo.topico;

import jakarta.persistence.*;
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
    private String autor;
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

}
