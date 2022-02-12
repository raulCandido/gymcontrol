package br.com.gym.gymcontrol.controller;

import br.com.gym.gymcontrol.model.Aluno;
import br.com.gym.gymcontrol.model.dto.AlunoDto;
import br.com.gym.gymcontrol.model.form.AlunoForm;
import br.com.gym.gymcontrol.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<AlunoDto>> pegarAlunos() {
        List<Aluno> alunos = alunoService.buscarAlunos();
        List<AlunoDto> alunosDto = alunos.stream().map(AlunoDto::new).collect(Collectors.toList());
        return ResponseEntity.ok(alunosDto);
    }

    @PostMapping
    public ResponseEntity<AlunoDto> cadastrarAlunos(@RequestBody @Valid AlunoForm alunoForm, UriComponentsBuilder builder) {
        Aluno aluno = alunoService.montarAlunoParaPersistir(alunoForm);
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
