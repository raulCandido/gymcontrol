package br.com.gym.gymcontrol.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalTime;

public record TurmaResponseDto(@JsonProperty("id_turma") Long idTurma, @JsonProperty("nome_turma") String nome,
                               @JsonProperty("horario_turma") LocalTime horarioTurma, @JsonProperty("turma_categoria")
                               CategoriaResponseDto categoria) {
}
