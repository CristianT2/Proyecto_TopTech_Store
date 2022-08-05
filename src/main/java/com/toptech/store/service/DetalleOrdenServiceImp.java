package com.toptech.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toptech.store.model.DetalleOrden;
import com.toptech.store.repository.IDetalleOrdenRepository;

@Service
public class DetalleOrdenServiceImp implements IDetalleOrdenService{

	@Autowired
	private IDetalleOrdenRepository detalleRepository;
	
	@Override
	public DetalleOrden saveDetalleOrden(DetalleOrden detalleOrden) {
		return detalleRepository.save(detalleOrden);
	}

}
