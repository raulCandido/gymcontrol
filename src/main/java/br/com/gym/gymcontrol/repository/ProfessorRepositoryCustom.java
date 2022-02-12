package br.com.gym.gymcontrol.repository;

import br.com.gym.gymcontrol.model.dto.ProfessorDto;

import java.util.List;

public interface ProfessorRepositoryCustom {

    List<ProfessorDto> findProfessoresPorCategorias(Long id);
}
