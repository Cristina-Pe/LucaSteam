package com.projecto.spring.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.projecto.spring.model.Juego;

public interface DAOJuegos extends JpaRepository<Juego, Integer> {
	
	@Query
	/**
	* Método que devuelve lista de juegos recibiendo un string de plataforma
	*/
	List<Juego> findByPlatform(String platform);
	/**
	* Método que devuelve lista de juegos recibiendo un string de genero
	*/
	List<Juego> findByGenre(String genre);
	

}
