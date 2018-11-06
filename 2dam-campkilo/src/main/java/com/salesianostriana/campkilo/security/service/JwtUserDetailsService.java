package com.salesianostriana.campkilo.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.salesianostriana.campkilo.model.Usuario;
import com.salesianostriana.campkilo.repository.UsuarioRepository;
import com.salesianostriana.campkilo.security.JwtUserFactory;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository uRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario user = uRepository.findByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No encontrado usuario con nombre '%s'.", user.getName()));
        } else {
            return JwtUserFactory.create(user);
        }
    }
}
