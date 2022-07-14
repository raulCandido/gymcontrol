package br.com.gym.gymcontrol.repository;

import br.com.gym.gymcontrol.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>, ProfessorRepositoryCustom {

}
