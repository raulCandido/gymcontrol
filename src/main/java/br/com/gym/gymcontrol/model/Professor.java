package br.com.gym.gymcontrol.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class Professor extends Pessoa {

    private static final long serialVersionUID = 1L;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "professor", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Turma> turmas;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "professor_categoria", joinColumns = {
	    @JoinColumn(name = "professor_id") }, inverseJoinColumns = { @JoinColumn(name = "categoria_id") })
    private List<Categoria> categorias;

    public Professor(String nome, String alcunha, TipoPessoa tipoPessoa, List<Categoria> categorias) {
	this.nome = nome;
	this.alcunha = alcunha;
	this.tipoPessoa = tipoPessoa;
	this.categorias = categorias;
    }

}
