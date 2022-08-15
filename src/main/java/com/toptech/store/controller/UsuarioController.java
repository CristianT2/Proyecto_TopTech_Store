package com.toptech.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.toptech.store.model.Usuario;
import com.toptech.store.service.IProductoService;
import com.toptech.store.service.IUsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private IProductoService productoService;
	
	@Autowired
	private Usuario usuario; 
	
	@GetMapping("/home")
	public String homePage(Model model) {
		model.addAttribute("productos", productoService.findAll());
		return "usuario/home";
	}

	@GetMapping("/registro")
	public String createUsuario(Model model) {
		
		model.addAttribute("usuario", usuario);
		return "usuario/registro";
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarUsuario(Model model, @ModelAttribute Usuario usuario, BindingResult result) {
		
		ModelAndView modelView;
		if(result.hasErrors()) {
			modelView = new ModelAndView("usuario/registro");
			return modelView;
		}else {
			modelView = new ModelAndView("usuario/registro");
			String mensaje="Objeto guardado en la base de datos correctamente, ";
			model.addAttribute("mensaje", mensaje);
			usuarioService.saveUsuario(usuario);
			return modelView;
		}
	}
}
