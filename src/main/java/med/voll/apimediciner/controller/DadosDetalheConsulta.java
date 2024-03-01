package med.voll.apimediciner.controller;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosDetalheConsulta(

        Long id,
        Long idMedico,
        Long idPaciente,
        LocalDateTime data

) {
}
