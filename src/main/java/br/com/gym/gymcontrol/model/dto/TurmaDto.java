package br.com.gym.gymcontrol.model.dto;

import br.com.gym.gymcontrol.model.Categoria;
import br.com.gym.gymcontrol.model.Professor;
import br.com.gym.gymcontrol.model.Turma;

public class TurmaDto {

    private String nome;

    private Categoria categoria;

    private Professor professor;

    public TurmaDto(Turma turma) {
	super();
	this.nome = turma.getNome();
	this.categoria = turma.getCategoria();
	this.professor = turma.getProfessor();
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public Categoria getCategoria() {
	return categoria;
    }

    public void setCategoria(Categoria categoria) {
	this.categoria = categoria;
    }

    public Professor getProfessor() {
	return professor;
    }

    public void setProfessor(Professor professor) {
	this.professor = professor;
    }

}
