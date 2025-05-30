package ensino.saber.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Embeddable
public class Endereco {

    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
    private String numero;
    private String complemento;

    public Endereco(DadosEndereco dados){
        this.bairro = dados.bairro();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
        this.cep = dados.cep();
        this.numero = dados.numero();
        this.complemento = dados.complemento();

    }
}
