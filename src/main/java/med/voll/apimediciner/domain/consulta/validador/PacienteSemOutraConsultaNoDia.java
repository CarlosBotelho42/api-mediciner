package med.voll.apimediciner.domain.consulta.validador;

import med.voll.apimediciner.domain.consulta.ConsultaRepositry;
import med.voll.apimediciner.domain.consulta.DadosAgendamentoConsulta;
import med.voll.apimediciner.domain.paciente.PacienteRepository;
import med.voll.apimediciner.util.exception.ValidationConsultaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PacienteSemOutraConsultaNoDia implements ValidadorAgendamentoConsulta{

    @Autowired
    private ConsultaRepositry repository;

    public void validar(DadosAgendamentoConsulta dados){

        var primeiroHorario = dados.data().withHour(7);
        var  ultimoHorario = dados.data().withHour(18);
        var pacientePossuiAgendamentoNoDia = repository.existsByPacienteIdAndDataBetween(dados.idPaciente(), primeiroHorario, ultimoHorario);

        if (pacientePossuiAgendamentoNoDia){
            throw new ValidationConsultaException("Paciente já possui agendamento para esse dia!!");
        }
    }

}
