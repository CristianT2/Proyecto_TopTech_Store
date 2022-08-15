package com.toptech.store.controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.toptech.store.model.Categoria;
import com.toptech.store.service.ICatagoriaService;

@Controller
@RequestMapping("/administrador")
public class CategoriaController {

	@Autowired
	private ICatagoriaService categoriaService;
	
	@Autowired
	private Categoria categoria;
	
	@GetMapping("/categoria/nueva")
	public String createCategoriaForm(Model model) {
		model.addAttribute("categoria", categoria);
		return "categoria-form";
	}
	
	@PostMapping("/categoria/guardar")
	public ModelAndView guardarCategoria(Model model, @ModelAttribute Categoria categoria, BindingResult result) {
		
		ModelAndView modelView;
		if(result.hasErrors()) {
			modelView = new ModelAndView("categoria-form");
			return modelView;
		}else {
			modelView = new ModelAndView("categoria-form");
			String mensaje= "Objeto guardado en la base de datos correctamente";
			model.addAttribute("mensaje", mensaje);
			model.addAttribute("categoria", categoria);
			categoriaService.saveCategoria(categoria);
			return modelView;
		}
	}
	
	@GetMapping("/categoria/lista")
	public String listarCategoria(Model model) {
		
		List<Categoria> categorias = categoriaService.findAll();
		model.addAttribute("categorias", categorias);
		
		return "categoria-lista";
	}
	
	@GetMapping("/categoria/editar/{id}")
	public String editarCategoria(Model model, @PathVariable Integer id) {
		
		Optional<Categoria> categoria = categoriaService.getCategoria(id);
		model.addAttribute("categoria", categoria);
		
		return "categoria-form";
	}
	
	@GetMapping("/categoria/eliminar/{id}")
	public String eliminarCategoria(@PathVariable Integer id) {
		
		categoriaService.deleteCategoria(id);
		
		return "redirect:/categoria/lista";
	}
	
	@GetMapping("/categoria/buscar/{nombre}")
	public String buscarCategoria(@RequestParam String nombre, Model model) {
	
		model.addAttribute("categorias", categoriaService.findByNombre(nombre));
		
		return "categoria-lista";
	}
	
}
