package br.com.gym.gymcontrol.repository;

import java.util.List;

import br.com.gym.gymcontrol.model.dto.ProfessorDto;

public interface ProfessorRepositoryCustom {

    List<ProfessorDto> findProfessoresPorCategorias(Long id);
}
