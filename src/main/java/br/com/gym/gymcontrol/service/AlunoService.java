package br.com.gym.gymcontrol.service;

import java.util.List;

import br.com.gym.gymcontrol.model.Aluno;
import br.com.gym.gymcontrol.model.form.AlunoForm;

public interface AlunoService {
    
    List<Aluno> buscarAlunos();

    Aluno inserirAluno(Aluno aluno);

    Aluno buscarAlunoPorId(Long id);

    void deletarAluno(Aluno aluno);

    void buscarEditarAluno(Long id, AlunoForm alunoForm);

    void buscarDeletarAluno(Long id);

    Aluno montarAlunoParaPersistir(AlunoForm alunoForm);

}
