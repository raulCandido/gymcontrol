package br.com.gym.gymcontrol.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public record AulaDto(@NotNull(message = "ID da turma obrigatorio") @JsonProperty("id_turma") Long idTurma,
                      @NotNull(message = "Horario da aula") @JsonProperty("data_aula") LocalDate dataAula,
                      @NotNull(message = "Horario de inicio") @JsonProperty("horario_inicio") LocalTime horarioInicio,
                      @NotNull(message = "Lista de presença dos alunos") @JsonProperty("alunos_presentes") List<Long> alunosPresentes) {
}
