package br.com.gym.gymcontrol.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.gym.gymcontrol.model.Pessoa;
import br.com.gym.gymcontrol.model.dto.PessoaDto;

public interface PessoaService {
	Page<Pessoa> getPessoas(Pageable page);

	Pessoa inserirPessoa(Pessoa pessoa);

	Pessoa buscarPessoaPorId(Long id);

	PessoaDto pessoaParaPessoaDto(Pessoa pessoa);

	List<Pessoa> buscarPessoaPorNome(String nome);

	void deletarPessoa(Pessoa pessoa);
}
