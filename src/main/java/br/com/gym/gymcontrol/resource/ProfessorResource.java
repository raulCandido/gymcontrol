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

import br.com.gym.gymcontrol.model.Categoria;
import br.com.gym.gymcontrol.model.Professor;
import br.com.gym.gymcontrol.model.dto.ProfessorDto;
import br.com.gym.gymcontrol.model.form.ProfessorForm;
import br.com.gym.gymcontrol.service.CategoriaService;
import br.com.gym.gymcontrol.service.ProfessorService;

@RestController
@RequestMapping("/professores")
public class ProfessorResource {

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<ProfessorDto>> getProfessores() {
	List<Professor> profs = professorService.bucarProfessores();
	List<ProfessorDto> professorDto = profs.stream().map(p -> new ProfessorDto(p)).collect(Collectors.toList());
	return ResponseEntity.ok(professorDto);
    }

    @PostMapping
    public ResponseEntity<ProfessorDto> setProfessores(@RequestBody @Valid ProfessorForm professorForm,
	    UriComponentsBuilder builder) {
	Professor professor = professorService.inserirProfessor(professorForm.converterEmProfessor(categoriaService));
	URI uri = builder.path("/{id}").buildAndExpand(professor.getId()).toUri();
	return ResponseEntity.created(uri).body(new ProfessorDto(professor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> editProfessores(@Valid @RequestBody ProfessorForm professorForm,
	    @PathVariable Long id) {
	Professor professor = professorService.buscarProfessorPorId(id);

	List<Categoria> idCategoriaList = categoriaService.buscarCategoriaPorIds(professorForm.getIdCategorias());

	professor.setNome(professorForm.getNome());
	professor.setAlcunha(professorForm.getAlcunha());
	professor.setTipoPessoa(professorForm.getTipoPessoa());
	professor.setCategorias(idCategoriaList);

	professorService.inserirProfessor(professor);

	return ResponseEntity.noContent().build();

    }

    @DeleteMapping
    public ResponseEntity<Void> deleteProfessores() {
	return null;
    }
}
