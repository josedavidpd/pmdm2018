package com.salesianostriana.campkilo.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.salesianostriana.campkilo.model.Aportacion;
import com.salesianostriana.campkilo.model.Campana;

public class JwtUser implements UserDetails {

	private final Long id;

	private final String email;
	private final String name;
	private final String password;
	private final String nomGrupo;
	private final Collection<? extends GrantedAuthority> authorities;
	private final boolean enabled;
	private List<Campana> campanias;
	private List<Aportacion> aportaciones;

	public JwtUser(Long id, String email, String username, String password, String nomGrupo,
			Collection<? extends GrantedAuthority> authorities, boolean enabled, List<Campana> campanias,
			List<Aportacion> aportaciones) {
		this.id = id;
		this.name = username;
		this.email = email;
		this.password = password;
		this.nomGrupo = nomGrupo;
		this.authorities = authorities;
		this.enabled = enabled;
	}

	@JsonIgnore
	public Long getId() {
		return id;
	}

	@Override
	public String getUsername() {
		return name;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	public List<Campana> getCampanias() {
		return campanias;
	}

	public void setCampanias(List<Campana> campanias) {
		this.campanias = campanias;
	}

	public List<Aportacion> getAportaciones() {
		return aportaciones;
	}

	public void setAportaciones(List<Aportacion> aportaciones) {
		this.aportaciones = aportaciones;
	}

	public String getNomGrupo() {
		return nomGrupo;
	}

	public String getEmail() {
		return email;
	}

	@JsonIgnore
	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

}
