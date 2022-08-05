package com.toptech.store.service;

import java.util.List;
import java.util.Optional;

import com.toptech.store.model.Orden;
import com.toptech.store.model.Usuario;

public interface IOrdenService {
	
	public Orden saveOrden(Orden orden);
	public Optional<Orden> findById(Integer id);
	public List<Orden> findAll();
	public String generarNumOrden();
	public List<Orden> findByUsuario(Usuario usuario);

}
