package escola.aed.api.aluno;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarAluno(@NotNull Long id, String nome, String matricula) {
}
