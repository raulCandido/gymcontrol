package br.com.gym.gymcontrol.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public record TokenRequestDto(String token, String tipo) {
}
