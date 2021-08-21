package br.com.gym.gymcontrol.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Professor extends Pessoa {

    private static final long serialVersionUID = 1L;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "professor", fetch = FetchType.LAZY)
    private List<Turma> turmas;

    @ManyToMany()
    @JoinTable(name = "professor_categoria", joinColumns = { @JoinColumn(name = "professor_id") }, inverseJoinColumns = {@JoinColumn(name = "categoria_id") })
    private List<Categoria> categorias;

    public List<Categoria> getCategorias() {
	return categorias;
    }

    public Professor() {
    }

    public Professor(String nome, String alcunha, TipoPessoa tipoPessoa, List<Categoria> categorias) {
	this.nome = nome;
	this.alcunha = alcunha;
	this.tipoPessoa = tipoPessoa;
	this.categorias = categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
	this.categorias = categorias;
    }

    public List<Turma> getTurmas() {
	return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
	this.turmas = turmas;
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
	Professor other = (Professor) obj;
	return Objects.equals(id, other.id);
    }

}
