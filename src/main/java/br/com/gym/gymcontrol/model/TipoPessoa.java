package br.com.gym.gymcontrol.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoPessoa {
    PROFESSOR("Professor"), ALUNO("Aluno");

    private final String descricao;

    TipoPessoa(String descricao) {
        this.descricao = descricao;
    }

    @JsonValue
    public String getDescricao() {
        return descricao;
    }

}
