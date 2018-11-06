package com.salesianostriana.campkilo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.campkilo.model.Authority;
import com.salesianostriana.campkilo.repository.AuthorityRepository;

@Service
public class AuthorityService {
	@Autowired
	private AuthorityRepository aRepository;
	
	public Authority save(Authority a) {
		return aRepository.save(a);
	}
	
}
