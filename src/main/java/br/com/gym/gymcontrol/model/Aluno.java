package br.com.gym.gymcontrol.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Aluno extends Pessoa {

    private static final long serialVersionUID = 1L;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "alunos")
    private List<Turma> turmas;
    
    public Aluno(String nome, String alcunha, LocalDate dataNascimento, TipoPessoa tipoPessoa) {
	this.nome = nome;
	this.alcunha = alcunha;
	this.dataNascimento = dataNascimento;
	this.tipoPessoa = tipoPessoa;
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
	Aluno other = (Aluno) obj;
	return Objects.equals(id, other.id);
    }

}
