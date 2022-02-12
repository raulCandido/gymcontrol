package br.com.gym.gymcontrol.service;

import br.com.gym.gymcontrol.model.Categoria;

import java.util.List;

public interface CategoriaService {

    List<Categoria> buscarCategorias();

    Categoria inserirCategoria(Categoria categoria);

    List<Categoria> buscarCategoriaPorIds(List<Long> ids);

    Categoria buscarCategoriaPorId(Long id);

    void deletarCategoriaPorId(Long id);

}
