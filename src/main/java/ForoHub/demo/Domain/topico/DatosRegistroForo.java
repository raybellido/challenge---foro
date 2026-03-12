package ForoHub.demo.Domain.topico;

import ForoHub.demo.Domain.usuario.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroForo(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotNull Estado status,
        @NotBlank Usuario autor,
        @NotBlank String curso
) {
}
