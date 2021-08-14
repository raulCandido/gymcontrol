package br.com.gym.gymcontrol.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoPessoa {
    PROFESSOR("Professor"), ALUNO("Aluno");

    private String descricao;

    private TipoPessoa(String descricao) {
	this.descricao = descricao;
    }

    @JsonValue
    public String getDescricao() {
	return descricao;
    }

}
