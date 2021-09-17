package br.com.gym.gymcontrol.model.dto;

import br.com.gym.gymcontrol.model.Categoria;
import br.com.gym.gymcontrol.model.Turma;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TurmaDto {

    private String nome;

    private Categoria categoria;

    private ProfessorDto professorDto;

    public TurmaDto(Turma turma) {
        super();
        this.nome = turma.getNome();
        this.categoria = turma.getCategoria();
        this.professorDto = new ProfessorDto(turma.getProfessor());
    }


}
