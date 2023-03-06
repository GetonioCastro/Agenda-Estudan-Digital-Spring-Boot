package escola.aed.api.professor;

import escola.aed.api.endereco.Endereco;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="professores")
@Entity(name="Professor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Professor{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    @Enumerated(EnumType.STRING)
    private Formacao formacao;
    @Embedded
    private Endereco endereco;

    private Boolean status;

    public Professor(DadosCadProfessor dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.formacao = dados.formacao();
        this.endereco = new Endereco(dados.endereco());
        this.status = true;

    }

    public void atualizarInfProfessor(DadosAtualiProfessor dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.telefone() != null){
            this.telefone = dados.telefone();
        }
    }

    public void excluirProfessor() {
        this.status = false;
    }
}
