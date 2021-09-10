package br.com.gym.gymcontrol.service;

import java.util.List;

import br.com.gym.gymcontrol.model.Categoria;

public interface CategoriaService {
    
    List<Categoria> buscarCategorias();

    Categoria inserirCategoria(Categoria categoria);

    List<Categoria> buscarCategoriaPorIds(List<Long> ids);

    Categoria buscarCategoriaPorid(Long id);

}
