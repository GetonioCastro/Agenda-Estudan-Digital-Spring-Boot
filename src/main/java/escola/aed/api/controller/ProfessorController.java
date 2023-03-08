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
@RequestMapping("/professores")
public class ProfessorController {
    @Autowired
    private ProfessorRepository repository;

    @PostMapping
    @Transactional
    public void casdastrar(@RequestBody @Valid DadosCadProfessor dados){
        repository.save(new Professor(dados));
    }

    /*
    @GetMapping
    public List<NomesProfessor> pesquisarProfessor(){
        return repository.findAll().stream().map(NomesProfessor::new).toList();
    }*/
    @GetMapping //mapea requisição GET da classe
    public Page<NomesProfessor> pesquisarProfessor(@PageableDefault(size=5, sort = {"nome"}) Pageable paginacao){
        return repository.findAllByStatusTrue(paginacao).map(NomesProfessor::new);
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
