package com.salesianostriana.campkilo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class DatosMaestros {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "datosmaestros_seq")
 	@SequenceGenerator(name = "datosmaestros_seq", sequenceName = "seq_datosmaestros", allocationSize = 1)
	private Long id;

	private String nombre;
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private List<Aportacion> aportaciones;
	@ManyToOne
	private Campana campania;

	public DatosMaestros() {
	}

	public DatosMaestros(String nombre, List<Aportacion> aportaciones, Campana campania) {
		super();
		this.nombre = nombre;
		this.aportaciones = aportaciones;
		this.campania = campania;
	}

	public void addAportacion(Aportacion a) {
		if (a != null) {
			a.setCategoria(this);
			this.getAportaciones().add(a);
		}
	}

	public void removeAportacion(Aportacion a) {
		if (a != null) {
			a.setCategoria(null);
			this.getAportaciones().remove(a);
		}
	}

}
