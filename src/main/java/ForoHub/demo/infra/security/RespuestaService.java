package ForoHub.demo.infra.security;

import ForoHub.demo.Domain.respuesta.DatosRegistroRespuesta;
import ForoHub.demo.Domain.respuesta.Respuesta;
import ForoHub.demo.Domain.respuesta.RespuestaRepository;
import ForoHub.demo.Domain.topico.TopicoRepository;
import ForoHub.demo.Domain.usuario.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RespuestaService {

    private final RespuestaRepository respuestaRepository;
    private final UsuarioRepository usuarioRepository;
    private final TopicoRepository topicoRepository;


    public Respuesta crear(DatosRegistroRespuesta datos) {

        var usuario = usuarioRepository.findById(datos.usuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        var topico = topicoRepository.findById(datos.topicoId())
                .orElseThrow(() -> new RuntimeException("Topico no encontrado"));

        var respuesta = new Respuesta(datos.mensaje(), usuario, topico);

        return respuestaRepository.save(respuesta);
    }

    public @Nullable Object buscarPorId(Long id) {
        return respuestaRepository.findById(id)
                .orElseThrow(()->new RuntimeException("respuesta no enceotnrada"));
    }
}
