package br.com.gym.gymcontrol.model.dto.request;

import javax.validation.constraints.NotEmpty;

public record AuthRequestDto(@NotEmpty(message = "E-mail obrigatório") String email,
                             @NotEmpty(message = "Senha obrigatório") String senha) {
}
