package ensino.saber.api.controller;


import ensino.saber.api.professor.DadosCadastroProfessor;
import ensino.saber.api.professor.Professor;
import ensino.saber.api.professor.ProfessorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("professor")
public class ProfessorController {

    @Autowired
    private ProfessorRepository repositorio;

    @PostMapping
    @Transactional
    public void cadastrarProfessor(@RequestBody @Valid DadosCadastroProfessor dados){
        Professor professor = new Professor(dados);
        repositorio.save(professor);
    }
}
