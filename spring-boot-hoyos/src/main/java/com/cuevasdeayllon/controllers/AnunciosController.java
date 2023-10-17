package com.cuevasdeayllon.controllers;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cuevasdeayllon.entity.Anuncios;
import com.cuevasdeayllon.repository.DocumentosRepositoryImpl;
import com.cuevasdeayllon.service.AnunciosService;

@CrossOrigin(origins = "*")
@Controller
public class AnunciosController {

	private static final Logger logger = LoggerFactory.getLogger(AnunciosController.class);

	@Autowired
	private AnunciosService anuncioService;

	@Autowired
	private DocumentosRepositoryImpl documentosRepositoryImpl;

	@GetMapping("/todosAnuncios")
	public String listaDeAnuncios(Model model) {

		logger.info("Entramos en metodo /todosAnuncios");

		try {
			List<Anuncios> anuncios = anuncioService.listAnuncio();

			anuncios = anuncios.stream().sorted(Comparator.comparing(Anuncios::getIdAnuncios).reversed())
					.collect(Collectors.toList());

			model.addAttribute("listaAnuncios", anuncios);

			return "portadas/tablonanuncios";

		} catch (Exception e) {

			logger.info("El error que da en /todosAnuncios es: " + e.getMessage());

		}
		return "portadas/tablonanuncios";

	}

	@GetMapping("/anuncio")
	public @ResponseBody Anuncios unanuncio(@RequestParam("idAnuncio") int idAnuncio) {

		Anuncios anuncios = anuncioService.recuperarAnuncio(idAnuncio);
		return anuncios;

	}

	@PostMapping("/subirAnuncio")
	public String insertarAnuncio(@RequestParam("titulo") String titulo, @RequestParam("anuncio") String anuncio,
			@RequestParam("file") MultipartFile file, Model model) {

		// String rootPath="/uploadsAnuncios/";

		logger.info("Entramos en metodo /subirAnuncio");

		int oraLen = file.getOriginalFilename().length();
		logger.info("El nombre de la foto es: " + file.getOriginalFilename());

		for (int i = 0; i < oraLen; i++) {
			if (file.getOriginalFilename().charAt(i) == ' ') {
				model.addAttribute("fotoConEspacio", "El nombre de la foto no puede tener espacios en blanco.");
				return "administrador/subirAnuncio";

			}
		}

		try {
			if (titulo.isEmpty()) {

				model.addAttribute("faltaTitulo",
						"El titulo en los anuncios es necesario, lo unico que se puede omitir es la foto.");
				return "administrador/subirAnuncio";
			}

			else if (anuncio.isEmpty()) {

				model.addAttribute("faltaAnuncio",
						"El texto en los anuncios es necesario, lo unico que se puede omitir es la foto.");
				return "administrador/subirAnuncio";
			} else {

				anuncioService.insertarAnucio(anuncio, titulo, file);

				model.addAttribute("anuncioSubido", "El anuncio se ha agregado con exito.");

				return "administrador/subirAnuncio";
			}
		} catch (Exception e) {

			model.addAttribute("anuncioSubido", "El anuncio no se ha agregado.");

			logger.info("El error que da en /subirAnuncio es: " + e.getMessage());
		}
		return "administrador/subirAnuncio";

	}

