package br.com.gym.gymcontrol.model.dto.response;

import br.com.gym.gymcontrol.model.Turma;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TurmaResponseDto {

    @JsonProperty("id_turma")
    private Long idTurma;

    @JsonProperty("nome_turma")
    private String nome;

    @JsonProperty("horario_turma")
    private LocalTime horarioTurma;

    @JsonProperty("turma_categoria")
    private CategoriaResponseDto categoria;

    public TurmaResponseDto(Turma turma) {
        this.idTurma = turma.getIdTurma();
        this.nome = turma.getNome();
        this.horarioTurma = turma.getHorarioTurma();
        this.categoria = turma.getCategoria().toDto();
    }


}
