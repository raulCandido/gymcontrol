package br.com.gym.gymcontrol.model.dto;

import br.com.gym.gymcontrol.model.Turma;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TurmaDto {

    private Long id;

    @JsonProperty("nome_turma")
    private String nome;

    @JsonProperty("categoria")
    private CategoriaDto categoria;

    public TurmaDto(Turma turma) {
        this.id = turma.getId();
        this.nome = turma.getNome();
        this.categoria = turma.getCategoria().toDto();
    }


}
