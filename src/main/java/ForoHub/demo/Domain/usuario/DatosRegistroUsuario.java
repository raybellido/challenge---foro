package ForoHub.demo.Domain.usuario;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistroUsuario(

        @NotNull String login,
        @NotNull String contrasena,
        @NotNull String nombre,
        @NotNull String apellido,
        @NotNull String email


        ) { }
