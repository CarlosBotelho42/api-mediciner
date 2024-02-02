package med.voll.apimediciner.domain.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.apimediciner.domain.endereco.DadosEndereco;

public record DadosAtualizaMedicos(

        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco dadosEndereco) {

}
