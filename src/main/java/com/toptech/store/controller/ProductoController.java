package com.toptech.store.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.toptech.store.model.Categoria;
import com.toptech.store.model.Producto;
import com.toptech.store.service.ICatagoriaService;
import com.toptech.store.service.IProductoService;

@Controller
@RequestMapping("/administrador")
public class ProductoController {

	@Autowired
	private IProductoService productoService;
	
	@Autowired
	private ICatagoriaService categoriaService;
	
	@Autowired
	private Producto producto;
	
	List<Categoria> categorias = new ArrayList<Categoria>();
	
	@GetMapping("/producto/nuevo")
	public String productoFormPage(Model model) {
		
		this.categorias = categoriaService.findAll();
		model.addAttribute("categorias", categorias);
		model.addAttribute("producto", producto);
		
		return "producto-form";
	}
	
	@PostMapping("/producto/guardar")
	public ModelAndView guardarProducto(Model model, @RequestParam MultipartFile file, @ModelAttribute Producto producto, BindingResult result ) {
		
		ModelAndView modelView;
		this.categorias = categoriaService.findAll();
		
		if(result.hasErrors()) {
			modelView = new ModelAndView("producto-form");
			modelView.addObject("categorias", categorias);
			return modelView;
		}else {
			modelView = new ModelAndView("producto-form");
			String mensaje="Objeto guardado en la base de datos correctamente";
			model.addAttribute("mensaje", mensaje);
			model.addAttribute("producto", producto);
			modelView.addObject("categorias", categorias);
			productoService.saveProducto(file, producto);
			return modelView;
		}
	}
	
	@GetMapping("/producto/editar/{id}")
	public ModelAndView editarProducto(Model model, @PathVariable Integer id) {
		
		this.categorias = categoriaService.findAll();
		ModelAndView modelView = new ModelAndView("producto-form");
		Optional<Producto> productoOpt = productoService.getProducto(id);
		modelView.addObject("categorias", categorias);
		model.addAttribute("producto", productoOpt);
		
		return modelView;
	}
	
	@GetMapping("/producto/eliminar/{id}")
	public String eliminarProducto(@PathVariable Integer id, Model model) {
		
		productoService.deleteProducto(id);
		return "redirect:/administrador/productos";
	}
	
	@GetMapping("/producto/buscar")
	public String buscarProducto(@ModelAttribute Producto productoB, Model model) {
		
		model.addAttribute("producto", producto);
		model.addAttribute("productos", productoService.findByCategoria(productoB.getCategoria().getNombre()));
		
		return "/administrador/productos";
	}
}
