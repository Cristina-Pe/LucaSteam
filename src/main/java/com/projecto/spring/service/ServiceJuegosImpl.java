package com.projecto.spring.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.projecto.spring.model.ConsolasNintendo;
import com.projecto.spring.model.Juego;
import com.projecto.spring.model.Ventas;
import com.projecto.spring.repository.DAOJuegos;

@Service
public class ServiceJuegosImpl implements ServiceJuegos {

	@Autowired
	DAOJuegos JuegoDao;

	/**
	 * @author Cristina
	 * @param Juego - juego Método que añade o edita un juego de la lista.
	 */

	@Override
	// Para listar todos los juegos
	public List<Juego> findAll() {
		return JuegoDao.findAll();
	}

	/**
	 * @author 
	 * Método que recibe como parametro un juego y se lo manda al metodo save del dao
	 */
	@Override
	public void save(Juego juego) {
		JuegoDao.save(juego);
	}
	
	/**
	 * @author 
	 * Método que recibe como parametro un id juego y se lo manda al metodo find by id del dao
	 */
	@Override
	public Optional<Juego> findById(int id) {
		return JuegoDao.findById(id);
	}

	/**
	 * @author Jose Antonio Método que recupera una lista de juegos de las consolas
	 *         de nintendo
	 */
	@Override
	public List<Juego> listaJuegosNintendo() {
		List<Juego> nintendo = new ArrayList<Juego>();
		ConsolasNintendo[] consolas = ConsolasNintendo.values();

		for (int i = 0; i < consolas.length; i++) {
			nintendo.addAll(findByPlatform(consolas[i].getConsolas()));
		}

		return nintendo;
	}

	@Override
	/**
	 *Metodo que recibe como parametro un string del nombre de la plataforma y se lo manda al metodo find by platform del dao
	 */
	public List<Juego> findByPlatform(String platform) {

		return JuegoDao.findByPlatform(platform);
	}
	
	/**
	 *Metodo que recibe como parametro un string de genre y  se lo manda al metodo find by genre del dao
	 */
	public List<Juego> findByGenre(String genre) {

		return JuegoDao.findByGenre(genre);
	}

	/**
	 * @author Sebastian Método que recupera una lista de juegos de los por años
	 *         pares
	 */
	@Override
	public List<Juego> findYearPair() {

		List<Juego> pairs = new ArrayList<Juego>();
		List<Juego> Allgames = findAll();
		for (int i = 0; i < Allgames.size(); i++) {
			if (!Allgames.get(i).getYear().startsWith("N")) {
				if ((Integer.valueOf(Allgames.get(i).getYear()) % 2) == 0)
					pairs.add(Allgames.get(i));
			}
		}

		return pairs;
	}

	/**
	 * @author Sebastian Método que recupera una lista de juegos que salieron en el
	 *         siglo XX
	 */
	@Override
	public List<Juego> findYearXX() {

		List<Juego> XXgames = new ArrayList<Juego>();
		List<Juego> Allgames = findAll();
		for (int i = 0; i < Allgames.size(); i++) {
			if (!Allgames.get(i).getYear().startsWith("N")) {
				if (Integer.valueOf(Allgames.get(i).getYear()) <= 1999){
					XXgames.add(Allgames.get(i));
				}
					
			}
		}

		return XXgames;
	}

	/**
	 * @author Sebastian Método que recupera una lista de juegos que salieron en el
	 *         siglo XX
	 */
	@Override
	public List<String> listaEditores() {

		Set<String> Editores = new HashSet<String>();
		List<Juego> Allgames = findAll();
		for (int i = 0; i < Allgames.size(); i++) {

				Editores.add(Allgames.get(i).getPublisher());
		}

		List<String> listaeditores = new ArrayList<String>(Editores);
		return listaeditores;

	}
	/**
	 * @author Sebastian Método que recupera una lista de juegos que salieron en el
	 *         siglo XX
	 */
	@Override
	public List<Ventas> listaVentas() {
		
		List<Ventas> ListaVentas = new ArrayList<Ventas>();
		List<Juego> Allgames = findAll();
		for (int i = 0; i < Allgames.size(); i++) {

			Ventas Venta = new Ventas();
			Venta.setName(Allgames.get(i).getName());
			Venta.setSales_NA(Allgames.get(i).getSales_NA());
			Venta.setSales_EU(Allgames.get(i).getSales_EU());
			Venta.setSales_JP(Allgames.get(i).getSales_JP());
			Venta.setSales_Other(Allgames.get(i).getSales_Other());
			Venta.setSales_Global(Allgames.get(i).getSales_Global());
			ListaVentas.add(Venta);

		}
		return ListaVentas;

	}

	
	/**
	 * @author Fco Rueda
	 * Paginación del listado completo de juegos
	 */
	@Override
	public Page<Juego> getAll(Pageable pageable) {
		return JuegoDao.findAll(pageable);
	}

	@Override
	/**
	 * @author Paula
	 * Método eliminación juego
	 */
	public void deleteJuego(Juego juego) {
		JuegoDao.delete(juego);

	}
	/**
	 * @author Paula
	 * Metodo que recibe como parametro un string de genre y  se lo manda al metodo find by genre del dao
	 */
	public List<Juego> findByGenrePlatform() {
		String genre = "Platform";
		return JuegoDao.findByGenre(genre);
	}

	@Override
	public void deleteById(int id) {
		JuegoDao.deleteById(id);
		
	}

}
