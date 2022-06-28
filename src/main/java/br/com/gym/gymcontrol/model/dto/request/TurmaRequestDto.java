package br.com.gym.gymcontrol.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

public record TurmaRequestDto(@NotEmpty(message = "Nome obrigatório") String nome,
                              @NotNull(message = "Categoria obrigatória") @JsonProperty("id_categoria") Long idCategoria,
                              @NotNull(message = "Horario da turma é obrigatório") @JsonProperty("horario_turma") LocalTime horarioTurma) {
}
