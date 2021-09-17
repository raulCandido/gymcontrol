package br.com.gym.gymcontrol.service;

import java.util.List;

import br.com.gym.gymcontrol.model.Professor;
import br.com.gym.gymcontrol.model.dto.ProfessorDto;

public interface ProfessorService {
	List<Professor> bucarProfessores();

	Professor inserirProfessor(Professor professor);

	Professor buscarProfessorPorId(Long idProfessor);

	List<ProfessorDto> buscarProfessoresPorCategoria(Long id);
}
