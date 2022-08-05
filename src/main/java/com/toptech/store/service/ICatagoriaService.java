package com.toptech.store.service;

import java.util.List;
import java.util.Optional;

import com.toptech.store.model.Categoria;

public interface ICatagoriaService{
	
	public Categoria saveCategoria(Categoria categoria);
	public void updateCategoria(Categoria categoria);
	public void deleteCategoria(Integer id);
	public Optional<Categoria> getCategoria(Integer id);
	public List<Categoria> findAll();
	public Optional<Categoria> findByNombre(String nombre);

}
