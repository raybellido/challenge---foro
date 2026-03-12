package ForoHub.demo.Controller;

import ForoHub.demo.Domain.topico.Topico;
import ForoHub.demo.Domain.usuario.*;
import ForoHub.demo.infra.security.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private UsuarioService service;

    @Transactional
    @PostMapping
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistroUsuario datos, UriComponentsBuilder uriComponentsBuilder){
        var usuario = service.registrar(datos);
        return ResponseEntity.ok().body(new DatosDetalleUsuario(usuario));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosDetalleUsuario> listarDetallado(@PathVariable Long id){
        var usuario = repository.getReferenceById(id);
        return ResponseEntity.ok(new DatosDetalleUsuario(usuario));
    }

    @GetMapping
    public ResponseEntity<Page<Usuario>> listar(@PageableDefault(size = 10 ) Pageable paginacion){
        var page = repository.findAll(paginacion);
        return ResponseEntity.ok(page);}

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity actualizar (@RequestBody @Valid DatosActualizarUsuario datos, @PathVariable Long id){
        var usuario = repository.getReferenceById(id);
        usuario.actualizarDatosInformacion(datos);
        return ResponseEntity.ok(new DatosActualizarUsuario(usuario));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build()   ;
    }


}
