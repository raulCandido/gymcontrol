package br.com.gym.gymcontrol.controller;

import br.com.gym.gymcontrol.model.Aluno;
import br.com.gym.gymcontrol.model.Aula;
import br.com.gym.gymcontrol.model.dto.request.AulaRequestDto;
import br.com.gym.gymcontrol.model.dto.response.AulaResponseDto;
import br.com.gym.gymcontrol.model.dto.request.AlunoRequestDto;
import br.com.gym.gymcontrol.model.mapper.AulaMapper;
import br.com.gym.gymcontrol.service.AlunoService;
import br.com.gym.gymcontrol.service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/aulas")
public class AulaController {

    private AulaService aulaService;
    private AlunoService alunoService;
    private AulaMapper aulaMapper;

    @Autowired
    public AulaController(AulaService aulaService, AlunoService alunoService, AulaMapper aulaMapper) {
        this.aulaService = aulaService;
        this.alunoService = alunoService;
        this.aulaMapper = aulaMapper;
    }

    @GetMapping
    public ResponseEntity<List<AulaResponseDto>> getAulas() {
        List<Aula> aulas = aulaService.buscarAulas();
        List<AulaResponseDto> aulasResponseDto = aulas.stream().map(aula -> aula.toDto()).collect(Collectors.toList());
        return ResponseEntity.ok(aulasResponseDto);
    }

    @PostMapping
    public ResponseEntity<AulaResponseDto> salvarAula(@RequestBody @Valid AulaRequestDto aulaRequestDto, UriComponentsBuilder builder) {
        AulaResponseDto aulaResponseDto = aulaService.montarAulaParaPersistir(aulaRequestDto).toDto();
        return ResponseEntity.ok(aulaResponseDto);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<Void> editarAula(@RequestBody @Valid AlunoRequestDto alunoRequestDto, @PathVariable Long id) {
        return null;
    }

    @DeleteMapping
    public ResponseEntity<Aluno> deletAlunos() {
        return null;
    }
}
