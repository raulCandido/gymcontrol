package br.com.gym.gymcontrol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gym.gymcontrol.model.Aluno;
import br.com.gym.gymcontrol.repository.AlunoRepository;

@Service
public class AlunoService {
    
    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> buscarAlunos() {
	return alunoRepository.findAll();
    }



}
