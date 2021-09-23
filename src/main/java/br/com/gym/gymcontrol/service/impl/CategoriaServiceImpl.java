package br.com.gym.gymcontrol.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import br.com.gym.gymcontrol.model.Categoria;
import br.com.gym.gymcontrol.repository.CategoriaRepository;
import br.com.gym.gymcontrol.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> buscarCategorias() {
	List<Categoria> categorias = categoriaRepository.findAll();
	return verificarCategoriasVazia(categorias);
    }

    @Override
    public Categoria inserirCategoria(Categoria categoria) {
	return categoriaRepository.save(categoria);
    }

    @Override
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

    @Override
    public Categoria buscarCategoriaPorId(Long id) {
	Optional<Categoria> opt = categoriaRepository.findById(id);
	return opt.orElseThrow(() -> new ResourceNotFoundException("Nenhuma categoria encontrada"));
    }

    @Override
    public void deletarCategoriaPorId(Long id) {
	Categoria categoria = buscarCategoriaPorId(id);
	categoriaRepository.delete(categoria);
    }
}
