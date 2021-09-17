package br.com.gym.gymcontrol.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import br.com.gym.gymcontrol.model.Professor;
import br.com.gym.gymcontrol.model.dto.ProfessorDto;
import br.com.gym.gymcontrol.repository.ProfessorRepository;
import br.com.gym.gymcontrol.service.ProfessorService;

@Service
public class ProfessorServiceImpl implements ProfessorService{

    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> bucarProfessores() throws ResourceAccessException {
        List<Professor> profs = professorRepository.findAll();
        verificarListaVazia(profs);
        return professorRepository.findAll();
    }

    public Professor inserirProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    public Professor buscarProfessorPorId(Long idProfessor) {
        Optional<Professor> opt = professorRepository.findById(idProfessor);
        return opt.orElseThrow(() -> new ResourceNotFoundException("Professor não encontrado"));
    }

    public List<ProfessorDto> buscarProfessoresPorCategoria(Long id) {

        List<ProfessorDto> professoresPorCategorias = professorRepository.findProfessoresPorCategorias(id);
        verificarListaVazia(professoresPorCategorias);
        return professoresPorCategorias;

    }

    private void verificarListaVazia(List<?> object) {
        if (object.isEmpty()) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }

    }

}
