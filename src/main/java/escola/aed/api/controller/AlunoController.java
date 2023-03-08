package escola.aed.api.controller;

import escola.aed.api.aluno.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @GetMapping
    public List<ListaAlunos> ListarAlunos(){
        return alunoRepository.findAll().stream().map(ListaAlunos::new).toList();
    }

    @PutMapping
    @Transactional
    public void AtualizarAluno(@RequestBody @Valid DadosAtualizarAluno dados){
        Aluno aluno = alunoRepository.getReferenceById(dados.id());
        aluno.atualizarInfAluno(dados);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteAluno(@PathVariable Long id){
        alunoRepository.deleteById(id);
    }


}
