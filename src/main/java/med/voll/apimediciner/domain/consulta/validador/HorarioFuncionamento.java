package med.voll.apimediciner.domain.consulta.validador;

import med.voll.apimediciner.domain.consulta.DadosAgendamentoConsulta;
import med.voll.apimediciner.util.exception.ValidationConsultaException;

import java.time.DayOfWeek;

public class HorarioFuncionamento {

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
