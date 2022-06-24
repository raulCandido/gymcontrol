package br.com.gym.gymcontrol.model.dto;

import br.com.gym.gymcontrol.model.Categoria;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDto {

    @JsonProperty("id_categoria")
    private long id;
    @JsonProperty("nome_categoria")
    private String nomeCategoria;
    public CategoriaDto(Categoria categoria) {
        super();
        this.id = categoria.getId();
        this.nomeCategoria = categoria.getNomeCategoria();
    }

}
