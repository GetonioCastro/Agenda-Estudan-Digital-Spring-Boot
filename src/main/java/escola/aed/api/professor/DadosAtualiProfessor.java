package escola.aed.api.professor;

import escola.aed.api.endereco.Endereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualiProfessor(@NotNull Long id, String nome, String telefone) {
}
