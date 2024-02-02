package med.voll.apimediciner.domain.paciente;

import jakarta.validation.constraints.NotNull;
import med.voll.apimediciner.domain.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
