package br.com.gym.gymcontrol.model.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TurmaForm {

    @NotEmpty(message = "Nome obrigatório")
    private String nome;

    @NotNull(message = "Categoria obrigatória")
    private Long idCategoria;

    @NotNull(message = "Categoria obrigatória")
    private Long idProfessor;

}
