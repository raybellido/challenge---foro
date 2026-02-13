package ForoHub.demo.topico;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarForo(
        String titulo,
        String mensaje,
        Estado status,
        String autor,
        String curso
){
    public DatosActualizarForo(Topico topico) {
        this(topico.getTitulo(), topico.getMensaje(), topico.getStatus(), topico.getAutor(), topico.getCurso());
    }
}