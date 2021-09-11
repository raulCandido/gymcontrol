package br.com.gym.gymcontrol.service;

import java.util.List;


import br.com.gym.gymcontrol.model.Aluno;


public interface AlunoService {
    List<Aluno> buscarAlunos();

    Aluno inserirAluno(Aluno aluno);

    Aluno buscarAlunoPorId(Long id);

    void deletarAlunoPorId(Aluno aluno);

}
