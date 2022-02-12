package br.com.gym.gymcontrol.model.form;

import br.com.gym.gymcontrol.model.Categoria;
import br.com.gym.gymcontrol.model.Professor;
import br.com.gym.gymcontrol.service.CategoriaService;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class ProfessorForm {

    @NotEmpty
    protected String nome;
    @NotEmpty
    protected String alcunha;

    @NotNull
    private List<Long> idCategorias;

}
