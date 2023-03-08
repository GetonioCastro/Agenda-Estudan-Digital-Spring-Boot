package escola.aed.api.aluno;

public record ListaAlunos(String nome,String matricula) {
    public  ListaAlunos(Aluno aluno){
        this(aluno.getNome(), aluno.getMatricula());
    }
}
