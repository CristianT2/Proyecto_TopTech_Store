package com.toptech.store.service;

import java.util.List;
import java.util.Optional;

import com.toptech.store.model.Producto;


public interface IProductoService {

	public Producto saveProducto( Producto producto);
	public Optional<Producto> getProducto(Integer id);
	public void updateProducto(Producto producto);
	public void deleteProducto(Integer id);
	public List<Producto> findAll();
	public Optional<Producto> findByCategoria(String categoria);
}
