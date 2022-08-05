package com.toptech.store.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toptech.store.model.Orden;
import com.toptech.store.model.Usuario;
import com.toptech.store.repository.IOrdenRepository;

@Service
public class OrdenServiceImp implements IOrdenService{
	
	@Autowired
	private IOrdenRepository ordenRepository;

	@Override
	public Orden saveOrden(Orden orden) {
		return ordenRepository.save(orden);
	}

	@Override
	public Optional<Orden> findById(Integer id) {
		return ordenRepository.findById(id);
	}

	@Override
	public List<Orden> findAll() {
		return ordenRepository.findAll();
	}

	//Genera un string con numeros incrementales
	public String generarNumOrden() { 
		
		int num = 0;
		String	numConcat = "";
		
		List<Orden> ordenes = findAll();
		List<Integer> numeros = new ArrayList<Integer>();
		
		ordenes.stream().forEach(o -> numeros.add(Integer.parseInt(o.getNumOrden())));
		
		if(ordenes.isEmpty()) {
			num = 1;
		}else {
			num = numeros.stream().max(Integer::compare).get();
			num++;
		}
		
		if (num<10) { //0000001000
			numConcat="000000000"+String.valueOf(num);
		}else if(num<100) {
			numConcat="00000000"+String.valueOf(num);
		}else if(num<1000) {
			numConcat="0000000"+String.valueOf(num);
		}else if(num<10000) {
			numConcat="0000000"+String.valueOf(num);
		}	
		
		return numConcat;
	}

	@Override
	public List<Orden> findByUsuario(Usuario usuario) {
		return ordenRepository.findByUsuario(usuario);
	}
	
	

}
