package br.com.gym.gymcontrol.model.dto.request;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.constraints.NotEmpty;

public record LoginRequestDto(@NotEmpty(message = "E-mail obrigatório") String email,
                              @NotEmpty(message = "Senha obrigatório") String senha) {
}
