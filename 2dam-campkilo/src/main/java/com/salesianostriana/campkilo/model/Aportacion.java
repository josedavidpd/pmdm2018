package com.salesianostriana.campkilo.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class Aportacion {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aportacion_seq")
 	@SequenceGenerator(name = "aportacion_seq", sequenceName = "seq_aportacion", allocationSize = 1)
	private Long id;

	private int cantidad;
	private LocalDateTime fechaRealizada;
	@ManyToOne
	private DatosMaestros categoria;
	@ManyToOne
	private Campana campania;
	@ManyToOne
	private Usuario usuario;

	public Aportacion() {
	}

	public Aportacion(DatosMaestros categoria, int cantidad, LocalDateTime fechaRealizada, Campana campania,
			Usuario usuario) {
		super();
		this.categoria = categoria;
		this.cantidad = cantidad;
		this.fechaRealizada = fechaRealizada;
		this.campania = campania;
		this.usuario = usuario;
	}

}
