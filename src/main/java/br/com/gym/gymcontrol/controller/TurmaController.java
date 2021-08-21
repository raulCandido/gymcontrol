package br.com.gym.gymcontrol.controller;

import java.net.URI;

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
import br.com.gym.gymcontrol.service.TurmaService;

@RestController()
@RequestMapping("/turmas")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @PostMapping
    public ResponseEntity<TurmaDto> setTurmaService(@RequestBody @Valid TurmaForm turmaForm, UriComponentsBuilder builder) {
	Turma turma = turmaService.cadastrarTurma(turmaForm.converterEmTurma());
	URI uri = builder.path("/{id}").buildAndExpand(turma.getId()).toUri();
	return ResponseEntity.created(uri).body(new TurmaDto(turma));
	
    }

}
