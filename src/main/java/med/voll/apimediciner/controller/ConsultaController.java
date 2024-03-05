package med.voll.apimediciner.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.apimediciner.domain.consulta.DadosAgendamentoConsulta;
import med.voll.apimediciner.domain.consulta.DadosDetalheConsulta;
import med.voll.apimediciner.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService agendarConsulta;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsulta dados){
        agendarConsulta.agendar(dados);
        return ResponseEntity.ok(new DadosDetalheConsulta(null, null, null, null));

    }

}
