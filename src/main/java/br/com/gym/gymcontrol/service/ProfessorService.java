package br.com.gym.gymcontrol.service;

import br.com.gym.gymcontrol.model.Professor;
import br.com.gym.gymcontrol.model.dto.response.ProfessorReponseDto;

import java.util.List;

public interface ProfessorService {

    List<Professor> bucarProfessores();

    Professor inserirProfessor(Professor professor);

    Professor buscarProfessorPorId(Long idProfessor);

    List<ProfessorReponseDto> buscarProfessoresPorCategoria(Long id);

    void excluirProfessor(Long idProfessor);
}
