package br.com.gym.gymcontrol.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

@Entity
public class Categoria implements Serializable {

    /**
     * @author raul
     */
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "Nome da categoria obrigatório")
    private String nomeCategoria;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "categoria")
    private List<Turma> turmas;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "professor_categoria", joinColumns = {@JoinColumn(name = "professor_id") }, inverseJoinColumns = { @JoinColumn(name = "categoria_id") })
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
