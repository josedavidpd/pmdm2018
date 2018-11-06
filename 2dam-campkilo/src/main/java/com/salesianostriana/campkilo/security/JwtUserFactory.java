package com.salesianostriana.campkilo.security;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.salesianostriana.campkilo.model.Authority;
import com.salesianostriana.campkilo.model.Usuario;

public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(Usuario user) {
        return new JwtUser(
                user.getId(),
                user.getEmail(),
                user.getName(),    
                user.getPassword(),
                user.getNomGrupo(),
                mapToGrantedAuthorities(user.getAuthorities()),
                user.isEnabled(),
                user.getCampanias(),
                user.getAportaciones()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Authority> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getAuthority()))
                .collect(Collectors.toList());
    }
}
