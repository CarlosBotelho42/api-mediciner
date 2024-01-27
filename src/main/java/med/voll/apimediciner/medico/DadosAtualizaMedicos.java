package med.voll.apimediciner.medico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.apimediciner.endereco.DadosEndereco;

public record DadosAtualizaMedicos(

        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco dadosEndereco) {

}
