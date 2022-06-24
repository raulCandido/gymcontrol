package br.com.gym.gymcontrol.model.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;


public record AlunoRequestDto(@NotEmpty(message = "Nome obrigatório") String nome,
                              @NotEmpty(message = "Apelido obrigatório") String apelido,
                              @NotNull(message = "Data de nascimento obrigatória") LocalDate dataNascimento,
                              @NotNull(message = "Necessário informar turma") List<Long> idTurmas) {
}
