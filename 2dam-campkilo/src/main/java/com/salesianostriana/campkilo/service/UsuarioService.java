package com.salesianostriana.campkilo.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.salesianostriana.campkilo.model.Usuario;
import com.salesianostriana.campkilo.repository.UsuarioRepository;

@Service("userDetailsService")
public class UsuarioService implements UserDetailsService {

	@Autowired
	public UsuarioRepository uRepository;

	public Usuario loadUserByUsername(String username) throws UsernameNotFoundException {
		// Buscamos el usuario por su nombe de usuario
		Usuario user = uRepository.findUserWithAuthorities(username);

		if (user == null) {
			// En caso de no localizarlo, lanzamos una excepción
			throw new UsernameNotFoundException("Usuario no encontrado");

		}

		// Devolvemos la instancia de UserDetails.
		return user;

	}

	public Usuario save(Usuario user) {
		return uRepository.save(user);
	}

}
