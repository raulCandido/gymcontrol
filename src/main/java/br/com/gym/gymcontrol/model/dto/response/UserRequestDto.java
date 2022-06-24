package br.com.gym.gymcontrol.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserRequestDto(String email, String senha, @JsonProperty("id_professor") Long idProfessor){}
