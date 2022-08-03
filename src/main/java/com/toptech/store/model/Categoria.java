/**
 * 
 */
package com.toptech.store.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Cristian
 *@version 1.0
 */

@Entity
@Table(name = "categorias")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String descripcion;
	
	@OneToMany(mappedBy = "categoria")
	private List<Producto> productos;
	
	public Categoria() {
		
	}

	public Categoria(Integer id, String nombre, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
	
}
