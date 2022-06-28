package br.com.gym.gymcontrol.service.impl;

import br.com.gym.gymcontrol.error.BusinessError;
import br.com.gym.gymcontrol.exception.BusinessException;
import br.com.gym.gymcontrol.model.Categoria;
import br.com.gym.gymcontrol.model.Professor;
import br.com.gym.gymcontrol.model.Turma;
import br.com.gym.gymcontrol.model.dto.request.TurmaComProfessorVinculadoDto;
import br.com.gym.gymcontrol.model.dto.request.TurmaRequestDto;
import br.com.gym.gymcontrol.repository.TurmaRepository;
import br.com.gym.gymcontrol.service.CategoriaService;
import br.com.gym.gymcontrol.service.ProfessorService;
import br.com.gym.gymcontrol.service.TurmaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TurmaServiceImpl implements TurmaService {

    private final TurmaRepository turmaRepository;

    private final CategoriaService categoriaService;

    private final ProfessorService professorService;

    @Autowired
    public TurmaServiceImpl(TurmaRepository turmaRepository, CategoriaService categoriaService, ProfessorService professorService) {
        this.turmaRepository = turmaRepository;
        this.categoriaService = categoriaService;
        this.professorService = professorService;
    }

    @Transactional
    public Turma cadastrarTurma(TurmaRequestDto turmaRequestDto) {

        Categoria categoria = categoriaService.buscarReferencia(turmaRequestDto.idCategoria());

        Turma turma = Turma.builder().nome(turmaRequestDto.nome())
                .categoria(categoria)
                .horarioTurma(turmaRequestDto.horarioTurma())
                .build();
        return turmaRepository.save(turma);
    }

    @Transactional
    public List<Turma> getTurmas() {
        List<Turma> turmas = turmaRepository.findAll();
        verificarListaVazia(turmas);
        return turmas;
    }

    private void verificarListaVazia(List<?> t) {
        if (t.isEmpty()) {
            throw new ResourceNotFoundException("Nenhum item encontrada");
        }
    }

    @Transactional
    public void inserir(Turma turma) {
        turmaRepository.save(turma);
    }

    @Override
    @Transactional
    public void buscarEditarTurma(Long id, @Valid TurmaRequestDto turmaRequestDto) {
        Turma turma = buscarTurmaPorId(id);

        Categoria categoria = categoriaService.buscarReferencia(turmaRequestDto.idCategoria());

        turma.setNome(turmaRequestDto.nome());
        turma.setCategoria(categoria);
        inserir(turma);

    }

    @Transactional
    public Turma buscarTurmaPorId(Long id) {
        Optional<Turma> opt = turmaRepository.findById(id);
        return opt.orElseThrow(() -> new BusinessException(BusinessError.RESOURCE_NOT_FOUND));
    }

    @Override
    @Transactional
    public List<Turma> buscarTurmasPorIds(List<Long> ids) {
        List<Turma> turmas = turmaRepository.findAllById(ids);
        if (turmas.isEmpty()) {
            throw new BusinessException(BusinessError.RESOURCE_NOT_FOUND);
        }
        return turmas;
    }

    @Override
    @Transactional()
    public TurmaComProfessorVinculadoDto findAndJoinTheacherWithClass(Long idTurma, Long idProfessor) {
        Turma turma = buscarTurmaPorId(idTurma);
        Professor professor = professorService.buscarProfessorPorId(idProfessor);

        if (turma.getProfessor() != null) {
            if (turma.getProfessor().equals(professor)) {
                log.info("Professor já é vinculado a essa turma");
                throw new BusinessException(BusinessError.TEACHER_LINKED_WITH_CLASS);
            }
        }

        if (!verifyTeacherCategory(professor, turma)) {
            throw new BusinessException(BusinessError.TEACHER_NOT_WITH_CATEGORY);
        }
        turma.setProfessor(professor);
        professor.getTurmas().add(turma);

        turmaRepository.save(turma);
        professorService.inserirProfessor(professor);

        return new TurmaComProfessorVinculadoDto(turma.getIdTurma(), turma.getNome(), professor.getNome());
    }

    private boolean verifyTeacherCategory(Professor professor, Turma turma) {
        return professor.getCategorias().contains(turma.getCategoria());
    }

}
