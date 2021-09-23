package br.com.gym.gymcontrol.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Aluno extends Pessoa {

    private static final long serialVersionUID = 1L;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "aluno_turma", joinColumns = { @JoinColumn(name = "aluno_id") }, inverseJoinColumns = {
	    @JoinColumn(name = "turma_id") })
    private List<Turma> turmas;

    public Aluno(String nome, String alcunha, LocalDate dataNascimento, TipoPessoa tipoPessoa, List<Turma> turmas) {
	this.nome = nome;
	this.alcunha = alcunha;
	this.dataNascimento = dataNascimento;
	this.tipoPessoa = tipoPessoa;
	this.turmas = turmas;
    }

}
