package br.com.gym.gymcontrol.model.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;


public record AlunoNewDto(@NotEmpty(message = "Nome obrigatório") String nome,
                          @NotEmpty(message = "Apelido obrigatório") String apelido,
                          @NotNull(message = "Data de nascimento obrigatória") LocalDate dataNascimento,
                          @NotNull(message = "Necessário informar turma") List<Long> idTurmas) {
}
