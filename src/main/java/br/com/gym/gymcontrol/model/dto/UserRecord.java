package br.com.gym.gymcontrol.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserRecord (String email, String senha, @JsonProperty("id_professor") Long idProfessor){}
