package med.voll.apimediciner.domain.consulta.validador;

import med.voll.apimediciner.domain.consulta.DadosAgendamentoConsulta;
import med.voll.apimediciner.util.exception.ValidationConsultaException;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class HorarioAntecedencia implements ValidadorAgendamentoConsulta {

    public void validar(DadosAgendamentoConsulta dados){

        var dadosConsulta = dados.data();
        var agora = dadosConsulta.toLocalTime();
        var diferencaEmMinutos = Duration.between(agora, dadosConsulta).toMinutes();

        if(diferencaEmMinutos < 30){
            throw new ValidationConsultaException("Horario menor do que o minimo para marcar um consulta!");
        }
    }
}
