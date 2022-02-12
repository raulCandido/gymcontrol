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
import java.util.List;

@RestController
@RequestMapping("/aulas")
public class AulaController {

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

    @PutMapping({"/{id}"})
    public ResponseEntity<Void> editarAula(@RequestBody @Valid AlunoForm alunoForm, @PathVariable Long id) {
        return null;
    }

    @DeleteMapping
    public ResponseEntity<Aluno> deletAlunos() {
        return null;
    }
}
