package br.com.gym.gymcontrol.controller;

import br.com.gym.gymcontrol.model.mapper.AlunoMapper;
import br.com.gym.gymcontrol.model.mapper.AulaMapper;
import br.com.gym.gymcontrol.service.AlunoService;
import br.com.gym.gymcontrol.service.AulaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class AulaControllerTest {

    @Mock
    private AulaService aulaService;

    @Mock
    private AlunoService alunoService;

    private final AulaMapper aulaMapper = Mappers.getMapper(AulaMapper.class);

    private AulaController aulaController;

    @BeforeEach
    void setUp() {
        aulaController = new AulaController(aulaService, alunoService, aulaMapper);
    }

    @Test
    void getAulas() {
    }

    @Test
    void salvarAula() {
    }

    @Test
    void editarAula() {
    }

    @Test
    void deletAlunos() {
    }
}