package com.toptech.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.toptech.store.model.Orden;
import com.toptech.store.model.Producto;
import com.toptech.store.service.IOrdenService;
import com.toptech.store.service.IProductoService;
import com.toptech.store.service.IUsuarioService;

@Controller
@RequestMapping("administrador")
public class AdministradorController {

	@Autowired
	private IProductoService productoservice;
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private IOrdenService ordenService;
	
	@Autowired
	private Producto producto; 
	
	@GetMapping("/home")
	public String home() {
		return "administrador/index"; 
	}
	
	@GetMapping("/productos")
	public String listProductosPage(Model model) {
		
		List<Producto> productos = productoservice.findAll();
		model.addAttribute("producto", producto);
		model.addAttribute("productos", productos);
		
		return "productos";
	}
	
	@GetMapping("/usuarios")
	public String listaUsuariosPage(Model model) {
		model.addAttribute("usuarios", usuarioService.findAll());
		return "administrador/usuarios";
	}
	
	@GetMapping("/ordenes")
	public String listaOrdenesPage(Model model) {
		model.addAttribute("ordenes", ordenService.findAll());
		return "administrador/ordenes";
	}
	
	@GetMapping("/detalles/{id}")
	public String detallesOrdenesPage(Model model, @PathVariable Integer id) {
		
		Orden orden = ordenService.findById(id).get();
		model.addAttribute("detalleOrden", orden.getDetalles());
		
		return "administrador/detalle-orden";
	}
}
