package br.com.felipe.docket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.felipe.docket.model.Cartorio;

public interface CartorioRepository extends JpaRepository<Cartorio, Long>{
	
}
