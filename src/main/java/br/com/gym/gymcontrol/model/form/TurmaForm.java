package br.com.gym.gymcontrol.model.form;

import br.com.gym.gymcontrol.exception.BadRequestException;
import br.com.gym.gymcontrol.model.Categoria;
import br.com.gym.gymcontrol.model.Professor;
import br.com.gym.gymcontrol.model.Turma;
import br.com.gym.gymcontrol.service.CategoriaService;
import br.com.gym.gymcontrol.service.ProfessorService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TurmaForm {

    @NotEmpty(message = "Nome obrigatório")
    private String nome;

    @NotNull(message = "Categoria obrigatória")
    private Long idCategoria;

    @NotNull(message = "Categoria obrigatória")
    private Long idProfessor;

    public Turma converterEmTurma(ProfessorService professorService, CategoriaService categoriaService) {
        Categoria categoria = categoriaService.buscarCategoriaPorId(idCategoria);
        Professor professor = professorService.buscarProfessorPorId(idProfessor);

        boolean anyMatch = professor.getCategorias().stream().anyMatch(c -> c.getId() == categoria.getId());
        if (!anyMatch) {
            throw new BadRequestException("Professor deve ser vinculado a categoria da turma.");
        }
        return new Turma(nome, categoria, professor);
    }

}
