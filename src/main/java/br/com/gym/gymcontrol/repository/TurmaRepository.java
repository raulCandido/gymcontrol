package br.com.gym.gymcontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gym.gymcontrol.model.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {

}
