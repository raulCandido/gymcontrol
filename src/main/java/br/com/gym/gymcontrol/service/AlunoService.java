package br.com.gym.gymcontrol.service;

import br.com.gym.gymcontrol.model.Aluno;
import br.com.gym.gymcontrol.model.form.AlunoNewDto;

import java.util.List;

public interface AlunoService {
    List<Aluno> buscarAlunos();
    Aluno inserirAluno(Aluno aluno);
    Aluno buscarAlunoPorId(Long id);
    void deletarAluno(Aluno aluno);
    void buscarEditarAluno(Long id, AlunoNewDto alunoNewDto);
    void buscarDeletarAluno(Long id);
    Aluno montarAlunoParaPersistir(AlunoNewDto alunoNewDto);

}
