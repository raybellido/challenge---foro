package ForoHub.demo.Controller;

import ForoHub.demo.Domain.topico.*;
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
@RequestMapping("/foro")
public class ForoController {

    @Autowired
    private TopicoRepository repository;

    @Transactional
    @PostMapping
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistroForo datos, UriComponentsBuilder uriComponentsBuilder){

        var topico = new Topico(datos);
        repository.save(topico);
        var uri = uriComponentsBuilder.path("/foro/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DatosDetalleTopico(topico));
    }

    @GetMapping
    public ResponseEntity<Page<Topico>> listar(@PageableDefault(size = 10 , sort = {"fechaDeCreacion"}) Pageable paginacion){
        var page = repository.findAll(paginacion);
        return ResponseEntity.ok(page);

    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosDetalleTopico> listarDetallado(@PathVariable Long id){
        var topico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DatosDetalleTopico(topico));

    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity actualizar (@RequestBody @Valid DatosActualizarForo datos, @PathVariable Long id){
        var topico = repository.getReferenceById(id);
        topico.actualizarDatosInformacion(datos);
        return ResponseEntity.ok(new DatosActualizarForo(topico));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build()   ;
    }
}
