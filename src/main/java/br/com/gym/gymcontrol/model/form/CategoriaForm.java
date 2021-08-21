package br.com.gym.gymcontrol.model.form;

import javax.validation.constraints.NotEmpty;

import br.com.gym.gymcontrol.model.Categoria;

public class CategoriaForm {

    @NotEmpty(message = "Nome da categoria obrigatório")
    private String nomeCategoria;

    public String getNomeCategoria() {
	return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
	this.nomeCategoria = nomeCategoria;
    }

    public Categoria converterParaCategoria() {
	return new Categoria(nomeCategoria);
    }

}
