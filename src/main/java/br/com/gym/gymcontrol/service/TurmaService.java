package br.com.gym.gymcontrol.service;

import java.util.List;

import javax.validation.Valid;

import br.com.gym.gymcontrol.model.Turma;
import br.com.gym.gymcontrol.model.form.TurmaForm;

public interface TurmaService {

    Turma cadastrarTurma(Turma turma);

    List<Turma> getTurmas();

    void inserir(Turma turma);

    void buscarEditarTurma(Long id, @Valid TurmaForm turmaForm);

    Turma buscarTurmaPorId(Long id);

    List<Turma> buscarTurmasPorIds(List<Long> ids);
}
