package com.toptech.store.service;

import java.util.List;
import java.util.Optional;

import com.toptech.store.model.Usuario;



public interface IUsuarioService {

	List<Usuario> findAll();
	Optional<Usuario> findById(Integer id);
	Usuario saveUsuario (Usuario usuario);
	Optional<Usuario> findByEmail(String email);
}
