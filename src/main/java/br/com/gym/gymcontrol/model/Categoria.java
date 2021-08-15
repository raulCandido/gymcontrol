package br.com.gym.gymcontrol.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Categoria implements Serializable {

    /**
     * @author raul
     */
    private static final long serialVersionUID = 1L;
    private long id;
    private String nomeCategoria;
    private List<Turma> turmas;
    private List<Professor> professores;

    public List<Professor> getProfessores() {
	return professores;
    }

    public void setProfessores(List<Professor> professores) {
	this.professores = professores;
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public String getNomeCategoria() {
	return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
	this.nomeCategoria = nomeCategoria;
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
	Categoria other = (Categoria) obj;
	return id == other.id;
    }

}
