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

import br.com.gym.gymcontrol.model.Aluno;
import br.com.gym.gymcontrol.model.Categoria;
import br.com.gym.gymcontrol.model.dto.CategoriaDto;
import br.com.gym.gymcontrol.model.form.CategoriaForm;
import br.com.gym.gymcontrol.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaDto>> getCategorias() {
	List<Categoria> categorias = categoriaService.buscarCategorias();
	return ResponseEntity.ok(categorias.stream().map(CategoriaDto::new).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<CategoriaDto> cadastrarCategoria(@RequestBody @Valid CategoriaForm categoriaForm,
	    UriComponentsBuilder builder) {
	Categoria categoria = categoriaService.inserirCategoria(categoriaForm.converterParaCategoria());
	URI uri = builder.path("/{id}").buildAndExpand(categoria.getId()).toUri();
	return ResponseEntity.created(uri).body(new CategoriaDto(categoria));
    }

    @PutMapping
    public ResponseEntity<Aluno> editAlunos() {
	return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable Long id) {
	categoriaService.deletarCategoriaPorId(id);
	return ResponseEntity.noContent().build();
    }
}
