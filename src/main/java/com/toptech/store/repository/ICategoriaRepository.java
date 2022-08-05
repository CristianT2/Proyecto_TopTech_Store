package com.toptech.store.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toptech.store.model.Categoria;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria, Integer>{

	Optional<Categoria> findByNombre(String nombre);
}
