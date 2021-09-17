package br.com.gym.gymcontrol.service;

import java.util.List;

import br.com.gym.gymcontrol.model.Turma;

public interface TurmaService {

	Turma cadastrarTurma(Turma turma);

	List<Turma> getTurmas();

	void inserir(Turma turma);
}
