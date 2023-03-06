package escola.aed.api.controller;

import escola.aed.api.professor.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/professores")//mapea requisição POST da classe Controler
public class ProfessorController {
    @Autowired //injeção de dependências(um ponto aonde a injeção automática deve ser aplicada)
    private ProfessorRepository repository;

    @PostMapping //mapea requisição POST da classe Controler
    @Transactional
    public void casdastrar(@RequestBody @Valid DadosCadProfessor dados){
        repository.save(new Professor(dados));
    }

    /*
    @GetMapping //mapea requisição GET da classe
    public List<NomesProfessor> pesquisarProfessor(){
        return repository.findAll().stream().map(NomesProfessor::new).toList(); //stream().map => convertendo
                                                                                //toList() => converta para uma lista.
    }*/
    @GetMapping //mapea requisição GET da classe
    public Page<NomesProfessor> pesquisarProfessor(@PageableDefault(size=5, sort = {"nome"}) Pageable paginacao){ //Pageable auxilia na hora de consultar
                                                                        // páginas e agrupar quantidade de registros nas páginas.
        return repository.findAllByStatusTrue(paginacao).map(NomesProfessor::new); //findAllByStatusTrue - lista apenas os professores de STATUS True
    }


    @PutMapping
    @Transactional
    public void atualizarProfessor(@RequestBody @Valid DadosAtualiProfessor dados){
        Professor professor = repository.getReferenceById(dados.id());
        professor.atualizarInfProfessor(dados);
    }


   /* @DeleteMapping("/{id}")
    @Transactional
    public void excluirProfessor(@PathVariable Long id){
        repository.deleteById(id);
    }*/

    @DeleteMapping("/{id}")
    @Transactional
    public void excluirProfessor(@PathVariable Long id){
        var professor = repository.getReferenceById(id);
        professor.excluirProfessor();
    }



}
