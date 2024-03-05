
package med.voll.apimediciner.domain.consulta.validador;

import med.voll.apimediciner.domain.consulta.DadosAgendamentoConsulta;
import med.voll.apimediciner.domain.medico.MedicoRepository;
import med.voll.apimediciner.util.exception.ValidationConsultaException;
import org.springframework.stereotype.Component;

@Component
public class MedicoComOutraConsultaNoMesmoHorario implements ValidadorAgendamentoConsulta{

    private MedicoRepository repository;

    public void validar(DadosAgendamentoConsulta dados){

        var medicoConsultadaNoMesmoHoraio = repository.existsByMedicoIdAndData(dados.idMedico());
        if (medicoConsultadaNoMesmoHoraio){
            throw new ValidationConsultaException("Medico não disponivel nesse horaio!");
        }
    }
}