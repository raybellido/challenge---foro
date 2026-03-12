package ForoHub.demo.Domain.usuario;

import java.time.LocalDateTime;

public record DatosDetalleUsuario(
        Long id,
        String login,
        String nombre,
        String apellido,
        String email,
        Role role,
        LocalDateTime dateTime
) {
    public DatosDetalleUsuario(Usuario usuario){
        this(usuario.getId(),
                usuario.getLogin(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getEmail(),
                usuario.getRole(),
                usuario.getDateTime()
        );
    }

}
