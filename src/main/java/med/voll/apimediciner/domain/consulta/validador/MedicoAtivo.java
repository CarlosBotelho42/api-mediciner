package med.voll.apimediciner.domain.consulta.validador;

import med.voll.apimediciner.domain.consulta.DadosAgendamentoConsulta;
import med.voll.apimediciner.domain.medico.MedicoRepository;
import med.voll.apimediciner.util.exception.ValidationConsultaException;
import org.springframework.stereotype.Component;

@Component
public class MedicoAtivo implements ValidadorAgendamentoConsulta{

    private MedicoRepository repository;

    public void validar(DadosAgendamentoConsulta dados){

        if (dados.idMedico() == null){
            return;
        }

        var medicoAtivo = repository.findAtivoById(dados.idMedico());
        if(!medicoAtivo){
            throw new ValidationConsultaException("Medico escolhico nao existe!");
        }
    }
}
