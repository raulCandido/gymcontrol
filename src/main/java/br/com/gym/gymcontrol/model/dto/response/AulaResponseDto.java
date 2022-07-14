package br.com.gym.gymcontrol.model.dto.response;

import java.time.LocalDate;
import java.util.List;

public record AulaResponseDto(Long id,
                              TurmaResponseDto turma,
                              LocalDate data,
                              List<AlunoResponseDto> alunosPresentes) {
}
