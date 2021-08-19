package br.com.gym.gymcontrol.model.form;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.gym.gymcontrol.model.TipoPessoa;

public class PessoaForm {
    @NotEmpty(message = "Nome obrigatório")
    private String nome;
    @NotEmpty(message = "Alcunha obrigatório")
    private String alcunha;
    @NotNull(message = "Tipo obrigatório")
    private TipoPessoa tipoPessoa;

    @NotNull(message = "Data de nascimento obrigatório")
    private LocalDate dataNascimento;

    public PessoaForm(@NotEmpty(message = "Nome obrigatório") String nome,
	    @NotEmpty(message = "Alcunha obrigatório") String alcunha,
	    @NotNull(message = "Tipo obrigatório") TipoPessoa tipoPessoa,
	    @NotNull(message = "Data de nascimento obrigatório") LocalDate dataNascimento) {
	super();
	this.nome = nome;
	this.alcunha = alcunha;
	this.tipoPessoa = tipoPessoa;
	this.dataNascimento = dataNascimento;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
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

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
	this.tipoPessoa = tipoPessoa;
    }

    public LocalDate getDataNascimento() {
	return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
	this.dataNascimento = dataNascimento;
    }

}
