package com.salesianostriana.campkilo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.salesianostriana.campkilo.model.Campana;

@Repository
public interface CampanaRepository extends JpaRepository<Campana, Long>{
	@Query("select c from Campana c")
	public List<Campana>todos();

}
