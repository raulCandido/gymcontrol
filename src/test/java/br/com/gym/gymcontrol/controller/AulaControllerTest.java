package br.com.gym.gymcontrol.controller;

import br.com.gym.gymcontrol.model.Aluno;
import br.com.gym.gymcontrol.model.Aula;
import br.com.gym.gymcontrol.model.Turma;
import br.com.gym.gymcontrol.model.dto.response.AulaResponseDto;
import br.com.gym.gymcontrol.model.mapper.AulaMapper;
import br.com.gym.gymcontrol.service.AlunoService;
import br.com.gym.gymcontrol.service.AulaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class AulaControllerTest {

    @Mock
    private AulaService aulaService;

    private final AulaMapper aulaMapper = Mappers.getMapper(AulaMapper.class);

    private AulaController aulaController;

    @BeforeEach
    void setUp() {
        aulaController = new AulaController(aulaService, aulaMapper);
    }

    @Test
    void testGetAulas() {
        Aula aula = Aula.builder()
                .id(1L)
                .turma(new Turma())
                .data(LocalDate.of(2020, 10, 10))
                .alunosPresentes(Arrays.asList(new Aluno())).build();
        Mockito.when(aulaService.buscarAulas()).thenReturn(Arrays.asList(aula));

        ResponseEntity<List<AulaResponseDto>> response = aulaController.getAulas();

        Assertions.assertEquals(200, response.getStatusCode().value());
    }

    @Test
    void salvarAula() {
        Aula aula = Aula.builder()
                .id(1L)
                .turma(new Turma())
                .data(LocalDate.of(2020, 10, 10))
                .alunosPresentes(Arrays.asList(new Aluno())).build();

        Mockito.when(aulaService.montarAulaParaPersistir(any())).thenReturn(aula);

        ResponseEntity<AulaResponseDto> response = aulaController.salvarAula(any(), UriComponentsBuilder.newInstance());

        Assertions.assertEquals(200, response.getStatusCode().value());
    }

}