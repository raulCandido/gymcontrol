package br.com.gym.gymcontrol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gym.gymcontrol.model.Categoria;
import br.com.gym.gymcontrol.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> buscarCategorias() {
	return categoriaRepository.findAll();
    }

    public Categoria inserirCategoria(Categoria categoria) {
	return categoriaRepository.save(categoria);
    }

}
