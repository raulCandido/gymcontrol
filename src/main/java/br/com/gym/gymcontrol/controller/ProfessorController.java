package br.com.gym.gymcontrol.controller;

import br.com.gym.gymcontrol.model.Categoria;
import br.com.gym.gymcontrol.model.Professor;
import br.com.gym.gymcontrol.model.dto.response.ProfessorReponseDto;
import br.com.gym.gymcontrol.model.dto.request.ProfessorRequestDto;
import br.com.gym.gymcontrol.model.mapper.ProfessorMapper;
import br.com.gym.gymcontrol.service.CategoriaService;
import br.com.gym.gymcontrol.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    private final ProfessorService professorService;

    private final CategoriaService categoriaService;

    private final ProfessorMapper professorMapper;

    @Autowired
    public ProfessorController(ProfessorService professorService, CategoriaService categoriaService, ProfessorMapper professorMapper) {
        this.professorService = professorService;
        this.categoriaService = categoriaService;
        this.professorMapper = professorMapper;
    }

    @GetMapping
    public ResponseEntity<List<ProfessorReponseDto>> getProfessores() {
        List<Professor> profs = professorService.bucarProfessores();

        List<ProfessorReponseDto> professorReponseDto = profs.stream().map(professorMapper::modelToDTO).collect(Collectors.toList());
        return ResponseEntity.ok(professorReponseDto);
    }

    @PostMapping
    public ResponseEntity<ProfessorReponseDto> cadastrarProfessor(@RequestBody @Valid ProfessorRequestDto professorRequestDto, UriComponentsBuilder builder) {

        List<Categoria> categorias = categoriaService.buscarCategoriaPorIds(professorRequestDto.getIdCategorias());
        Professor professor = Professor.builder()
                .nome(professorRequestDto.getNome())
                .apelido(professorRequestDto.getApelido())
                .categorias(categorias).build();

        Professor persistProfessor = professorService.inserirProfessor(professor);

        URI uri = builder.path("/{id}").buildAndExpand(professor.getId()).toUri();
        return ResponseEntity.created(uri).body(professorMapper.modelToDTO(professor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> editProfessores(@Valid @RequestBody ProfessorRequestDto professorRequestDto, @PathVariable Long id) {
        Professor professor = professorService.buscarProfessorPorId(id);

        List<Categoria> idCategoriaList = categoriaService.buscarCategoriaPorIds(professorRequestDto.getIdCategorias());

        professor.setNome(professorRequestDto.getNome());
        professor.setApelido(professorRequestDto.getApelido());
        professor.setCategorias(idCategoriaList);

        professorService.inserirProfessor(professor);

        return ResponseEntity.noContent().build();

    }



    @DeleteMapping
    public ResponseEntity<Void> deleteProfessores(@PathVariable Long idProfessor) {
        professorService.excluirProfessor(idProfessor);
        return ResponseEntity.noContent().build();
    }
}
