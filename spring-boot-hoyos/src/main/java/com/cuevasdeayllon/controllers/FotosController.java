package com.cuevasdeayllon.controllers;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cuevasdeayllon.compresor.ImageResizer;
import com.cuevasdeayllon.entity.Fotos;
import com.cuevasdeayllon.entity.Usuario;
import com.cuevasdeayllon.paginator.PageRender;
import com.cuevasdeayllon.service.FotosService;
import com.cuevasdeayllon.service.UsuarioService;

@CrossOrigin(origins = "*")
@Controller

public class FotosController {

	private static final Logger logger = LoggerFactory.getLogger(FotosController.class);
	//static final String ROOT_PATH = "D://TEMP//uploadsGaleria";
	static final String ROOT_PATH = "/uploadsGaleria";

	@Autowired
	FotosService service;
	@Autowired
	UsuarioService usuarioservice;

//	@GetMapping( value = ("/fotosGaleria"), produces = MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody List<Fotos> todasFotos(Model model,HttpSession sesion) {
//
//		List<Fotos>fotos=service.todasLasFotos();
//
//		fotos.forEach(f->logger.info("Esta es la lista de fotos: "+f.getFotos()+" y el usuario"+ f.getId_usuario()));
//
//		return fotos;
//
//	}

	@GetMapping(path = "/fotosGaleriaLista")
	public String todasFotosLista(Model model, HttpSession sesion) {

		List<Fotos> fotos = service.todasLasFotos();

		if (fotos != null) {

			fotos.forEach(f -> logger
					.info("Esta es la lista de fotos: " + f.getFotos() + " y el usuario" + f.getUsuario().getNombre()));
			model.addAttribute("fotosLista", fotos);
		} else {
			return "administrador/listaFotos";
		}
		return "administrador/listaFotos";

	}

	@GetMapping(path = "/fotosMiLista")
	public String fotosMiLista(@RequestParam("idUsuario") int id_usuario, Model model, HttpSession sesion) {

		List<Fotos> fotos = service.todasByIdUsuario(id_usuario);

		if (fotos != null) {

			fotos.forEach(f -> logger
					.info("Esta es la lista de fotos: " + f.getFotos() + " y el usuario" + f.getUsuario().getNombre()));
			model.addAttribute("fotosLista", fotos);
		} else {
			return "usuarios/misFotos";
		}
		return "usuarios/misFotos";

	}

