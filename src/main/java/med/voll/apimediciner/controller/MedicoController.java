package med.voll.apimediciner.controller;

import jakarta.transaction.Transactional;
import med.voll.apimediciner.medico.DadosCadastroMedico;
import med.voll.apimediciner.medico.Medico;
import med.voll.apimediciner.medico.MedicoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    private final MedicoRepository repository;

    public MedicoController(MedicoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroMedico dados){
        repository.save(new Medico(dados));
    }

}
