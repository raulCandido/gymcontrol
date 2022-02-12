package br.com.gym.gymcontrol.controller;

import br.com.gym.gymcontrol.model.Categoria;
import br.com.gym.gymcontrol.model.Professor;
import br.com.gym.gymcontrol.model.dto.ProfessorDto;
import br.com.gym.gymcontrol.model.form.ProfessorForm;
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

    private ProfessorService professorService;

    private CategoriaService categoriaService;

    private ProfessorMapper professorMapper;

    @Autowired
    public ProfessorController(ProfessorService professorService, CategoriaService categoriaService, ProfessorMapper professorMapper) {
        this.professorService = professorService;
        this.categoriaService = categoriaService;
        this.professorMapper = professorMapper;
    }

    @GetMapping
    public ResponseEntity<List<ProfessorDto>> getProfessores() {
        List<Professor> profs = professorService.bucarProfessores();
        List<ProfessorDto> professorDto = profs.stream().map(professorMapper::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok(professorDto);
    }

    @PostMapping
    public ResponseEntity<ProfessorDto> setProfessores(@RequestBody @Valid ProfessorForm professorForm,
                                                       UriComponentsBuilder builder) {
        Professor professor = professorService.inserirProfessor(professorForm.converterEmProfessor(categoriaService));
        URI uri = builder.path("/{id}").buildAndExpand(professor.getId()).toUri();
        return ResponseEntity.created(uri).body(professorMapper.toDTO(professor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> editProfessores(@Valid @RequestBody ProfessorForm professorForm,
                                                @PathVariable Long id) {
        Professor professor = professorService.buscarProfessorPorId(id);

        List<Categoria> idCategoriaList = categoriaService.buscarCategoriaPorIds(professorForm.getIdCategorias());

        professor.setNome(professorForm.getNome());
        professor.setAlcunha(professorForm.getAlcunha());
        professor.setCategorias(idCategoriaList);

        professorService.inserirProfessor(professor);

        return ResponseEntity.noContent().build();

    }

    @DeleteMapping
    public ResponseEntity<Void> deleteProfessores() {
        return null;
    }
}
