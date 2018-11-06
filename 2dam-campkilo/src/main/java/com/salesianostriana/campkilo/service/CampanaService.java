package com.salesianostriana.campkilo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.campkilo.model.Campana;
import com.salesianostriana.campkilo.repository.CampanaRepository;

@Service
public class CampanaService {

	@Autowired
	private CampanaRepository campanaRepository;

	public Campana save(Campana c) {

		return campanaRepository.save(c);

	}
	
	public List<Campana> findAll(){
		return campanaRepository.todos();
	}

}
