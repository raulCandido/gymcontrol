package br.com.gym.gymcontrol.model.form;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.gym.gymcontrol.model.Categoria;
import br.com.gym.gymcontrol.model.Professor;
import br.com.gym.gymcontrol.model.TipoPessoa;
import br.com.gym.gymcontrol.service.CategoriaService;

public class ProfessorForm {

    @NotEmpty
    protected String nome;
    @NotEmpty
    protected String alcunha;
    @NotNull
    protected TipoPessoa tipoPessoa;

    @NotNull
    private List<Long> idCategorias;

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

    public List<Long> getIdCategorias() {
	return idCategorias;
    }

    public void setIdCategorias(List<Long> categorias) {
	this.idCategorias = categorias;
    }

    public Professor converterEmProfessor(CategoriaService categoriaService) {
	List<Categoria> categorias = categoriaService.buscarCategoriaPorIds(idCategorias);
	return new Professor(nome, alcunha, tipoPessoa, categorias);
    }

}
