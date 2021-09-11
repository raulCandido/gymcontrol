package br.com.gym.gymcontrol.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import br.com.gym.gymcontrol.model.Aluno;
import br.com.gym.gymcontrol.repository.AlunoRepository;
import br.com.gym.gymcontrol.service.AlunoService;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

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

    public void deletarAlunoPorId(Aluno aluno) {
        alunoRepository.delete(aluno);
    }

}
