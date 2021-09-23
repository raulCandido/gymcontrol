package br.com.gym.gymcontrol.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import br.com.gym.gymcontrol.model.form.PessoaForm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpessoa")
    protected Long id;

    protected String nome;

    protected String alcunha;

    protected LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    protected TipoPessoa tipoPessoa;

    public Pessoa(String nome, String alcunha, LocalDate dataNascimento, TipoPessoa tipoPessoa) {
	super();
	this.nome = nome;
	this.alcunha = alcunha;
	this.dataNascimento = dataNascimento;
	this.tipoPessoa = tipoPessoa;
    }

    public Pessoa(PessoaForm pessoaForm) {
	super();
	this.nome = pessoaForm.getNome();
	this.alcunha = pessoaForm.getAlcunha();
	this.dataNascimento = pessoaForm.getDataNascimento();
	this.tipoPessoa = pessoaForm.getTipoPessoa();
    }

}
