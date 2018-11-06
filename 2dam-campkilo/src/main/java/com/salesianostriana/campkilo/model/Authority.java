package com.salesianostriana.campkilo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Authority implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authorities_seq")
 	@SequenceGenerator(name = "authorities_seq", sequenceName = "seq_authorities", allocationSize = 1)
	private Long id;

	private String authority;

	@ManyToOne
	@JoinColumn(name = "username")
	private Usuario user;

	public Authority(String authority, Usuario user) {
		super();
		this.authority = authority;
		this.user = user;
	}

	@Override
	public String getAuthority() {

		return this.authority;
	}

}
