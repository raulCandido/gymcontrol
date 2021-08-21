package br.com.gym.gymcontrol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import br.com.gym.gymcontrol.model.Professor;
import br.com.gym.gymcontrol.repository.ProfessorRepository;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> bucarProfessores() throws ResourceAccessException{
	List<Professor> profs = professorRepository.findAll();
	if(profs.isEmpty()) {
	   throw new ResourceNotFoundException("Recurso não encontrado");
	}
	return professorRepository.findAll();
    }

    public Professor inserirProfessor(Professor professor) {
	return professorRepository.save(professor);
    }

}
