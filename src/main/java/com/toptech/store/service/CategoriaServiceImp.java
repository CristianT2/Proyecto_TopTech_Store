package com.toptech.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toptech.store.model.Categoria;
import com.toptech.store.repository.ICategoriaRepository;

@Service
public class CategoriaServiceImp implements ICatagoriaService{
	
	@Autowired
	private ICategoriaRepository categoriaRepository;

	@Override
	public Categoria saveCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	@Override
	public void updateCategoria(Categoria categoria) {
		categoriaRepository.save(categoria);
	}

	@Override
	public void deleteCategoria(Integer id) {
		categoriaRepository.deleteById(id);
	}

	@Override
	public Optional<Categoria> getCategoria(Integer id) {
		return categoriaRepository.findById(id);
	}

	@Override
	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}

	@Override
	public Optional<Categoria> findByNombre(String nombre) {
		return categoriaRepository.findByNombre(nombre);
	}

}
