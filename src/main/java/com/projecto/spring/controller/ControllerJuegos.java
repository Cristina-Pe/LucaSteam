package com.projecto.spring.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.projecto.spring.model.Juego;
import com.projecto.spring.service.ServiceJuegos;

@Controller
public class ControllerJuegos {

	@Autowired
	ServiceJuegos service;

	/**
	 * Metodo controlador para editar un juego segun el id recibido
	 */
	@GetMapping("/edit")
	public String editJuego(@RequestParam("id") int id, Model m) {
		m.addAttribute("game", service.findById(id));
		return ("layout/altaJuego");
	}

	/**
	 * Metodo controlador para el alta de un nuevo juego
	 */
	@GetMapping("/new")
	public String newJuego(Juego juego, Model m) {
		m.addAttribute("game",juego);
		return ("layout/altaJuego");

	}

	/**
	 * Metodo controlador para guardar un juego recibido por parametro
	 */
	@PostMapping("/save")
	public String saveJuego(Juego juego) {
		service.save(juego);
		return ("redirect:/");
	}

	/**
	 * Metodo controlador para el listado de todos los juegos Nintendo
	 */
	@GetMapping("/NintendoGames")
	public String listaJuegosNintendo(Model m) {
		m.addAttribute("allGames", service.listaJuegosNintendo());
		return ("layout/listadoJuegos");
	}
	
	@GetMapping("/JuegosPares")
	public String listaJuegosPares(Model m) {
		m.addAttribute("allGames", service.findYearPair());
		return ("layout/listadoJuegos");
	}
	
	@GetMapping("/JuegosXX")
	public String listaJuegosXX(Model m) {
		m.addAttribute("allGames", service.findYearXX());
		return ("layout/listadoJuegos");
	}
	@GetMapping("/Editores")
	public String listaEditores(Model m) {
		m.addAttribute("Editores", service.listaEditores());
		m.addAttribute("allGames", service.listaJuegosNintendo());
		return ("layout/listadoEditores");
	}
	@GetMapping("/Ventas")
	public String listaVentas(Model m) {
		m.addAttribute("ListaVentas", service.listaVentas());
		return ("layout/listadoVentas");
	}
	
	@GetMapping("/Genre")
	public String listaGeneros(@RequestParam("genre") String genre, Model m) {
		m.addAttribute("allGames", service.findByGenre(genre));
		return ("layout/listadoJuegos");
	}
	
	
	
	@GetMapping("/")
	public String findAll(@RequestParam Map<String, Object> params, Model model) {
		int page = params.get("page") != null ? Integer.valueOf(params.get("page").toString()) - 1 : 0;
		PageRequest pageRequest = PageRequest.of(page, 150);
		Page<Juego> pageJuego = service.getAll(pageRequest);
		int totalPage = pageJuego.getTotalPages();
		
		if (totalPage > 0) {
			List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
			model.addAttribute("pages", pages);
			
		}
		
		model.addAttribute("allGames", pageJuego.getContent());
		model.addAttribute("firts", 1);
		model.addAttribute("current", page + 1);
		model.addAttribute("next", page + 2);
		model.addAttribute("prev", page);
		model.addAttribute("last", totalPage);
		
		return "layout/listadoJuegos";
	}


	/**
	 * Metodo controlador para eliminar de la bbdd un juego recibido por parametro
	 */
	@GetMapping("/delete")
	public String deleteJuego(@RequestParam("id") int id) {
		service.deleteById(id);
		return ("redirect:/");
	}

	/**
	 * Metodo controlador para buscar un juego a traves del genero
	 */
	@GetMapping("/GenrePlatform")
	public String findByGenrePlatform(Model m) {
		m.addAttribute("allGames", service.findByGenrePlatform());
		return ("layout/listadoJuegos");
	}


}
