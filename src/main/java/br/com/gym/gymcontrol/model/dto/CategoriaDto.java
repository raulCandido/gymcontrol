package br.com.gym.gymcontrol.model.dto;

import br.com.gym.gymcontrol.model.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDto {

    private long id;
    private String nomeCategoria;

    public CategoriaDto(Categoria categoria) {
        super();
        this.id = categoria.getId();
        this.nomeCategoria = categoria.getNomeCategoria();
    }

}
