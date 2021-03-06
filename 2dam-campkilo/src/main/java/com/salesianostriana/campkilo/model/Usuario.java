package com.salesianostriana.campkilo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Usuario implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_seq")
 	@SequenceGenerator(name = "usuario_seq", sequenceName = "seq_usuario", allocationSize = 1)
	private Long id;

	@Column(unique = true)
	private String email;
	private String name;
	private String password;
	@Column(unique = true)
	private String nomGrupo;
	private boolean enabled;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Authority> authorities;
	@ManyToMany
	private List<Campana> campanias;
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private List<Aportacion> aportaciones;

	public Usuario(String email, String name, String password, String nomGrupo, boolean enabled, List<Authority> authorities) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.nomGrupo = nomGrupo;
		this.enabled = enabled;
		this.authorities = authorities;
	}
	
	public Usuario(String email, String name, String password, String nomGrupo, boolean enabled) {
		this.email = email;
		this.name = name;
		this.password = password;
		this.nomGrupo = nomGrupo;
		this.enabled = enabled;
	}

	public Usuario(Long id, String email, String name, String password, String nomGrupo, boolean enabled,
			List<Authority> authorities, List<Campana> campanias, List<Aportacion> aportaciones) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.password = password;
		this.nomGrupo = nomGrupo;
		this.enabled = enabled;
		this.authorities = authorities;
		this.campanias = campanias;
		this.aportaciones = aportaciones;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	public void addAportacion(Aportacion a) {
		if (a != null) {
			a.setUsuario(this);
			this.getAportaciones().add(a);
		}
	}

	public void removeAportacion(Aportacion a) {
		if (a != null) {
			a.setUsuario(null);
			this.getAportaciones().remove(a);
		}
	}

	public void addCampania(Campana c) {
		if (c != null) {
			c.getUsuarios().add(this);
			this.getCampanias().add(c);
		}
	}

	public void removeCampania(Campana c) {
		if (c != null) {
			c.getUsuarios().remove(this);
			this.getCampanias().remove(c);
		}
	}

	public void removeAuthority(Authority a) {
		if (a != null) {
			a.setUser(null);
			this.getAuthorities().remove(a);
		}
	}

}
