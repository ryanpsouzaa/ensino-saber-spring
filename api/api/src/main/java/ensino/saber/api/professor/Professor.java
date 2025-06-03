package ensino.saber.api.professor;

import ensino.saber.api.endereco.Endereco;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Entity(name = "professor")
@Table(name = "professores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    @Enumerated(EnumType.STRING)
    private Disciplina disciplina;

    private String telefone;

    @Embedded
    private Endereco endereco;

    public Professor(DadosCadastroProfessor dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.disciplina = dados.disciplina();
        this.telefone = dados.telefone();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarDados(DadosAtualizacaoProfessor dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.email() != null) {
            this.email = dados.email();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.disciplina() != null) {
            this.disciplina = dados.disciplina();
        }
        if (dados.endereco() != null) {
            this.endereco.atualizarDados(dados.endereco());
        }
    }
}
