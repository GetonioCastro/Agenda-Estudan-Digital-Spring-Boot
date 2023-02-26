package escola.aed.api.controller;

import escola.aed.api.Aluno.DadosCadAluno;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("alunos")
public class AlunoController {
    @PostMapping
    public void CadastrarAluno(@RequestBody DadosCadAluno dadosAluno){
        System.out.println(dadosAluno);
    }
}
