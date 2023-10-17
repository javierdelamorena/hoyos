package com.cuevasdeayllon.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.cuevasdeayllon.entity.Rutas;
import com.cuevasdeayllon.service.RutasService;

@CrossOrigin(origins = "*")
@Controller
public class RutasController {
	private static final Logger logger = LoggerFactory.getLogger(RutasController.class);

	@Autowired
	private RutasService rutasService;

	@GetMapping("/rutas")
	public String enlaces(HttpSession session, Model model) {

		logger.info("Entramos en metodo rutas: ");

		Rutas ruta = new Rutas();
		model.addAttribute("nombre", "Nombre de la ruta");
		model.addAttribute("texto1", "Texto1");
		model.addAttribute("texto2", "Texto2");
		model.addAttribute("texto3", "Texto3");
		model.addAttribute("texto4", "Texto4");
		model.addAttribute("texto5", "Texto5");

		model.addAttribute("foto1", "Foto1");
		model.addAttribute("foto2", "Foto2");
		model.addAttribute("foto3", "Foto3");
		model.addAttribute("foto4", "Foto4");
		model.addAttribute("foto5", "Foto5");

		model.addAttribute("rutas", ruta);
		return "administrador/rutasAdministrador";

	}

	@PostMapping("/insertarRuta")
	public String insertarEnlace(@ModelAttribute Rutas rutas, Model model, @RequestParam("file1") MultipartFile file1,
			@RequestParam("file2") MultipartFile file2, @RequestParam("file3") MultipartFile file3,
			@RequestParam("file4") MultipartFile file4, @RequestParam("file5") MultipartFile file5) {
		logger.info("Entramos en /insertarRuta con nombre:"+rutas.getNombre());
		if (rutas.getNombre() != null) {
			rutasService.salvarRutas(rutas, file1, file2, file3, file4, file5);

			model.addAttribute("rutaAgregada", " La ruta se ha agregado con exito");
			Rutas ruta = new Rutas();
			model.addAttribute("nombre", "Nombre de la ruta");
			model.addAttribute("texto1", "Texto1");
			model.addAttribute("texto2", "Texto2");
			model.addAttribute("texto3", "Texto3");
			model.addAttribute("texto4", "Texto4");
			model.addAttribute("texto5", "Texto5");

			model.addAttribute("foto1", "Foto1");
			model.addAttribute("foto2", "Foto2");
			model.addAttribute("foto3", "Foto3");
			model.addAttribute("foto4", "Foto4");
			model.addAttribute("foto5", "Foto5");

			model.addAttribute("rutas", ruta);
		} else {
			Rutas ruta = new Rutas();
			model.addAttribute("nombre", "Nombre de la ruta");
			model.addAttribute("texto1", "Texto1");
			model.addAttribute("texto2", "Texto2");
			model.addAttribute("texto3", "Texto3");
			model.addAttribute("texto4", "Texto4");
			model.addAttribute("texto5", "Texto5");

			model.addAttribute("foto1", "Foto1");
			model.addAttribute("foto2", "Foto2");
			model.addAttribute("foto3", "Foto3");
			model.addAttribute("foto4", "Foto4");
			model.addAttribute("foto5", "Foto5");

			model.addAttribute("rutas", ruta);
			model.addAttribute("rutaAgregada", " El nombre no puede faltar");

		}

		return "administrador/rutasAdministrador";
	}
	@PostMapping("/editarRutaAdmin")
	public String editarRutaAdmin(@ModelAttribute Rutas rutas, Model model, @RequestParam("file1") MultipartFile file1,
			@RequestParam("file2") MultipartFile file2, @RequestParam("file3") MultipartFile file3,
			@RequestParam("file4") MultipartFile file4, @RequestParam("file5") MultipartFile file5) {
		logger.info("Entramos en /editarRutaAdmin con nombre:"+rutas.getNombre());
		if (rutas.getNombre() != null) {
			
			
			rutasService.editarRutas(rutas, file1, file2, file3, file4, file5);

			
			Rutas ruta = new Rutas();
			model.addAttribute("nombre", "Nombre de la ruta");
			model.addAttribute("texto1", "Texto1");
			model.addAttribute("texto2", "Texto2");
			model.addAttribute("texto3", "Texto3");
			model.addAttribute("texto4", "Texto4");
			model.addAttribute("texto5", "Texto5");

			model.addAttribute("foto1", "Foto1");
			model.addAttribute("foto2", "Foto2");
			model.addAttribute("foto3", "Foto3");
			model.addAttribute("foto4", "Foto4");
			model.addAttribute("foto5", "Foto5");

			model.addAttribute("rutas", ruta);
			model.addAttribute("rutaAgregada", " La ruta se ha editado con exito");
		} else {
			Rutas ruta = new Rutas();
			model.addAttribute("nombre", "Nombre de la ruta");
			model.addAttribute("texto1", "Texto1");
			model.addAttribute("texto2", "Texto2");
			model.addAttribute("texto3", "Texto3");
			model.addAttribute("texto4", "Texto4");
			model.addAttribute("texto5", "Texto5");

			model.addAttribute("foto1", "Foto1");
			model.addAttribute("foto2", "Foto2");
			model.addAttribute("foto3", "Foto3");
			model.addAttribute("foto4", "Foto4");
			model.addAttribute("foto5", "Foto5");

			model.addAttribute("rutas", ruta);
			model.addAttribute("rutaAgregada", " El nombre no puede faltar");

		}

		return "administrador/editarRuta";
	}
	@GetMapping("/todasRutas")
	public @ResponseBody List<Rutas> todasRutas() {

		logger.info("Entramos en /todasRutas:");
		List<Rutas> rutasList = rutasService.todasLasRutas();

		return rutasList;
	}

