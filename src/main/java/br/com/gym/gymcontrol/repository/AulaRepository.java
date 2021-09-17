package br.com.gym.gymcontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gym.gymcontrol.model.Aula;

@Repository
public interface AulaRepository extends JpaRepository<Aula, Long> {

}
