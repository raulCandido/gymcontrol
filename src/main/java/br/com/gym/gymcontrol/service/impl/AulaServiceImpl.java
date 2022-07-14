package br.com.gym.gymcontrol.service.impl;

import br.com.gym.gymcontrol.error.BusinessError;
import br.com.gym.gymcontrol.exception.BusinessException;
import br.com.gym.gymcontrol.model.Aula;
import br.com.gym.gymcontrol.model.dto.request.AulaRequestDto;
import br.com.gym.gymcontrol.repository.AulaRepository;
import br.com.gym.gymcontrol.service.AlunoService;
import br.com.gym.gymcontrol.service.AulaService;
import br.com.gym.gymcontrol.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AulaServiceImpl implements AulaService {

    private final AulaRepository aulaRepository;

    private final AlunoService alunoService;

    private final TurmaService turmaService;

    @Autowired
    public AulaServiceImpl(AulaRepository aulaRepository, AlunoService alunoService, TurmaService turmaService) {
        this.aulaRepository = aulaRepository;
        this.alunoService = alunoService;
        this.turmaService = turmaService;
    }

    @Override
    public List<Aula> buscarAulas() {
        List<Aula> aulas = aulaRepository.findAll();
        if (aulas.isEmpty()) {
            throw new BusinessException(BusinessError.RESOURCE_NOT_FOUND);
        }
        return aulas;
    }

    @Override
    public Aula salvarAula(Aula aula) {
        return aulaRepository.save(aula);
    }

    @Override
    public Aula buscarAulaPorId(Long id) {
        return aulaRepository.findById(id).orElseThrow(() -> new BusinessException(BusinessError.RESOURCE_NOT_FOUND));
    }


    @Override
    public void deletarAula(Long idAula) {
        Aula aula = buscarAulaPorId(idAula);
        aulaRepository.delete(aula);
    }

    @Override
    public void buscarEditarAula(Long idAula, AulaRequestDto aulaRequestDto) {

    }

    @Override
    public void buscarDeletarAula(Long id) {

    }

    @Override
    public Aula montarAulaParaPersistir(AulaRequestDto aulaRequestDto) {
        var alunos = alunoService.buscarAlunosPorTurma(aulaRequestDto.idTurma());
        var alunosPresentesMatriculados = alunos.stream().filter(a -> aulaRequestDto.alunosPresentes().contains(a.getId())).collect(Collectors.toList());
        var aula = Aula.builder()
                .alunosPresentes(alunosPresentesMatriculados)
                .turma(turmaService.buscarTurmaPorId(aulaRequestDto.idTurma()))
                .data(aulaRequestDto.dataAula()).build();
        return aulaRepository.save(aula);
    }
}
