package med.voll.apimediciner.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.apimediciner.medico.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    private final MedicoRepository repository;

    public MedicoController(MedicoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable){
        return repository.findAllByAtivoTrue(pageable).map(DadosListagemMedico::new);

    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizaMedicos dados){
        var medido = repository.getReferenceById(dados.id());
        medido.atualizaInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleta(@PathVariable Long id){
        var medido = repository.getReferenceById(id);
        medido.desativar();

    }

}
