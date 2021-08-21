package br.com.gym.gymcontrol.model.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.gym.gymcontrol.model.Categoria;
import br.com.gym.gymcontrol.model.Professor;

public class TurmaForm {

    @NotEmpty(message = "Nome obrigatório")
    private String nome;

    @NotNull(message = "Categoria obrigatória")
    private Categoria categoria;

    @NotNull(message = "Categoria obrigatória")
    private Professor professor;

    public TurmaForm(String nome, Categoria categoria, Professor professor) {
	super();
	this.nome = nome;
	this.categoria = categoria;
	this.professor = professor;
    }

}
