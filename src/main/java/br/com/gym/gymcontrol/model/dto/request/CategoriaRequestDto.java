package br.com.gym.gymcontrol.model.dto.request;

import javax.validation.constraints.NotEmpty;


public record CategoriaRequestDto(@NotEmpty(message = "Nome da categoria obrigatório") String nomeCategoria) {
}
