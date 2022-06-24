package br.com.gym.gymcontrol.repository;

import br.com.gym.gymcontrol.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    @Query("SELECT a FROM Aluno a JOIN a.turmas t WHERE t.id = :idTurma")
    List<Aluno> buscarAlunosPorTurma(@Param("idTurma") Long idTurma);
}

