package med.voll.apimediciner.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.apimediciner.medico.DadosCadastroMedico;
import med.voll.apimediciner.medico.DadosListagemMedico;
import med.voll.apimediciner.medico.Medico;
import med.voll.apimediciner.medico.MedicoRepository;
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
    public List<DadosListagemMedico> listar(){

        return repository.findAll().stream().map(DadosListagemMedico::new).toList();

    }

}
