package ForoHub.demo.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroForo(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotNull Estado status,
        @NotBlank String autor,
        @NotBlank String curso
) {
}
