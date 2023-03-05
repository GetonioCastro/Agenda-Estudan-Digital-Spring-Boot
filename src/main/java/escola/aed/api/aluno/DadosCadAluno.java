package escola.aed.api.aluno;

import escola.aed.api.endereco.DadosEndereco;

public record DadosCadAluno(
        String nome,
        String nomeResponsavel,
        String matricula,
        String telefone,
        String cpf,
        DadosEndereco endereco) {
}
