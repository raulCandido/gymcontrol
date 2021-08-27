package br.com.gym.gymcontrol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import br.com.gym.gymcontrol.model.Categoria;
import br.com.gym.gymcontrol.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> buscarCategorias() {
	List<Categoria> categorias = categoriaRepository.findAll();
	return verificarCategoriasVazia(categorias);
    }

    public Categoria inserirCategoria(Categoria categoria) {
	return categoriaRepository.save(categoria);
    }

    public List<Categoria> buscarCategoriaPorIds(List<Long> ids) {
	List<Categoria> categorias = categoriaRepository.findAllById(ids);
	return verificarCategoriasVazia(categorias);
    }

    private List<Categoria> verificarCategoriasVazia(List<Categoria> categorias) {
	if (categorias.isEmpty()) {
	    throw new ResourceNotFoundException("Nenhuma categoria encontrada");
	}
	return categorias;
    }
}
