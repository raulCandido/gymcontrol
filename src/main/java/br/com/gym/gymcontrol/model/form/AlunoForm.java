package br.com.gym.gymcontrol.model.form;

import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.gym.gymcontrol.model.Aluno;
import br.com.gym.gymcontrol.model.TipoPessoa;

public class AlunoForm {

    @NotEmpty(message = "Nome obrigatório")
    private String nome;

    @NotEmpty(message = "Alcunha obrigatório")
    private String alcunha;

    @NotNull(message = "Data de nascimento obrigatória")
    private LocalDate dataNascimento;

    @NotNull(message = "Tipo obrigatório")
    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa;

    public AlunoForm() {
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

    public LocalDate getDataNascimento() {
	return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
	this.dataNascimento = dataNascimento;
    }

    public TipoPessoa getTipoPessoa() {
	return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
	this.tipoPessoa = tipoPessoa;
    }

    public Aluno converterParaPessoa() {
	return new Aluno(this.nome, this.alcunha, this.dataNascimento, this.tipoPessoa);
    }

}
