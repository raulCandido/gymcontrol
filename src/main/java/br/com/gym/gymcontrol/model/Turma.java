package br.com.gym.gymcontrol.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

public class Turma implements Serializable {

    /**
     * @author raul
     */
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String nome;
    private Categoria categoria;
    @ManyToOne(fetch = FetchType.LAZY)
    private Professor professor;
    private List<Aluno> alunos;
    private List<Aula> aulas;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
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

    public List<Aluno> getAlunos() {
	return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
	this.alunos = alunos;
    }

    public List<Aula> getAulas() {
	return aulas;
    }

    public void setAulas(List<Aula> aulas) {
	this.aulas = aulas;
    }

    @Override
    public int hashCode() {
	return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Turma other = (Turma) obj;
	return Objects.equals(id, other.id);
    }

}
