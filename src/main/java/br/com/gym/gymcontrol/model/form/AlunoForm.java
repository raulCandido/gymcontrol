package br.com.gym.gymcontrol.model.form;

import br.com.gym.gymcontrol.model.Aluno;
import br.com.gym.gymcontrol.model.Turma;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoForm {

    @NotEmpty(message = "Nome obrigatório")
    private String nome;

    @NotEmpty(message = "Alcunha obrigatório")
    private String alcunha;

    @NotNull(message = "Data de nascimento obrigatória")
    private LocalDate dataNascimento;

    @NotNull(message = "Necessário informar turma")
    private List<Long> idTurmas;

    public Aluno converterParaAluno(List<Turma> turmas) {
        return new Aluno(this.nome, this.alcunha, this.dataNascimento, turmas);
    }


}
