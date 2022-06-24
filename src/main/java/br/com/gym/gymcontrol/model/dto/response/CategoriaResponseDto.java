package br.com.gym.gymcontrol.model.dto.response;

import br.com.gym.gymcontrol.model.Categoria;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaResponseDto {

    @JsonProperty("id_categoria")
    private long id;
    @JsonProperty("nome_categoria")
    private String nomeCategoria;
    public CategoriaResponseDto(Categoria categoria) {
        super();
        this.id = categoria.getId();
        this.nomeCategoria = categoria.getNomeCategoria();
    }

}
