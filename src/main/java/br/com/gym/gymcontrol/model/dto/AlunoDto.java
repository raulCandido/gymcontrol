package br.com.gym.gymcontrol.model.dto;

import java.time.LocalDate;

import br.com.gym.gymcontrol.model.Aluno;
import br.com.gym.gymcontrol.model.TipoPessoa;

public class AlunoDto {

    private Long id;
    private String nome;
    private String alcunha;
    private LocalDate dataNascimento;
    private TipoPessoa tipoPessoa;

    public AlunoDto(Aluno aluno) {
        super();
        this.id = aluno.getId();
        this.nome = aluno.getNome();
        this.alcunha = aluno.getAlcunha();
        this.dataNascimento = aluno.getDataNascimento();
        this.tipoPessoa = aluno.getTipoPessoa();
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
