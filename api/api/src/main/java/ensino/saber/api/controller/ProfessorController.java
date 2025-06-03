package ensino.saber.api.controller;


import ensino.saber.api.professor.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public Page<DadosDetalhamentoProfessor> listarProfessores(@PageableDefault(size=5, sort={"nome"})Pageable paginacao){
        Page<Professor> professores = repositorio.findAll(paginacao);
        return professores.map(DadosDetalhamentoProfessor::new);
    }

    @PutMapping
    @Transactional
    public void atualizarProfessores(@RequestBody @Valid DadosAtualizacaoProfessor dados){
        Professor professorAtualizar = repositorio.getReferenceById(dados.id());
        professorAtualizar.atualizarDados(dados);
    }
}
