package br.com.gym.gymcontrol.service;

import br.com.gym.gymcontrol.model.Turma;
import br.com.gym.gymcontrol.model.dto.TurmaComProfessorVinculadoRecord;
import br.com.gym.gymcontrol.model.form.TurmaForm;

import javax.validation.Valid;
import java.util.List;

public interface TurmaService {

    Turma cadastrarTurma(TurmaForm turmaForm);

    List<Turma> getTurmas();

    void inserir(Turma turma);

    void buscarEditarTurma(Long id, @Valid TurmaForm turmaForm);

    Turma buscarTurmaPorId(Long id);

    List<Turma> buscarTurmasPorIds(List<Long> ids);

    TurmaComProfessorVinculadoRecord findAndJoinTheacherWithClass(Long idTurma, Long idProfessor);
}
