package br.com.gym.gymcontrol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gym.gymcontrol.model.Pessoa;
import br.com.gym.gymcontrol.repository.PessoaRepository;

@Service
public class PessoaService {
    
    @Autowired
    private PessoaRepository pessoaRepository;
    
    public List<Pessoa> getPessoas(){
	return pessoaRepository.findAll();
    }

    public Pessoa inserirPessoa(Pessoa pessoa) {
	return pessoaRepository.save(pessoa);
    }
    
}
