package br.com.gym.gymcontrol.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.gym.gymcontrol.model.Aluno;

@Service
public interface AlunoService {
    List<Aluno> buscarAlunos();

    Aluno inserirAluno(Aluno aluno);

    Aluno buscarAlunoPorId(Long id);

    void deletarAlunoPorId(Aluno aluno);

}
