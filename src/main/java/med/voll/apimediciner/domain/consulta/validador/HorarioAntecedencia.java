package med.voll.apimediciner.domain.consulta.validador;

import med.voll.apimediciner.domain.consulta.DadosAgendamentoConsulta;
import med.voll.apimediciner.util.exception.ValidationConsultaException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class HorarioAntecedencia implements ValidadorAgendamentoConsulta {

    public void validar(DadosAgendamentoConsulta dados){

        var dadosConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, dadosConsulta).toMinutes();

        if(diferencaEmMinutos < 30){
            throw new ValidationConsultaException("Consulta deve ser agendada com antecedência mínima de 30 minutos");
        }
    }
}
