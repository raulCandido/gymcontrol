package br.com.gym.gymcontrol.controller;

import br.com.gym.gymcontrol.model.Turma;
import br.com.gym.gymcontrol.model.dto.request.TurmaComProfessorVinculadoDto;
import br.com.gym.gymcontrol.model.dto.request.TurmaRequestDto;
import br.com.gym.gymcontrol.model.dto.response.TurmaResponseDto;
import br.com.gym.gymcontrol.model.mapper.TurmaMapper;
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

    private final TurmaMapper turmaMapper;

    @Autowired
    public TurmaController(TurmaService turmaService, ProfessorService professorService, CategoriaService categoriaService, TurmaMapper turmaMapper) {
        this.turmaService = turmaService;
        this.professorService = professorService;
        this.categoriaService = categoriaService;
        this.turmaMapper = turmaMapper;
    }

    @PostMapping
    public ResponseEntity<TurmaResponseDto> persistirTurma(@RequestBody @Valid TurmaRequestDto turmaRequestDto, UriComponentsBuilder builder) {
        Turma turma = turmaService.cadastrarTurma(turmaRequestDto);
        URI uri = builder.path("/{id}").buildAndExpand(turma.getIdTurma()).toUri();
        return ResponseEntity.created(uri).body(turmaMapper.modelToResponseDto(turma));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> editarTurma(@PathVariable Long id, @RequestBody @Valid TurmaRequestDto turmaRequestDto, UriComponentsBuilder builder) {
        turmaService.buscarEditarTurma(id, turmaRequestDto);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<TurmaResponseDto>> pegarTurmas() {
        List<Turma> turmas = turmaService.getTurmas();
        List<TurmaResponseDto> turmasDto = turmas.stream().map(turmaMapper::modelToResponseDto).collect(Collectors.toList());
        return ResponseEntity.ok(turmasDto);
    }

    @PatchMapping("/vincular_professor")
    public ResponseEntity<TurmaComProfessorVinculadoDto> vincularProfessor(@RequestParam(name = "id_professor") Long idProfessor, @RequestParam(name = "id_turma") Long idTurma) {
        var turmaComProfessorVinculadoRecord = turmaService.findAndJoinTheacherWithClass(idTurma, idProfessor);
        return ResponseEntity.ok(turmaComProfessorVinculadoRecord);
    }

}
