package br.com.gym.gymcontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.gym.gymcontrol.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>, ProfessorRepositoryCustom {

}