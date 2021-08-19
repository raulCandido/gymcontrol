package br.com.gym.gymcontrol.model.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import br.com.gym.gymcontrol.model.Pessoa;
import br.com.gym.gymcontrol.model.TipoPessoa;

public class PessoaDto {

    private String nome;
    private String alcunha;
    private TipoPessoa tipoPessoa;
    private LocalDate dataNascimento; 

    public PessoaDto() {
    }
    
    public PessoaDto(Pessoa pessoa) {
	this.nome = pessoa.getNome();
	this.alcunha = pessoa.getAlcunha();
	this.tipoPessoa = pessoa.getTipoPessoa();
	this.dataNascimento = pessoa.getDataNascimento();
    }

    public static Page<PessoaDto> converterPessoasEmPessoasDto(Page<Pessoa> pessoas) {
	return pessoas.map(PessoaDto::new);
    }
    
    public static List<PessoaDto> converterPessoasEmPessoasDto(List<Pessoa> pessoas) {
  	return pessoas.stream().map(PessoaDto::new).collect(Collectors.toList());
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

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
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

}
