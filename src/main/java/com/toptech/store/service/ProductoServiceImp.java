package com.toptech.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toptech.store.model.Producto;
import com.toptech.store.repository.IProductoRepository;

@Service
public class ProductoServiceImp implements IProductoService{
	
	@Autowired
	private IProductoRepository productoRepository;

	@Override
	public Producto saveProducto(Producto producto) {
		return productoRepository.save(producto);
	}

	@Override
	public Optional<Producto> getProducto(Integer id) {
		return productoRepository.findById(id);
	}

	@Override
	public void updateProducto(Producto producto) {
		productoRepository.save(producto);
	}

	@Override
	public void deleteProducto(Integer id) {
		productoRepository.deleteById(id);
	}

	@Override
	public List<Producto> findAll() {
		return productoRepository.findAll();
	}

	@Override
	public Optional<Producto> findByCategoria(String categoria) {
		return productoRepository.findByCategoriaNombreLike(categoria);
	}

}
