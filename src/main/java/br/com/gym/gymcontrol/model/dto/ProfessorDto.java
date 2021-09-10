package br.com.gym.gymcontrol.model.dto;

import java.util.List;

import br.com.gym.gymcontrol.model.Categoria;
import br.com.gym.gymcontrol.model.Professor;

public class ProfessorDto {
    private Long id;

    private String nome;

    private String alcunha;

    private List<Categoria> categorias;

    public ProfessorDto() {
        super();
    }

    public ProfessorDto(Professor professor) {
        this.id = professor.getId();
        this.nome = professor.getNome();
        this.alcunha = professor.getAlcunha();
        this.categorias = professor.getCategorias();
    }

    public ProfessorDto(Long id, String nome, String alcunha) {
        super();
        this.id = id;
        this.nome = nome;
        this.alcunha = alcunha;

    }

    @Override
    public String toString() {
        return "ID: " + this.id + ", NOME: " + this.nome + ", ALCUNHA: " + this.alcunha;
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

    public String getAlcunha() {
        return alcunha;
    }

    public void setAlcunha(String alcunha) {
        this.alcunha = alcunha;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

}
