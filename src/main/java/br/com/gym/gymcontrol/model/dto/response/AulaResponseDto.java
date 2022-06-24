package br.com.gym.gymcontrol.model.dto.response;

import br.com.gym.gymcontrol.model.dto.response.AlunoResponseDto;
import br.com.gym.gymcontrol.model.dto.response.TurmaResponseDto;

import java.time.LocalDate;
import java.util.List;

public record AulaResponseDto(Long id,
                              TurmaResponseDto turma,
                              LocalDate data,
                              List<AlunoResponseDto> alunosPresentes) {
}
