package br.com.gym.gymcontrol.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.gym.gymcontrol.model.Aluno;
import br.com.gym.gymcontrol.model.dto.AlunoDto;
import br.com.gym.gymcontrol.model.form.AlunoForm;
import br.com.gym.gymcontrol.service.AlunoService;

@RestController
@RequestMapping("/aulas")
public class AulaResource {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<Aluno>> getAlunos() {
	List<Aluno> alunos = alunoService.buscarAlunos();
	return ResponseEntity.ok(alunos);
    }

    @PostMapping
    public ResponseEntity<AlunoDto> setAlunos(@RequestBody @Valid AlunoForm alunoForm, UriComponentsBuilder builder) {
	return null;
    }

    @PutMapping({ "/{id}" })
    public ResponseEntity<Void> editarAula(@RequestBody @Valid AlunoForm alunoForm, @PathVariable Long id) {
	return null;
    }

    @DeleteMapping
    public ResponseEntity<Aluno> deletAlunos() {
	return null;
    }
}
