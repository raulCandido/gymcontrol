package br.com.gym.gymcontrol.model.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class ProfessorForm {

    @NotEmpty(message = "Nome obrigatório")
    protected String nome;

    @NotEmpty(message = "Alcunha obrigatório")
    protected String apelido;

    @NotNull(message = "Lista de categorias é obrigatório")
    private List<Long> idCategorias;

}
