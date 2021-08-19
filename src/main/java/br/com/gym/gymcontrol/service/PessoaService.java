package br.com.gym.gymcontrol.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import br.com.gym.gymcontrol.model.Pessoa;
import br.com.gym.gymcontrol.model.dto.PessoaDto;
import br.com.gym.gymcontrol.repository.PessoaRepository;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Page<Pessoa> getPessoas(Pageable page) {
	return pessoaRepository.findAll(page);
    }

    public Pessoa inserirPessoa(Pessoa pessoa) {
	return pessoaRepository.save(pessoa);
    }

    public Pessoa buscarPessoaPorId(Long id) {
	Optional<Pessoa> optional = pessoaRepository.findById(id);
	return optional.orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
    }

    public PessoaDto pessoaParaPessoaDto(Pessoa pessoa) {
	return new PessoaDto(pessoa);
    }

    public List<Pessoa> buscarPessoaPorNome(String nome) {
	return pessoaRepository.findByNomeContainingIgnoreCase(nome);
    }
}
