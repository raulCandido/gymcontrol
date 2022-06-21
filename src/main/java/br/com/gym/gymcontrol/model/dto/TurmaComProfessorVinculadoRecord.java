package br.com.gym.gymcontrol.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TurmaComProfessorVinculadoRecord(@JsonProperty("id_turma") Long idturma,
                                               @JsonProperty("nome_turma") String nomeTurma,
                                               @JsonProperty("nome_professor") String nomeProfessor) {}
