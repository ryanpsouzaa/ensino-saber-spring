package ensino.saber.api.professor;

import com.fasterxml.jackson.annotation.JsonAlias;
import ensino.saber.api.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroProfessor(

        @NotBlank
        String nome,

        @NotNull
        @Email
        String email,

        @NotNull
        Disciplina disciplina,

        @NotBlank
        String telefone,

        @NotNull @Valid
        DadosEndereco endereco) {
}
