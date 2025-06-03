package ensino.saber.api.endereco;

public record DadosAtualizacaoEndereco(

        String bairro,
        String cidade,
        String uf,
        String cep,
        String numero,
        String complemento
) {
}
