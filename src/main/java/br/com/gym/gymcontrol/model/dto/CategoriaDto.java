package br.com.gym.gymcontrol.model.dto;

import br.com.gym.gymcontrol.model.Categoria;

public class CategoriaDto {

    private long id;
    private String nomeCategoria;

    public CategoriaDto(Categoria categoria) {
	super();
	this.id = categoria.getId();
	this.nomeCategoria = categoria.getNomeCategoria();
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public String getNomeCategoria() {
	return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
	this.nomeCategoria = nomeCategoria;
    }

}
