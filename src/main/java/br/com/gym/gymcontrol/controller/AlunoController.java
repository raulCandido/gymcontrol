package br.com.gym.gymcontrol.controller;

import br.com.gym.gymcontrol.model.Aluno;
import br.com.gym.gymcontrol.model.dto.response.AlunoResponseDto;
import br.com.gym.gymcontrol.model.dto.request.AlunoRequestDto;
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
    private final AlunoService alunoService;

    @Autowired
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public ResponseEntity<List<AlunoResponseDto>> pegarAlunos() {
        List<Aluno> alunos = alunoService.buscarAlunos();
        List<AlunoResponseDto> alunosDto = alunos.stream().map(AlunoResponseDto::new).collect(Collectors.toList());
        return ResponseEntity.ok(alunosDto);
    }

    @PostMapping
    public ResponseEntity<AlunoResponseDto> cadastrarAlunos(@RequestBody @Valid AlunoRequestDto alunoRequestDto, UriComponentsBuilder builder) {
        Aluno aluno = alunoService.montarAlunoParaPersistir(alunoRequestDto);
        URI uri = builder.path("/{id}").buildAndExpand(aluno.getId()).toUri();
        return ResponseEntity.created(uri).body(new AlunoResponseDto(aluno));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> editarAlunos(@RequestBody @Valid AlunoRequestDto alunoRequestDto, @PathVariable Long id) {
        alunoService.buscarEditarAluno(id, alunoRequestDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAlunos(@PathVariable Long id) {
        alunoService.buscarDeletarAluno(id);
        return ResponseEntity.noContent().build();
    }
}
