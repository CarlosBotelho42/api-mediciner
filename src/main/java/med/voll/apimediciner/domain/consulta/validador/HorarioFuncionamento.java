package med.voll.apimediciner.domain.consulta.validador;

import med.voll.apimediciner.domain.consulta.DadosAgendamentoConsulta;
import med.voll.apimediciner.util.exception.ValidationConsultaException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class HorarioFuncionamento implements ValidadorAgendamentoConsulta{

    public void validar(DadosAgendamentoConsulta dados){

        var dataConsulta = dados.data();

        var domindo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesAbertura = dataConsulta.getHour() < 7;
        var depoisAbertura =  dataConsulta.getHour() > 18;

        if (domindo || antesAbertura || depoisAbertura){
            throw new ValidationConsultaException("Horario escolhido fora do funcionamento da clinica!");
        }
    }
}
