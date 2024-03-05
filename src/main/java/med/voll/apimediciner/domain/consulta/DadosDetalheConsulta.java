package med.voll.apimediciner.domain.consulta;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosDetalheConsulta(

        Long id,
        Long idMedico,
        Long idPaciente,
        LocalDateTime data

) {

    public DadosDetalheConsulta(Consulta consulta) {
        this(consulta.getId(), consulta.getMedico().getId(), consulta.getPaciente().getId(),consulta.getData());
    }
}
