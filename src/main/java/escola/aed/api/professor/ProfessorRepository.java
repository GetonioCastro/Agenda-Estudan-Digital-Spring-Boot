package escola.aed.api.professor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

   Page<Professor> findAllByStatusTrue(Pageable paginacao); //findAllByStatusTrue - lista apenas os professores de STATUS True
}
