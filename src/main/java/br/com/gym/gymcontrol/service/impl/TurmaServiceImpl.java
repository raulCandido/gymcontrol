package br.com.gym.gymcontrol.service.impl;

import br.com.gym.gymcontrol.error.BusinessError;
import br.com.gym.gymcontrol.exception.BusinessException;
import br.com.gym.gymcontrol.model.Categoria;
import br.com.gym.gymcontrol.model.Professor;
import br.com.gym.gymcontrol.model.Turma;
import br.com.gym.gymcontrol.model.form.TurmaForm;
import br.com.gym.gymcontrol.repository.TurmaRepository;
import br.com.gym.gymcontrol.service.CategoriaService;
import br.com.gym.gymcontrol.service.ProfessorService;
import br.com.gym.gymcontrol.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
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
    public Turma cadastrarTurma(TurmaForm turmaForm) {

        Categoria categoria = categoriaService.buscarReferencia(turmaForm.getIdCategoria());
        Professor professor = professorService.buscarProfessorPorId(turmaForm.getIdProfessor());

        Turma turma = Turma.builder().nome(turmaForm.getNome()).categoria(categoria).professor(professor).build();
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
    public void buscarEditarTurma(Long id, @Valid TurmaForm turmaForm) {
        Turma turma = buscarTurmaPorId(id);

        Categoria categoria = categoriaService.buscarReferencia(turmaForm.getIdCategoria());

        Professor professor = professorService.buscarProfessorPorId(turmaForm.getIdProfessor());

        turma.setNome(turmaForm.getNome());
        turma.setCategoria(categoria);
        turma.setProfessor(professor);

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
}
