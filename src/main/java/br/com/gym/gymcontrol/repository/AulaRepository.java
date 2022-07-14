package br.com.gym.gymcontrol.repository;

import br.com.gym.gymcontrol.model.Aula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AulaRepository extends JpaRepository<Aula, Long> {

}
