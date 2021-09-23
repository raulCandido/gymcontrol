package br.com.gym.gymcontrol.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import br.com.gym.gymcontrol.model.Aluno;
import br.com.gym.gymcontrol.model.Turma;
import br.com.gym.gymcontrol.model.form.AlunoForm;
import br.com.gym.gymcontrol.repository.AlunoRepository;
import br.com.gym.gymcontrol.service.AlunoService;
import br.com.gym.gymcontrol.service.TurmaService;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;
    
    @Autowired
    private TurmaService turmaService;

    @Override
    public List<Aluno> buscarAlunos() {

	List<Aluno> alunos = alunoRepository.findAll();
	verificarListAlunoVazia(alunos);
	return alunos;
    }

    @Override
    public Aluno inserirAluno(Aluno aluno) {
	return alunoRepository.save(aluno);
    }
    
    @Override
    public Aluno verificarAlunoParaPersistir(AlunoForm alunoForm) {
	List<Long> idTurmas = alunoForm.getIdTurmas();
	List<Turma> turmas = turmaService.buscarTurmasPorIds(idTurmas);
	Aluno aluno = alunoForm.converterParaAluno(turmas);
	return inserirAluno(aluno);
    }

    private void verificarListAlunoVazia(List<Aluno> alunos) {
	if (alunos.isEmpty()) {
	    throw new ResourceNotFoundException("Nenhum aluno encontrado.");
	}
    }

    @Override
    public Aluno buscarAlunoPorId(Long id) {
	Optional<Aluno> opt = alunoRepository.findById(id);
	return opt.orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado."));
    }

    @Override
    public void deletarAluno(Aluno aluno) {
	alunoRepository.delete(aluno);
    }

    @Override
    public void buscarEditarAluno(Long id, AlunoForm alunoForm) {
	Aluno aluno = buscarAlunoPorId(id);
	aluno.setAlcunha(alunoForm.getAlcunha());
	aluno.setNome(alunoForm.getNome());
	aluno.setDataNascimento(alunoForm.getDataNascimento());
	inserirAluno(aluno);
    }

    @Override
    public void buscarDeletarAluno(Long id) {
	Aluno aluno = buscarAlunoPorId(id);
	deletarAluno(aluno);
    }

}
