package br.com.gym.gymcontrol.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import br.com.gym.gymcontrol.model.Aluno;
import br.com.gym.gymcontrol.repository.AlunoRepository;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> buscarAlunos() {

	List<Aluno> alunos = alunoRepository.findAll();
	verificarListAlunoVazia(alunos);
	return alunos;
    }

    public Aluno inserirAluno(Aluno aluno) {
	return alunoRepository.save(aluno);
    }

    private void verificarListAlunoVazia(List<Aluno> alunos) {
	if (alunos.isEmpty()) {
	    throw new ResourceNotFoundException("Nenhum aluno encontrado.");
	}
    }

    public Aluno buscarAlunoPorId(Long id) {
	Optional<Aluno> opt = alunoRepository.findById(id);
	return opt.orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado."));
    }

    public void deletarAlunoPorId(Aluno aluno) {
	alunoRepository.delete(aluno);
    }

}
