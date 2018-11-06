package com.salesianostriana.campkilo.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import com.salesianostriana.campkilo.model.Usuario;
import com.salesianostriana.campkilo.service.UsuarioService;

@Controller
public class RegistroController {

	@Autowired
	public UsuarioService uService;
	
	@PostMapping("auth/register")
	public String UserRegistrated(@ModelAttribute("user") Usuario user) {
		uService.save(user);
		return ""; //Mirar bien return
	}

}
