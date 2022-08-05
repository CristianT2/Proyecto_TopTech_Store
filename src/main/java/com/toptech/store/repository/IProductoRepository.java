package com.toptech.store.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toptech.store.model.Producto;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Integer>{

	Optional<Producto> findByCategoriaNombreLike(String categoria);
}
