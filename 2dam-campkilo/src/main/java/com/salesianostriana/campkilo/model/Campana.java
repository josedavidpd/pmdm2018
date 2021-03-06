package com.salesianostriana.campkilo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class Campana {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "campana_seq")
 	@SequenceGenerator(name = "campana_seq", sequenceName = "seq_campana", allocationSize = 1)
	private Long id;

	private String nombre;
	private boolean unido;
	@ManyToMany
	private List<Usuario> usuarios;
	@OneToMany(mappedBy = "campania", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private List<DatosMaestros> categorias = new ArrayList<>();
	@OneToMany(mappedBy = "campania", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private List<Aportacion> aportaciones= new ArrayList<>();

	public Campana() {
	}
	
	public Campana(String nombre, boolean unido, List<Usuario> usuarios) {
		super();
		this.nombre = nombre;
		this.unido = unido;
		this.usuarios = usuarios;
	}

	public Campana(String nombre, boolean unido, List<Usuario> usuarios, List<DatosMaestros> categorias,
			List<Aportacion> aportaciones) {
		super();
		this.nombre = nombre;
		this.unido = unido;
		this.usuarios = usuarios;
		this.categorias = categorias;
		this.aportaciones = aportaciones;
	}

	public void addAportacion(Aportacion a) {
		if (a != null) {
			a.setCampania(this);
			this.getAportaciones().add(a);
		}
	}

	public void removeAportacion(Aportacion a) {
		if (a != null) {
			a.setCampania(null);
			this.getAportaciones().remove(a);
		}
	}

	public void addCategorias(DatosMaestros d) {
		if (d != null) {
			d.setCampania(this);
			this.getCategorias().add(d);
		}
	}

	public void removeCategoria(DatosMaestros d) {
		if (d != null) {
			d.setCampania(null);
			this.getCategorias().remove(d);
		}
	}

}
