package br.com.gym.gymcontrol.model.form;

import br.com.gym.gymcontrol.model.Categoria;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class CategoriaForm {

    @NotEmpty(message = "Nome da categoria obrigatório")
    private String nomeCategoria;

    public Categoria converterParaCategoria() {
        return new Categoria(nomeCategoria);
    }

}
