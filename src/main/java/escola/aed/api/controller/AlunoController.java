package escola.aed.api.controller;

import escola.aed.api.aluno.Aluno;
import escola.aed.api.aluno.AlunoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import escola.aed.api.aluno.DadosCadAluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;
    @PostMapping
    @Transactional
    public void cadastrarAluno(@RequestBody @Valid DadosCadAluno dados){
        alunoRepository.save(new Aluno(dados));
    }
}
