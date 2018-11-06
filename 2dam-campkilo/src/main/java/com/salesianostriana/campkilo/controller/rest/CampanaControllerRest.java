package com.salesianostriana.campkilo.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salesianostriana.campkilo.model.Campana;
import com.salesianostriana.campkilo.service.CampanaService;

@RestController
public class CampanaControllerRest {
	
	@Autowired
	private CampanaService campanaService;
	
	@GetMapping("/campanas")
	public List<Campana> all(){
		return campanaService.findAll();
		
		}

}