	@GetMapping("/listaRutas")
	public String listaRutas(Model model) {

		List<Rutas> rutasList = rutasService.todasLasRutas();
		model.addAttribute("listaRutas", rutasList);
		return "administrador/listaRutas";
	}

	@GetMapping("/unaRuta")
	public @ResponseBody Rutas unaRuta(@RequestParam("idRuta") int idRuta) {
		logger.info("Entramos en /unaRuta:");
		Rutas unaRuta = null;
		try {
			unaRuta = rutasService.unRutas(idRuta);
		} catch (NullPointerException e) {
			logger.info(e.getMessage());

		}
		return unaRuta;
	}

	@PostMapping("/borrarRuta")
	public String borrarRuta(@RequestParam("idRuta") int idRuta, Model model) {
		Rutas unaRuta = null;
		try {
			if (idRuta > 0) {
				unaRuta = rutasService.unRutas(idRuta);
			}
			if (unaRuta != null) {
				logger.info("Entramos en /borrarRuta con este  idRuta:", idRuta);
				rutasService.borrarRutas(idRuta);
				List<Rutas> rutasList = rutasService.todasLasRutas();
				model.addAttribute("listaRutas", rutasList);
			} else {
				List<Rutas> rutasList = rutasService.todasLasRutas();
				model.addAttribute("listaRutas", rutasList);

			}
		} catch (NullPointerException e) {
			logger.info(e.getMessage());
			List<Rutas> rutasList = rutasService.todasLasRutas();
			model.addAttribute("listaRutas", rutasList);

		}
		return "administrador/listaRutas";
	}
	@PostMapping("/editaRuta")
	public String editaRuta(@RequestParam("idRuta") int idRuta, Model model) {
		Rutas unaRuta = null;
		try {
			if (idRuta > 0) {
				unaRuta = rutasService.unRutas(idRuta);
			}
			if (unaRuta != null) {
				logger.info("Entramos en /editaRuta con este  idRuta:", idRuta);
				
				model.addAttribute("nombre", "Nombre de la ruta");
				model.addAttribute("texto1", "Texto1");
				model.addAttribute("texto2", "Texto2");
				model.addAttribute("texto3", "Texto3");
				model.addAttribute("texto4", "Texto4");
				model.addAttribute("texto5", "Texto5");

				model.addAttribute("foto1", "Foto1");
				model.addAttribute("foto2", "Foto2");
				model.addAttribute("foto3", "Foto3");
				model.addAttribute("foto4", "Foto4");
				model.addAttribute("foto5", "Foto5");
				
				model.addAttribute("rutas", unaRuta);
				return "administrador/editarRuta";
			} else {
				List<Rutas> rutasList = rutasService.todasLasRutas();
				model.addAttribute("listaRutas", rutasList);
				return "administrador/listaRutas";

			}
		} catch (NullPointerException e) {
			logger.info(e.getMessage());
			List<Rutas> rutasList = rutasService.todasLasRutas();
			model.addAttribute("listaRutas", rutasList);

		}
		return "administrador/listaRutas";
	}
}