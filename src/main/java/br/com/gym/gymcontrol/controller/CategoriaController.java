package br.com.gym.gymcontrol.controller;

import br.com.gym.gymcontrol.model.Aluno;
import br.com.gym.gymcontrol.model.Categoria;
import br.com.gym.gymcontrol.model.dto.request.CategoriaRequestDto;
import br.com.gym.gymcontrol.model.dto.response.CategoriaResponseDto;
import br.com.gym.gymcontrol.model.mapper.CategoriaMapper;
import br.com.gym.gymcontrol.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private CategoriaService categoriaService;

    private CategoriaMapper categoriaMapper;

    @Autowired
    public CategoriaController(CategoriaService categoriaService, CategoriaMapper categoriaMapper) {
        this.categoriaService = categoriaService;
        this.categoriaMapper = categoriaMapper;
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponseDto>> getCategorias() {
        List<Categoria> categorias = categoriaService.buscarCategorias();
        return ResponseEntity.ok(categorias.stream().map(categoriaMapper::modelToResponseDto).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<CategoriaResponseDto> cadastrarCategoria(@RequestBody @Valid CategoriaRequestDto categoriaRequestDto,
                                                                   UriComponentsBuilder builder) {
        Categoria categoria = categoriaService.inserirCategoria(categoriaMapper.requestDtoToModel(categoriaRequestDto));
        URI uri = builder.path("/{id}").buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uri).body(categoriaMapper.modelToResponseDto(categoria));
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
