package escola.aed.api.controller;

import escola.aed.api.professor.DadosCadProfessor;
import escola.aed.api.professor.Professor;
import escola.aed.api.professor.ProfessorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("professores")
public class ProfessorController {
    @Autowired
    private ProfessorRepository repository;
    @PostMapping
    public void casdastrar(@RequestBody @Valid DadosCadProfessor dados){
        repository.save(new Professor(dados));
    }
}
