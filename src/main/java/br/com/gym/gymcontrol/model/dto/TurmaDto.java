package br.com.gym.gymcontrol.model.dto;

import br.com.gym.gymcontrol.model.Turma;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TurmaDto {

    @JsonProperty("id_turma")
    private Long idTurma;

    @JsonProperty("nome_turma")
    private String nome;

    @JsonProperty("horario_turma")
    private LocalTime horarioTurma;

    @JsonProperty("turma_categoria")
    private CategoriaDto categoria;

    public TurmaDto(Turma turma) {
        this.idTurma = turma.getId();
        this.nome = turma.getNome();
        this.horarioTurma = turma.getHorarioTurma();
        this.categoria = turma.getCategoria().toDto();
    }


}
