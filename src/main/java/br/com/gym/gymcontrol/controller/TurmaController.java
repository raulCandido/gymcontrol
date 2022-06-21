package br.com.gym.gymcontrol.controller;

import br.com.gym.gymcontrol.model.Turma;
import br.com.gym.gymcontrol.model.dto.TurmaComProfessorVinculadoRecord;
import br.com.gym.gymcontrol.model.dto.TurmaDto;
import br.com.gym.gymcontrol.model.form.TurmaForm;
import br.com.gym.gymcontrol.service.CategoriaService;
import br.com.gym.gymcontrol.service.ProfessorService;
import br.com.gym.gymcontrol.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/turmas")
public class TurmaController {

    private final TurmaService turmaService;

    private final ProfessorService professorService;

    private final CategoriaService categoriaService;

    @Autowired
    public TurmaController(TurmaService turmaService, ProfessorService professorService, CategoriaService categoriaService) {
        this.turmaService = turmaService;
        this.professorService = professorService;
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity<TurmaDto> persistirTurma(@RequestBody @Valid TurmaForm turmaForm, UriComponentsBuilder builder) {
        Turma turma = turmaService.cadastrarTurma(turmaForm);
        URI uri = builder.path("/{id}").buildAndExpand(turma.getId()).toUri();
        return ResponseEntity.created(uri).body(new TurmaDto(turma));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> editarTurma(@PathVariable Long id, @RequestBody @Valid TurmaForm turmaForm, UriComponentsBuilder builder) {
        turmaService.buscarEditarTurma(id, turmaForm);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<TurmaDto>> pegarTurmas() {
        List<Turma> turmas = turmaService.getTurmas();
        List<TurmaDto> turmasDto = turmas.stream().map(TurmaDto::new).collect(Collectors.toList());
        return ResponseEntity.ok(turmasDto);
    }

    @PatchMapping("/vincular_professor")
    public ResponseEntity<TurmaComProfessorVinculadoRecord> vincularProfessor(@RequestParam(name = "id_professor") Long idProfessor, @RequestParam(name = "id_turma") Long idTurma) {
        var turmaComProfessorVinculadoRecord = turmaService.findAndJoinTheacherWithClass(idTurma, idProfessor);
        return ResponseEntity.ok(turmaComProfessorVinculadoRecord);
    }

}
