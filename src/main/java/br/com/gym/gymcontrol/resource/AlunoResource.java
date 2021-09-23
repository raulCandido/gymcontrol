package br.com.gym.gymcontrol.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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
@RequestMapping("/alunos")
public class AlunoResource {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<AlunoDto>> pegarAlunos() {
	List<Aluno> alunos = alunoService.buscarAlunos();
	List<AlunoDto> alunosDto = alunos.stream().map(a -> new AlunoDto(a)).collect(Collectors.toList());
	return ResponseEntity.ok(alunosDto);
    }

    @PostMapping
    public ResponseEntity<AlunoDto> cadastrarAlunos(@RequestBody @Valid AlunoForm alunoForm,
	    UriComponentsBuilder builder) {
	Aluno aluno = alunoService.verificarAlunoParaPersistir(alunoForm);
	URI uri = builder.path("/{id}").buildAndExpand(aluno.getId()).toUri();
	return ResponseEntity.created(uri).body(new AlunoDto(aluno));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Void> editarAlunos(@RequestBody @Valid AlunoForm alunoForm, @PathVariable Long id) {
	alunoService.buscarEditarAluno(id, alunoForm);
	return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAlunos(@PathVariable Long id) {
	alunoService.buscarDeletarAluno(id);
	return ResponseEntity.noContent().build();
    }
}
