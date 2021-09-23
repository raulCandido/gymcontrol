package br.com.gym.gymcontrol.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gym.gymcontrol.model.Pessoa;
import br.com.gym.gymcontrol.model.TipoPessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    
    List<Pessoa> findByNome(String nome);

    List<Pessoa> findByNomeContainingIgnoreCase(String nome);

    List<Pessoa> findByTipoPessoa(TipoPessoa tipoPessoa);
}
