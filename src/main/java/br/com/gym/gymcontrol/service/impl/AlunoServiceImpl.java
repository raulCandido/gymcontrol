package br.com.gym.gymcontrol.service.impl;

import br.com.gym.gymcontrol.error.BusinessError;
import br.com.gym.gymcontrol.exception.BusinessException;
import br.com.gym.gymcontrol.model.Aluno;
import br.com.gym.gymcontrol.model.Turma;
import br.com.gym.gymcontrol.model.dto.request.AlunoRequestDto;
import br.com.gym.gymcontrol.model.mapper.AlunoMapper;
import br.com.gym.gymcontrol.repository.AlunoRepository;
import br.com.gym.gymcontrol.service.AlunoService;
import br.com.gym.gymcontrol.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoServiceImpl implements AlunoService {

    private AlunoRepository alunoRepository;

    private TurmaService turmaService;

    private AlunoMapper alunoMapper;

    @Autowired
    public AlunoServiceImpl(AlunoRepository alunoRepository, TurmaService turmaService, AlunoMapper alunoMapper) {
        this.alunoRepository = alunoRepository;
        this.turmaService = turmaService;
        this.alunoMapper = alunoMapper;
    }

    @Override
    public List<Aluno> buscarAlunos() {
        List<Aluno> alunos = alunoRepository.findAll();
        if (alunos.isEmpty()) {
            throw new BusinessException(BusinessError.RESOURCE_NOT_FOUND);
        }
        return alunos;
    }

    @Override
    public Aluno inserirAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @Transactional
    @Override
    public Aluno montarAlunoParaPersistir(AlunoRequestDto alunoRequestDto) {
        List<Turma> turmas = turmaService.buscarTurmasPorIds(alunoRequestDto.idTurmas());

        if (turmas.size() != alunoRequestDto.idTurmas().size()) {
            throw new BusinessException(BusinessError.GENERAL_ERROR);
        }

        Aluno aluno = alunoMapper.newDtoToModel(alunoRequestDto);
        aluno.setTurmas(turmas);
        return inserirAluno(aluno);
    }

    @Override
    public List<Aluno> buscarAlunosPorTurma(Long idTurma) {
        List<Aluno> alunos = alunoRepository.buscarAlunosPorTurma(idTurma);
        if(alunos.isEmpty()){
            throw new BusinessException(BusinessError.RESOURCE_NOT_FOUND);
        }
        return alunos;
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
    public void buscarEditarAluno(Long id, AlunoRequestDto alunoRequestDto) {
        Aluno aluno = buscarAlunoPorId(id);
        aluno.setApelido(alunoRequestDto.apelido());
        aluno.setNome(alunoRequestDto.nome());
        aluno.setDataNascimento(alunoRequestDto.dataNascimento());
        inserirAluno(aluno);
    }

    @Override
    public void buscarDeletarAluno(Long id) {
        Aluno aluno = buscarAlunoPorId(id);
        deletarAluno(aluno);
    }


}
