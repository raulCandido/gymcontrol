package br.com.gym.gymcontrol.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import br.com.gym.gymcontrol.model.dto.AlunoDto;
import br.com.gym.gymcontrol.model.form.AlunoForm;
import br.com.gym.gymcontrol.service.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoResource {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<Aluno>> getAlunos() {
	List<Aluno> alunos = alunoService.buscarAlunos();
	return ResponseEntity.ok(alunos);
    }

    @PostMapping
    public ResponseEntity<AlunoDto> setAlunos(@RequestBody @Valid AlunoForm alunoForm, UriComponentsBuilder builder) {
	Aluno aluno = alunoService.inserirAluno(alunoForm.converterParaPessoa()); 
	URI uri = builder.path("/{id}").buildAndExpand(aluno.getId()).toUri();
	return ResponseEntity.created(uri).body(new AlunoDto(aluno));
    }

    @PutMapping
    public ResponseEntity<Aluno> editAlunos() {
	return null;
    }

    @DeleteMapping
    public ResponseEntity<Aluno> deletAlunos() {
	return null;
    }
}