	@PostMapping(path = "/salvarFoto")
	public String registrarUsuario(@RequestParam("idUsuario") int id_usuario, @RequestParam("file") MultipartFile foto,
			Model model, HttpSession sesion) {
		logger.info("Entramos en metodo salvarFoto");
		logger.info("El usuario que recogemos es: " + id_usuario + " con la foto  " + foto);
		Usuario usuario = usuarioservice.usuarioPorId(id_usuario);
		Fotos fotos = new Fotos();

		

		if (!foto.isEmpty() && id_usuario > 0) {
			int oraLen = foto.getOriginalFilename().length();
			logger.info("El nombre de la foto es: " + foto.getOriginalFilename());

			for (int i = 0; i < oraLen; i++) {
				if (foto.getOriginalFilename().charAt(i) == ' ') {
					model.addAttribute("fotoSubida", "El nombre de la foto no puede tener espacios en blanco.");
					return "usuarios/subirFoto";
				}
			}

			try {
				byte[] bytes = foto.getBytes();
				Path rutaCompleta = Paths.get(ROOT_PATH + "//" + foto.getOriginalFilename());

				Files.write(rutaCompleta, bytes);
				BufferedImage bufferedImage = ImageResizer.loadImage(ROOT_PATH +"/"+ foto.getOriginalFilename());
				BufferedImage bufferedImageResize = ImageResizer.resize(bufferedImage, 400, 400);
				ImageResizer.saveImage(bufferedImageResize, ROOT_PATH +"/"+ foto.getOriginalFilename());
				logger.info("Esta es la ruta absoluta=" + rutaCompleta.toAbsolutePath());

				fotos.setIdFotos(0);
				fotos.setFotos(foto.getOriginalFilename());
				fotos.setUsuario(usuario);

				service.salvarFoto(fotos);

				model.addAttribute("fotoSubida", "La foto se ha añadido con exito, la podras ver en la galeria");
				model.addAttribute("usuario", usuario);
				return "usuarios/subirFoto";

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		model.addAttribute("fotoSubida",
				"La foto no se ha añadido con exito, probablemente no escogio una foto, vuelva a intentarlo");
		model.addAttribute("usuario", usuario);
		return "usuarios/subirFoto";
	}

	@PostMapping(value = ("/paginaEditarFoto"), produces = MediaType.APPLICATION_JSON_VALUE)
	public String paginaeditarFoto(@RequestParam("idFoto") int idFoto, Model model, HttpSession sesion) {
		logger.info("Entramos en metodo salvarFoto");

		logger.info("El  idfoto  que recogemos es " + idFoto);

		Fotos fotos = service.fotoById(idFoto);
		;

		model.addAttribute("foto", fotos);

		return "usuarios/editarFoto";
	}

	@PostMapping(value = ("/editarFoto"), produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String editarFoto(@RequestParam("mails") String mail, @RequestParam("idFotos") String id,
			@RequestParam("file") MultipartFile foto, Model model, HttpSession sesion) {
		logger.info("Entramos en metodo editarFoto");
		logger.info("El mail que recogemos es: " + mail + "  con la idfoto  " + id + "  con la foto  " + foto);

		String idFoto = id;
		logger.info("Entramos en metodo editarFoto" + idFoto);

		Usuario usuario = usuarioservice.usuarioPorEmail(mail.trim());

		// logger.info("Entramos en metodo editarFoto"+usuario.getEmail());
		Fotos fotos = new Fotos();

		int idfoto = Integer.parseInt(id);
		fotos = service.fotoById(idfoto);

		

		if (!foto.isEmpty() && usuario != null) {
			int oraLen = foto.getOriginalFilename().length();
			logger.info("El nombre de la foto es: " + foto.getOriginalFilename());

			for (int i = 0; i < oraLen; i++) {
				if (foto.getOriginalFilename().charAt(i) == ' ') {

					return "El nombre de la foto no puede tener espacios en blanco.";
				}
			}

			try {
				byte[] bytes = foto.getBytes();
				Path rutaCompleta = Paths.get(ROOT_PATH + "//" + fotos.getFotos());
				logger.info("Esta es la ruta absoluta=" + rutaCompleta.toAbsolutePath());
				Files.write(rutaCompleta, bytes);
				BufferedImage bufferedImage = ImageResizer.loadImage(ROOT_PATH + "/" + fotos.getFotos());
				BufferedImage bufferedImageResize = ImageResizer.resize(bufferedImage, 400, 400);

				ImageResizer.saveImage(bufferedImageResize, ROOT_PATH + "/" + foto.getOriginalFilename());
				fotos.setIdFotos(fotos.getIdFotos());
				fotos.setFotos(fotos.getFotos());
				fotos.setUsuario(usuario);

				service.salvarFoto(fotos);

				return "La foto se ha editado con exito, la podras ver en la galeria";

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		String mensaje = "La foto se ha editado correctamente";
		return mensaje;
	}

	@PostMapping("/borrarFoto")
	public String borrarFoto(@RequestParam("fotos") String foto, @RequestParam("email") String email,
			@RequestParam("idFotos") int idFotos, Model model) {

		Usuario usuario = usuarioservice.usuarioPorEmail(email);

		if (foto != null) {
			try {

				service.deleteFoto(foto, email, usuario, idFotos);
			} catch (Exception e) {

				e.printStackTrace();
			}

			model.addAttribute("fotoBorrada", "La foto se ha borrado con exito.");
		} else {
			List<Fotos> fotosLista = service.todasLasFotos();
			model.addAttribute("fotosLista", fotosLista);
			return "administrador/listaFotos";
		}
		List<Fotos> fotosLista = service.todasLasFotos();
		model.addAttribute("fotosLista", fotosLista);
		return "administrador/listaFotos";
	}

	@PostMapping("/borrarFotoUsuario")
	public String borrarFotoUsuario(@RequestParam("fotos") String foto, @RequestParam("email") String email,
			@RequestParam("idFotos") int idFotos, Model model) {
		Usuario usuario = usuarioservice.usuarioPorEmail(email);

		if (foto != null) {
			try {

				service.deleteFoto(foto, email, usuario, idFotos);
			} catch (Exception e) {

				e.printStackTrace();
			}
			model.addAttribute("fotoBorrada", "La foto se ha borrado con exito.");

		} else {
			List<Fotos> fotosLista = service.todasByIdUsuario(usuario.getIdUsuario());
			model.addAttribute("fotosLista", fotosLista);
			return "usuarios/misFotos";
		}
		List<Fotos> fotosLista = service.todasByIdUsuario(usuario.getIdUsuario());
		model.addAttribute("fotosLista", fotosLista);
		return "usuarios/misFotos";
	}

	/**
	 * Metodo que devuelve todas las fotos paginadas
	 * 
	 * @param page
	 * @param model
	 * @param sesion
	 * @return
	 */
	@GetMapping(value = "/fotosGaleria")
	public String parametrosTabla(@RequestParam(name = "page", defaultValue = "0") int page, Model model,
			RedirectAttributes flash, Locale locale, HttpSession sesion) {

		logger.info("Entramos en METODO  doMostrarTemperaturasTabla");

		Pageable pagaRequest = PageRequest.of(page, 3,Sort.by("idFotos").descending());

		Page<Fotos> fotosEnPagina = service.fotosPaginas(pagaRequest);
		
		

		PageRender<Fotos> pageRender = new PageRender<>("/fotosGaleria", fotosEnPagina);

		model.addAttribute("parametros", fotosEnPagina);
		model.addAttribute("page", pageRender);
		pageRender.getPaginas().forEach(p -> logger.info("estas son las imagenes" + p.getNumero()));
		fotosEnPagina.forEach(p -> logger.info("estas son las imagenes" + p.getFotos()));
		return "portadas/galeriafoto";
	}

}
