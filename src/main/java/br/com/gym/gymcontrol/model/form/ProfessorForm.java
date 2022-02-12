package br.com.gym.gymcontrol.model.form;

import br.com.gym.gymcontrol.model.Categoria;
import br.com.gym.gymcontrol.model.Professor;
import br.com.gym.gymcontrol.service.CategoriaService;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ProfessorForm {

    @NotEmpty
    protected String nome;
    @NotEmpty
    protected String alcunha;

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


    public List<Long> getIdCategorias() {
        return idCategorias;
    }

    public void setIdCategorias(List<Long> categorias) {
        this.idCategorias = categorias;
    }

    public Professor converterEmProfessor(CategoriaService categoriaService) {
        List<Categoria> categorias = categoriaService.buscarCategoriaPorIds(idCategorias);
        return new Professor(nome, alcunha, categorias);
    }

}
