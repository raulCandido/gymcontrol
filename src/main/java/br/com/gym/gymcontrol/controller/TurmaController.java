package br.com.gym.gymcontrol.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.gym.gymcontrol.model.Turma;
import br.com.gym.gymcontrol.model.dto.TurmaDto;
import br.com.gym.gymcontrol.model.form.TurmaForm;
import br.com.gym.gymcontrol.service.CategoriaService;
import br.com.gym.gymcontrol.service.ProfessorService;
import br.com.gym.gymcontrol.service.TurmaService;

@RestController()
@RequestMapping("/turmas")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;
    
    @Autowired
    private ProfessorService professorService;
    
    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<TurmaDto> setTurmaService(@RequestBody @Valid TurmaForm turmaForm,
	    UriComponentsBuilder builder) {
	Turma turma = turmaService.cadastrarTurma(turmaForm.converterEmTurma(professorService, categoriaService));
	URI uri = builder.path("/{id}").buildAndExpand(turma.getId()).toUri();
	return ResponseEntity.created(uri).body(new TurmaDto(turma));

    }

    public ResponseEntity<List<TurmaDto>> pegarTurmas() {
	List<Turma> turmas = turmaService.getTurmas();
	List<TurmaDto> turmasDto = turmas.stream().map(t -> new TurmaDto(t)).toList();
	return ResponseEntity.ok(turmasDto);
    }

}
