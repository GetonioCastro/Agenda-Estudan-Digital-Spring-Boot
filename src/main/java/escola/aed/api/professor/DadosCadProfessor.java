package escola.aed.api.professor;

import escola.aed.api.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public record DadosCadProfessor(
        @NotBlank
        String nome,
        @NotBlank
        String email,
        String telefone,
        String cpf,
        @NotNull
        Formacao formacao,
        @NotNull
        @Valid
        DadosEndereco endereco) {
}
