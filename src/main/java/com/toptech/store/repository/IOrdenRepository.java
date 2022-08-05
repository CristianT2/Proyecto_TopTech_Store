package com.toptech.store.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toptech.store.model.Orden;
import com.toptech.store.model.Usuario;

@Repository
public interface IOrdenRepository extends JpaRepository<Orden, Integer>{
	
	public List<Orden> findByUsuario(Usuario usuario);

}
