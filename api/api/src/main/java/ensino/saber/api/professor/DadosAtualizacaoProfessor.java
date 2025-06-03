package ensino.saber.api.professor;

import ensino.saber.api.endereco.DadosAtualizacaoEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoProfessor(

        @NotNull
        Long id,
        String nome,
        String email,
        String telefone,
        Disciplina disciplina,
        DadosAtualizacaoEndereco endereco
) {
}
