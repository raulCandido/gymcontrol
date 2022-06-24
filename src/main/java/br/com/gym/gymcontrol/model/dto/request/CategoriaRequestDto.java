package br.com.gym.gymcontrol.model.dto.request;

import br.com.gym.gymcontrol.model.Categoria;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
public record CategoriaRequestDto(@NotEmpty(message = "Nome da categoria obrigatório") String nomeCategoria) {

}
