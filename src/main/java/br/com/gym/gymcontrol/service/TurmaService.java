package br.com.gym.gymcontrol.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gym.gymcontrol.model.Turma;
import br.com.gym.gymcontrol.repository.TurmaRepository;

import java.util.List;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;
    
    public Turma cadastrarTurma(Turma turma) {
	return turmaRepository.save(turma);
    }
    public List<Turma> getTurmas(){
        return turmaRepository.findAll();
    }
}
