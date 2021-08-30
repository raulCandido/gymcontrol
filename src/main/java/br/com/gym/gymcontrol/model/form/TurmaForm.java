package br.com.gym.gymcontrol.model.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.web.bind.MethodArgumentNotValidException;

import br.com.gym.gymcontrol.exception.BadRequestException;
import br.com.gym.gymcontrol.model.Categoria;
import br.com.gym.gymcontrol.model.Professor;
import br.com.gym.gymcontrol.model.Turma;
import br.com.gym.gymcontrol.service.CategoriaService;
import br.com.gym.gymcontrol.service.ProfessorService;

public class TurmaForm {

    @NotEmpty(message = "Nome obrigatório")
    private String nome;

    @NotNull(message = "Categoria obrigatória")
    private Long idCategoria;

    @NotNull(message = "Categoria obrigatória")
    private Long idProfessor;

    public TurmaForm(String nome, Long idCategoria, Long idProfessor) {
	super();
	this.nome = nome;
	this.idCategoria = idCategoria;
	this.idProfessor = idProfessor;
    }

    public Turma converterEmTurma(ProfessorService professorService, CategoriaService categoriaService) {
	Categoria categoria = categoriaService.buscarCategoriaPorid(idCategoria);
	Professor professor = professorService.buscarProfessorPorId(idProfessor);

	boolean anyMatch = professor.getCategorias().stream().anyMatch(c -> c.getId() == categoria.getId());
	if(!anyMatch) {
	    throw new BadRequestException("Professor deve ser vinculado a categoria da aula.");
	}
	return new Turma(nome, categoria, professor);
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public Long getIdCategoria() {
	return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
	this.idCategoria = idCategoria;
    }

    public Long getIdProfessor() {
	return idProfessor;
    }

    public void setIdProfessor(Long idProfessor) {
	this.idProfessor = idProfessor;
    }

}
