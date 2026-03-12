package ForoHub.demo.infra.security;

import ForoHub.demo.Domain.usuario.DatosRegistroUsuario;
import ForoHub.demo.Domain.usuario.Usuario;
import ForoHub.demo.Domain.usuario.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;

    public Usuario registrar(DatosRegistroUsuario datos) {

        var usuario = new Usuario(datos);

        usuario.setContrasena(passwordEncoder.encode(datos.contrasena()));

        return repository.save(usuario);
    }
}
