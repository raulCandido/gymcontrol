package br.com.gym.gymcontrol.model.dto;

import br.com.gym.gymcontrol.model.Categoria;
import br.com.gym.gymcontrol.model.Turma;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProfessorDto {
    private Long id;

    private String nome;

    private String apelido;

    private List<TurmaDto> turmas;

    private List<CategoriaDto> categorias;

}
