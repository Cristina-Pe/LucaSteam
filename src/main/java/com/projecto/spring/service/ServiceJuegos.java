package com.projecto.spring.service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.projecto.spring.model.Juego;
import com.projecto.spring.model.Ventas;

public interface ServiceJuegos {

	/**
	 * Metodo para añadir y editar
	 */
	public void save(Juego juego);

	/**
	 * Metodo para recuperar usuario
	 */
	public Optional<Juego> findById(int id);

	/**
	 * Metodo para listar todos los juegos
	 */
	public List<Juego> findAll();

	
	/**
	 * Metodo para listar por juegos Nintendo
	 */
	public List<Juego> listaJuegosNintendo();

	/**
	 * Metodo para listar por plataforma
	 */
	public List<Juego> findByPlatform(String platform);
	
	public List<Juego> findYearPair();
	
	public List<Juego> findYearXX();

	/**
	 * Metodo para listar por género
	 */
	public List<Juego> findByGenre(String genre);

	


	/**
	 * PAGINACION WEB

	 */
	Page<Juego> getAll(Pageable pageable);

	/**
	 * @author Paula
	 * @param Juego - juego Sirve para eliminación de un juego en la bbdd
	 */
	public void deleteJuego(Juego juego);
	
	public void deleteById(int id);

	
	public List<String> listaEditores();
	public List<Ventas> listaVentas();


	/**
	 * Sirve para listar por genero y plataforma
	 */
	public List<Juego> findByGenrePlatform();

}
