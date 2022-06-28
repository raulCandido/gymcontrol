package br.com.gym.gymcontrol.model.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public record ProfessorRequestDto(@NotEmpty(message = "Nome obrigatório") String nome,
                                  @NotEmpty(message = "Alcunha obrigatório") String apelido,
                                  @NotNull(message = "Lista de categorias é obrigatório") List<Long> idCategorias) {
}
