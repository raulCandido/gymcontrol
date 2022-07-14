package br.com.gym.gymcontrol.model.dto.response;


import com.fasterxml.jackson.annotation.JsonProperty;

public record CategoriaResponseDto(@JsonProperty("id_categoria") long id,
                                   @JsonProperty("nome_categoria") String nomeCategoria) {
}
