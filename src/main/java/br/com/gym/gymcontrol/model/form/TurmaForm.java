package br.com.gym.gymcontrol.model.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TurmaForm {

    @NotEmpty(message = "Nome obrigatório")
    private String nome;

    @NotNull(message = "Categoria obrigatória")
    @JsonProperty("id_categoria")
    private Long idCategoria;

    @NotNull(message = "Horario da turma é obrigatório")
    @JsonProperty("horario_turma")
    private LocalTime horarioTurma;

}
