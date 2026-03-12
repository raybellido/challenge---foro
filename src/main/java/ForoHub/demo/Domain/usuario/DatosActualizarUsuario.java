package ForoHub.demo.Domain.usuario;

import ForoHub.demo.Domain.topico.Estado;

public record DatosActualizarUsuario(String login,
                                     String nombre,
                                     String contrasena,
                                     String apellido,
                                     String email
                                     ) {
    public DatosActualizarUsuario(Usuario datos) {
        this(datos.getLogin(),datos.getNombre(), datos.getEmail(),datos.getContrasena(),datos.getApellido());
    }
}
