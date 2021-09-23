package br.com.gym.gymcontrol.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import br.com.gym.gymcontrol.model.Categoria;
import br.com.gym.gymcontrol.model.Professor;
import br.com.gym.gymcontrol.model.Turma;
import br.com.gym.gymcontrol.model.form.TurmaForm;
import br.com.gym.gymcontrol.repository.TurmaRepository;
import br.com.gym.gymcontrol.service.CategoriaService;
import br.com.gym.gymcontrol.service.ProfessorService;
import br.com.gym.gymcontrol.service.TurmaService;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@Service
public class TurmaServiceImpl implements TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ProfessorService professorService;

    public Turma cadastrarTurma(Turma turma) {
	return turmaRepository.save(turma);
    }

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

    public void inserir(Turma turma) {
	turmaRepository.save(turma);
    }

    @Override
    public void buscarEditarTurma(Long id, @Valid TurmaForm turmaForm) {
	Turma turma = buscarTurmaPorId(id);

	Categoria categoria = categoriaService.buscarCategoriaPorId(turmaForm.getIdCategoria());

	Professor professor = professorService.buscarProfessorPorId(turmaForm.getIdProfessor());

	turma.setNome(turmaForm.getNome());
	turma.setCategoria(categoria);
	turma.setProfessor(professor);

	inserir(turma);

    }

    public Turma buscarTurmaPorId(Long id) {
	Optional<Turma> opt = turmaRepository.findById(id);
	return opt.orElseThrow(() -> new ResourceNotFoundException("Nenhuma turma encontrada"));
    }

    @Override
    public List<Turma> buscarTurmasPorIds(List<Long> ids) {
	List<Turma> turmas = turmaRepository.findAllById(ids);
	verificarListaVazia(turmas);
	return turmas;
    }
}
