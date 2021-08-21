package br.com.gym.gymcontrol.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Professor extends Pessoa {

    private static final long serialVersionUID = 1L;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "professor")
    private List<Turma> turmas;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "professores")
    private List<Categoria> categorias;

    public List<Categoria> getCategorias() {
	return categorias;
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