	@PostMapping("/editarAnuncio")
	public String editarAnuncio(@RequestParam("idAnuncio") int idAnuncio, @RequestParam("titulo") String titulo,
			@RequestParam("fecha") String fecha, @RequestParam("anuncio") String anuncio,
			@RequestParam("file") MultipartFile file, Model model) {

		logger.info("Entramos en metodo /subirAnuncio");
		Anuncios anuncioeditable = anuncioService.recuperarAnuncio(idAnuncio);
		int oraLen = file.getOriginalFilename().length();
		logger.info("El nombre de la foto es: " + file.getOriginalFilename());

		for (int i = 0; i < oraLen; i++) {
			if (file.getOriginalFilename().charAt(i) == ' ') {
				model.addAttribute("faltaTitulo", "El nombre de la foto no puede tener espacios en blanco.");
				List<Anuncios> anuncios = anuncioService.listAnuncio();

				model.addAttribute("listaAnuncios", anuncios);
				return "administrador/listaAnuncios";

			}
		}
		try {
			if (titulo.isEmpty()) {

				model.addAttribute("faltaTitulo",
						"El titulo en los anuncios es necesario, lo unico que se puede omitir es la foto.");
				List<Anuncios> anuncios = anuncioService.listAnuncio();

				model.addAttribute("listaAnuncios", anuncios);
				return "administrador/listaAnuncios";
			}

			else if (anuncio.isEmpty()) {
				List<Anuncios> anuncios = anuncioService.listAnuncio();

				model.addAttribute("listaAnuncios", anuncios);

				model.addAttribute("faltaAnuncio",
						"El texto en los anuncios es necesario, lo unico que se puede omitir es la foto.");
				return "administrador/listaAnuncios";
			} else {

				anuncioService.editarAnuncio(anuncioeditable, anuncio, titulo, fecha, file);

				List<Anuncios> anuncios = anuncioService.listAnuncio();

				model.addAttribute("listaAnuncios", anuncios);

				model.addAttribute("anuncioSubido", "El anuncio se ha editado con exito.");

				return "administrador/listaAnuncios";
			}
		} catch (Exception e) {

			model.addAttribute("anuncioSubido", "El anuncio no se ha agregado.");

			logger.info("El error que da en /subirAnuncio es: " + e.getMessage());
		}
		List<Anuncios> anuncios = anuncioService.listAnuncio();

		model.addAttribute("listaAnuncios", anuncios);
		return "administrador/listaAnuncios";

	}

	@GetMapping("/listaAnunciosAdmin")
	public String listaDeAnunciosAdministrador(Model model) {

		logger.info("Entramos en metodo /listaAnunciosAdmin");
		try {
			List<Anuncios> anuncios = anuncioService.listAnuncio();

			model.addAttribute("listaAnuncios", anuncios);

			return "administrador/listaAnuncios";
		} catch (Exception e) {
			logger.info("El error que da en /listaAnunciosAdmin es: " + e.getMessage());
		}
		return "administrador/listaAnuncios";

	}

	@PostMapping("/borrarAnuncio")
	public String borrarAnuncio(@RequestParam("idAnuncio") int idAnuncio, Model model) {
		
		try {
			Anuncios anuncios = anuncioService.recuperarAnuncio(idAnuncio);

			if (idAnuncio > 0 && anuncios != null) {
				anuncioService.deleteAnuncio(idAnuncio);
			} else {
				return "administrador/listaAnuncios";
			}

		} catch (Exception e) {

			logger.info("El error que da en /borrarAnuncio es: " + e.getMessage());

		}

		List<Anuncios> anuncios;
		try {
			anuncios = anuncioService.listAnuncio();
			model.addAttribute("listaAnuncios", anuncios);
		} catch (Exception e) {

			logger.info("El error que da en /borrarAnuncio recuperar todos es: " + e.getMessage());

		}

		return "administrador/listaAnuncios";

	}

//	@PostMapping("/subirDocumento")
//	public String insertarDocumento(@RequestParam("titulo") String titulo, @RequestParam("file") MultipartFile foto,
//			Model model) throws IOException {
//
//		logger.info("Entramos en metodo /Documento");
//
//		logger.info("El nombre de la foto es: " + foto.getOriginalFilename());
//
//		documentosRepositoryImpl.insertarDocumentos(titulo, foto);
//
//		model.addAttribute("anuncioSubido", "El anuncio se ha agregado con exito.");
//
//		return "fileUpload";
//
//	}
//
//	@GetMapping("/todosDocumentos")
//	public String todosDocumento(Model model) throws IOException {
//
//		logger.info("Entramos en metodo /Documento");
//
//		List<Documentos> documento = new ArrayList<>();
//
//		documento = documentosRepositoryImpl.listDocumentos();
//		documento = documento.stream().sorted(Comparator.comparing(Documentos::getId).reversed())
//				.collect(Collectors.toList());
//
//		model.addAttribute("listaDocumentos", documento);
//
//		return "documentos";
//
//	}

}
