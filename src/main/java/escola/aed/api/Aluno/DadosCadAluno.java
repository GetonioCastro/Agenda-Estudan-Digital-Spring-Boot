package escola.aed.api.Aluno;

import escola.aed.api.endereco.DadosEndereco;

public record DadosCadAluno(String nome,String nomeResponsavel,String matricula,String telefone,String cpf,DadosEndereco endereco) {
}
