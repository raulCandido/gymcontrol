package br.com.gym.gymcontrol.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gym.gymcontrol.model.Usuario;

public interface UsuariorRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}
