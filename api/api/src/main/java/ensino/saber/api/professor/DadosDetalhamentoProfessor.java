package ensino.saber.api.professor;

public record DadosDetalhamentoProfessor(String nome,
                                         String email,
                                         String telefone,
                                         Disciplina disciplina) {

    public DadosDetalhamentoProfessor(Professor dados){
        this(dados.getNome(), dados.getEmail(), dados.getTelefone(), dados.getDisciplina());
    }
}
