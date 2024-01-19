package med.voll.apimediciner.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(

        @NotBlank
        String logradouro,

        @NotBlank
        String bairro,

        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String cep,

        String numero,

        String complemento,

        @NotBlank
        String cidade,

        @NotBlank
        String uf

) {
}
