package ForoHub.demo.Controller;

import ForoHub.demo.topico.DatosRegistroForo;
import ForoHub.demo.topico.Topico;
import ForoHub.demo.topico.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foro")
public class ForoController {

    @Autowired
    private TopicoRepository repository;

    @Transactional
    @PostMapping
    public void registrar(@RequestBody @Valid DatosRegistroForo datos){
        repository.save(new Topico(datos));
    }

    @GetMapping
    public Page<Topico> listar(@PageableDefault(size = 10 , sort = {"fechaDeCreacion"}) Pageable paginacion){
        return repository.findAll(paginacion);

    }

}
