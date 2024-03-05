
package med.voll.apimediciner.domain.consulta.validador;

import med.voll.apimediciner.domain.consulta.ConsultaRepositry;
import med.voll.apimediciner.domain.consulta.DadosAgendamentoConsulta;
import med.voll.apimediciner.domain.medico.MedicoRepository;
import med.voll.apimediciner.util.exception.ValidationConsultaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicoComOutraConsultaNoMesmoHorario implements ValidadorAgendamentoConsulta{

    @Autowired
    private ConsultaRepositry repository;

    public void validar(DadosAgendamentoConsulta dados){

        var medicoConsultadaNoMesmoHoraio = repository.existsByMedicoIdAndData(dados.idMedico(), dados.data());
        if (medicoConsultadaNoMesmoHoraio){
            throw new ValidationConsultaException("Medico não disponivel nesse horaio!");
        }
    }
}