/**
 * 
 */
package com.toptech.store.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Cristian
 *@version 1.0
 */

@Entity
@Table(name = "ordenes")
public class Orden {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String numOrden;
	private Date fechaCreacion;
	private Date fechaRecibida;
	private double total;
	
	@ManyToOne()
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@OneToMany(mappedBy = "orden")
	private List<DetalleOrden> detalles;
	
	public Orden() {
	
	}

	public Orden(Integer id, String numOrden, Date fechaCreacion, Date fechaRecibida, double total) {
		super();
		this.id = id;
		this.numOrden = numOrden;
		this.fechaCreacion = fechaCreacion;
		this.fechaRecibida = fechaRecibida;
		this.total = total;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumOrden() {
		return numOrden;
	}

	public void setNumOrden(String numOrden) {
		this.numOrden = numOrden;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaRecibida() {
		return fechaRecibida;
	}

	public void setFechaRecibida(Date fechaRecibida) {
		this.fechaRecibida = fechaRecibida;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<DetalleOrden> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleOrden> detalles) {
		this.detalles = detalles;
	}

	@Override
	public String toString() {
		return "Orden [id=" + id + ", numOrden=" + numOrden + ", fechaCreacion=" + fechaCreacion + ", fechaRecibida="
				+ fechaRecibida + ", total=" + total + "]";
	}
	

}
