package escola.aed.api.aluno;

import escola.aed.api.endereco.Endereco;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="alunos")
@Entity(name="Aluno")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Aluno{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String nomeResponsavel;
    private String matricula;
    private String telefone;
    private String cpf;
    @Embedded
    private Endereco endereco;


    public Aluno(DadosCadAluno dadosAluno){
        this.nome = dadosAluno.nome();
        this.nomeResponsavel = dadosAluno.nomeResponsavel();
        this.matricula = dadosAluno.matricula();
        this.telefone = dadosAluno.telefone();
        this.cpf = dadosAluno.cpf();
        this.endereco = new Endereco(dadosAluno.endereco());
    }

    public void atualizarInfAluno(DadosAtualizarAluno dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.matricula() != null){
            this.matricula = dados.matricula();
        }

    }
}
