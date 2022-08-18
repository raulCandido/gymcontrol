package br.com.gym.gymcontrol.controller;

import br.com.gym.gymcontrol.model.Categoria;
import br.com.gym.gymcontrol.model.dto.response.AlunoResponseDto;
import br.com.gym.gymcontrol.model.mapper.CategoriaMapper;
import br.com.gym.gymcontrol.service.CategoriaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class CategoriaControllerTest {

    @Mock
    private CategoriaService categoriaService;

    @InjectMocks
    private CategoriaController categoriaController;

    private CategoriaMapper categoriaMapper = Mappers.getMapper(CategoriaMapper.class);

    @BeforeEach
    void setUp() {
        categoriaController = new CategoriaController(categoriaService, categoriaMapper);
    }

    @Test
    void getCategorias() {
        Mockito.when(categoriaService.buscarCategorias()).thenReturn(Arrays.asList(new Categoria()));
        var response = categoriaController.getCategorias();
        Assertions.assertEquals(200, response.getStatusCode().value());
    }

    @Test
    void cadastrarCategoria() {
        Mockito.when(categoriaService.inserirCategoria(any())).thenReturn(Categoria.builder().id(10).build());
        var response = categoriaController.cadastrarCategoria(any(), UriComponentsBuilder.newInstance());
        Assertions.assertEquals(201, response.getStatusCode().value());
        Assertions.assertEquals(10, response.getBody().id());

    }

    @Test
    void editAlunos() {
    }

    @Test
    void deletarCategoria() {
        Mockito.doNothing().when(categoriaService).deletarCategoriaPorId(any());
        var response = categoriaController.deletarCategoria(any());
        Mockito.verify(categoriaService, Mockito.times(1)).deletarCategoriaPorId(any());
        assertEquals(204, response.getStatusCodeValue());
    }
}