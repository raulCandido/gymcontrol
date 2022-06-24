package br.com.gym.gymcontrol.repository;

import br.com.gym.gymcontrol.model.dto.response.ProfessorReponseDto;

import java.util.List;

public interface ProfessorRepositoryCustom {

    List<ProfessorReponseDto> findProfessoresPorCategorias(Long id);
}
