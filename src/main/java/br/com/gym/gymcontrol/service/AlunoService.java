package br.com.gym.gymcontrol.service;

import br.com.gym.gymcontrol.model.Aluno;
import br.com.gym.gymcontrol.model.dto.request.AlunoRequestDto;

import java.util.List;

public interface AlunoService {
    List<Aluno> buscarAlunos();
    Aluno inserirAluno(Aluno aluno);
    Aluno buscarAlunoPorId(Long id);
    void deletarAluno(Aluno aluno);
    void buscarEditarAluno(Long id, AlunoRequestDto alunoRequestDto);
    void buscarDeletarAluno(Long id);
    Aluno montarAlunoParaPersistir(AlunoRequestDto alunoRequestDto);

    List<Aluno> buscarAlunosPorTurma(Long idTurma);

}
