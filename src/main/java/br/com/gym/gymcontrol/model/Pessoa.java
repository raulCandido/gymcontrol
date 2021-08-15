package br.com.gym.gymcontrol.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Campo obrigatório")
    private String nome;

    @NotEmpty(message = "Campo obrigatório")
    private String alcunha;

    @NotNull(message = "Campo obrigatório")
    private LocalDate dataNascimento;

    @NotNull(message = "Campo obrigatório")
    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa;

    public Pessoa() {
    }

    public Pessoa(String nome, String alcunha, LocalDate dataNascimento, TipoPessoa tipoPessoa) {
	super();
	this.nome = nome;
	this.alcunha = alcunha;
	this.dataNascimento = dataNascimento;
	this.tipoPessoa = tipoPessoa;
    }

    public String getAlcunha() {
	return alcunha;
    }

    public void setAlcunha(String alcunha) {
	this.alcunha = alcunha;
    }

    public TipoPessoa getTipoPessoa() {
	return tipoPessoa;
    }

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

    public LocalDate getDataNascimento() {
	return dataNascimento;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
	this.tipoPessoa = tipoPessoa;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
	this.dataNascimento = dataNascimento;
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
	Pessoa other = (Pessoa) obj;
	return Objects.equals(id, other.id);
    }

}
