package ForoHub.demo.Controller;

import ForoHub.demo.Domain.respuesta.DatosRegistroRespuesta;
import ForoHub.demo.Domain.respuesta.Respuesta;
import ForoHub.demo.Domain.respuesta.RespuestaRepository;
import ForoHub.demo.Domain.topico.TopicoRepository;
import ForoHub.demo.Domain.usuario.UsuarioRepository;
import ForoHub.demo.infra.security.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

    @Autowired
    private RespuestaService service;


    @PostMapping
    @Transactional
    public ResponseEntity crear(@RequestBody DatosRegistroRespuesta datos) {

        var respuesta = service.crear(datos);

        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/{id}")
    public ResponseEntity obtener(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

}

