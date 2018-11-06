package com.salesianostriana.campkilo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.campkilo.model.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long>{
	
}
