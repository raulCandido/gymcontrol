package br.com.gym.gymcontrol.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.gym.gymcontrol.model.Aluno;
import br.com.gym.gymcontrol.model.Professor;
import br.com.gym.gymcontrol.model.dto.ProfessorDto;
import br.com.gym.gymcontrol.model.form.ProfessorForm;
import br.com.gym.gymcontrol.service.CategoriaService;
import br.com.gym.gymcontrol.service.ProfessorService;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;
    
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Professor>> getProfessores() {
	List<Professor> profs = professorService.bucarProfessores();
	return ResponseEntity.ok(profs);
    }

    @PostMapping
    public ResponseEntity<ProfessorDto> setProfessores(@RequestBody @Valid ProfessorForm professorForm,
	    UriComponentsBuilder builder) {
	Professor professor = professorService.inserirProfessor(professorForm.converterEmProfessor(categoriaService));
	URI uri = builder.path("/{id}").buildAndExpand(professor.getId()).toUri();
	return ResponseEntity.created(uri).body(new ProfessorDto(professor));
    }

    @PutMapping
    public ResponseEntity<Aluno> editProfessores() {
	return null;
    }

    @DeleteMapping
    public ResponseEntity<Aluno> deletProfessores() {
	return null;
    }
}
