package br.com.gym.gymcontrol.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
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

    public List<Turma> getTurmas() {
        List<Turma> turmas = turmaRepository.findAll();
        verificarListaVazia(turmas);
        return turmas;
    }

    private void verificarListaVazia(List<Turma> turmas) {
        if (turmas.isEmpty()) {
            throw new ResourceNotFoundException("Nenhuma turma encontrada");
        }
    }

    public void inserir(Turma turma) {
        turmaRepository.save(turma);
    }
}
