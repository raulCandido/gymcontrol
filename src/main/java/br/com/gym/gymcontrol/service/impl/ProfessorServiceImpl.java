package br.com.gym.gymcontrol.service.impl;

import br.com.gym.gymcontrol.model.Professor;
import br.com.gym.gymcontrol.model.dto.response.ProfessorReponseDto;
import br.com.gym.gymcontrol.repository.ProfessorRepository;
import br.com.gym.gymcontrol.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Transactional
    public List<Professor> bucarProfessores() {
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

    public List<ProfessorReponseDto> buscarProfessoresPorCategoria(Long id) {

        List<ProfessorReponseDto> professoresPorCategorias = professorRepository.findProfessoresPorCategorias(id);
        verificarListaVazia(professoresPorCategorias);
        return professoresPorCategorias;
    }

    @Override
    @Transactional
    public void excluirProfessor(Long idProfessor) {
        Professor professor = buscarReferencia(idProfessor);
        professorRepository.delete(professor);
    }

    public Professor buscarReferencia(Long id) {
        return professorRepository.getById(id);
    }

    private void verificarListaVazia(List<?> object) {
        if (object.isEmpty()) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }

    }

}
