package escola.aed.api.professor;

public record NomesProfessor(Long id,String nome, String telefone) {
    public NomesProfessor(Professor professor){
        this(professor.getId(), professor.getNome(),professor.getTelefone());
    }
}
