package br.com.gym.gymcontrol.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import br.com.gym.gymcontrol.model.Pessoa;
import br.com.gym.gymcontrol.model.dto.PessoaDto;
import br.com.gym.gymcontrol.repository.PessoaRepository;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> getPessoas() {
	return pessoaRepository.findAll();
    }

    public Pessoa inserirPessoa(Pessoa pessoa) {
	return pessoaRepository.save(pessoa);
    }

    public List<PessoaDto> converterPessoasEmPessoasDto(List<Pessoa> pessoas) {
	return pessoas.stream().map(pessoa -> new PessoaDto(pessoa)).collect(Collectors.toList());
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
