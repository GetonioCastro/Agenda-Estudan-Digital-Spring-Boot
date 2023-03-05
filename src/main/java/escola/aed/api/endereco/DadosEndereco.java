package escola.aed.api.endereco;

public record DadosEndereco(
        String logradouro,
        String rua,
        String bairro,
        String cep,
        String cidade,
        String uf,
        String numero,
        String complemento) {
}
