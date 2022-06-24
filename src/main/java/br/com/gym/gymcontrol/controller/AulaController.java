package br.com.gym.gymcontrol.controller;

import br.com.gym.gymcontrol.model.Aluno;
import br.com.gym.gymcontrol.model.Aula;
import br.com.gym.gymcontrol.model.Turma;
import br.com.gym.gymcontrol.model.dto.AlunoDto;
import br.com.gym.gymcontrol.model.dto.AulaDto;
import br.com.gym.gymcontrol.model.form.AlunoNewDto;
import br.com.gym.gymcontrol.service.AlunoService;
import br.com.gym.gymcontrol.service.AulaService;
import br.com.gym.gymcontrol.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/aulas")
public class AulaController {

    private AulaService aulaService;


    private AlunoService alunoService;

    @Autowired
    public AulaController(AulaService aulaService, AlunoService alunoService) {
        this.aulaService = aulaService;
        this.alunoService = alunoService;
    }

    @GetMapping
    public ResponseEntity<List<Aula>> getAulas() {
        List<Aula> aulas = aulaService.buscarAulas();
        return ResponseEntity.ok(aulas);
    }

    @PostMapping
    public ResponseEntity<AlunoDto> salvarAula(@RequestBody @Valid AulaDto aulaDto, UriComponentsBuilder builder) {
        var aula = aulaService.montarAulaParaPersistir(aulaDto);

        return null;
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<Void> editarAula(@RequestBody @Valid AlunoNewDto alunoNewDto, @PathVariable Long id) {
        return null;
    }

    @DeleteMapping
    public ResponseEntity<Aluno> deletAlunos() {
        return null;
    }
}
