package med.voll.apimediciner.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.apimediciner.domain.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico dados, UriComponentsBuilder uriBuilder){
        var medico = new Medico(dados);
        repository.save(medico);
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhesMedico(medico));
    }



    @GetMapping
    public ResponseEntity<Page<DadosListagemMedico>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable){
        var page =  repository.findAllByAtivoTrue(pageable).map(DadosListagemMedico::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizaMedicos dados){
        var medico = repository.getReferenceById(dados.id());
        medico.atualizaInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhesMedico(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleta(@PathVariable Long id){
        var medido = repository.getReferenceById(id);
        medido.desativar();

        return ResponseEntity.noContent().build();

    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity detalharPorId(@PathVariable Long id){
        var medido = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhesMedico(medido));

    }

}
