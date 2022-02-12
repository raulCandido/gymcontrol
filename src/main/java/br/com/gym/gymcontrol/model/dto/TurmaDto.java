package br.com.gym.gymcontrol.model.dto;

import br.com.gym.gymcontrol.model.Turma;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TurmaDto {

    private Long id;

    private String nomeTurma;

    private String nomeCategoria;

    private String nomeProfessor;

    public TurmaDto(Turma turma) {
        super();
        this.id = turma.getId();
        this.nomeTurma = turma.getNome();
        this.nomeCategoria = turma.getCategoria().getNomeCategoria();
        this.nomeProfessor = turma.getProfessor().getNome();
    }

}
