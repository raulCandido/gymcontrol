package br.com.gym.gymcontrol.service;

import br.com.gym.gymcontrol.model.Turma;
import br.com.gym.gymcontrol.model.dto.request.TurmaComProfessorVinculadoDto;
import br.com.gym.gymcontrol.model.dto.request.TurmaRequestDto;

import javax.validation.Valid;
import java.util.List;

public interface TurmaService {

    Turma cadastrarTurma(TurmaRequestDto turmaRequestDto);

    List<Turma> getTurmas();

    void inserir(Turma turma);

    void buscarEditarTurma(Long id, @Valid TurmaRequestDto turmaRequestDto);

    Turma buscarTurmaPorId(Long id);

    List<Turma> buscarTurmasPorIds(List<Long> ids);

    TurmaComProfessorVinculadoDto findAndJoinTheacherWithClass(Long idTurma, Long idProfessor);
}
