/**
 * 
 */
package com.toptech.store.model;

import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String apellido;
	private String telefono;
	private String direccion;
	private String email;
	private String username;
	private String password;
	private String tipo;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Producto> productos;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Orden> ordenes;
	
	public Usuario() {
		
	}
	
	public Usuario(Integer id, String nombre, String apellido, String telefono, String direccion, String email,
			String username, String password, String tipo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.direccion = direccion;
		this.email = email;
		this.username = username;
		this.password = password;
		this.tipo = tipo;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public List<Orden> getOrdenes() {
		return ordenes;
	}

	public void setOrdenes(List<Orden> ordenes) {
		this.ordenes = ordenes;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono
				+ ", direccion=" + direccion + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", tipo=" + tipo + "]";
	}
	
	
}
