package br.com.gym.gymcontrol.controller;

import br.com.gym.gymcontrol.model.Aluno;
import br.com.gym.gymcontrol.model.dto.response.AlunoResponseDto;
import br.com.gym.gymcontrol.model.mapper.AlunoMapper;
import br.com.gym.gymcontrol.service.AlunoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class AlunoControllerTest {

    @Mock
    private AlunoService alunoService;

    private AlunoMapper alunoMapper = Mappers.getMapper(AlunoMapper.class);

    private AlunoController alunoController;

    @BeforeEach
    public void setup() {
        this.alunoController = new AlunoController(alunoService, alunoMapper);
    }

    @Test
    void testPegarAlunos() {
        Aluno aluno = Aluno.builder().id(1L).nome("Raul").apelido("RL").dataNascimento(LocalDate.of(2020, 10, 10)).build();

        Mockito.when(alunoService.buscarAlunos()).thenReturn(Arrays.asList(aluno));
        ResponseEntity<List<AlunoResponseDto>> listResponseEntity = alunoController.pegarAlunos();

        Assertions.assertEquals(200, listResponseEntity.getStatusCode().value());
        Assertions.assertEquals("Raul", listResponseEntity.getBody().get(0).nome());
    }

    @Test
    void testCadastrarAlunos() {
        Aluno aluno = Aluno.builder().id(1L).nome("Raul").apelido("RL").dataNascimento(LocalDate.of(2020, 10, 10)).build();
        Mockito.when(alunoService.montarAlunoParaPersistir(any())).thenReturn(aluno);
        ResponseEntity<AlunoResponseDto> alunoResponseDtoResponseEntity = alunoController.cadastrarAlunos(any(), UriComponentsBuilder.newInstance());

        Assertions.assertEquals(201, alunoResponseDtoResponseEntity.getStatusCode().value());
        Assertions.assertEquals("Raul", alunoResponseDtoResponseEntity.getBody().nome());

    }

    @Test
    void testEditarAlunos() {
        Aluno aluno = Aluno.builder().id(1L).nome("Raul").apelido("RL").dataNascimento(LocalDate.of(2020, 10, 10)).build();
        Mockito.doNothing().when(alunoService).buscarEditarAluno(any(), any());

        ResponseEntity<Void> response = alunoController.editarAlunos(any(), any());
        Mockito.verify(alunoService, Mockito.times(1)).buscarEditarAluno(any(), any());

        Assertions.assertEquals(204, response.getStatusCode().value());
    }

    @Test
    void deletarAlunos() {
        Mockito.doNothing().when(alunoService).buscarDeletarAluno(any());
        ResponseEntity<Void> response = alunoController.deletarAlunos(any());
        Mockito.verify(alunoService, Mockito.times(1)).buscarDeletarAluno(any());
        Assertions.assertEquals(204, response.getStatusCode().value());
    }
}