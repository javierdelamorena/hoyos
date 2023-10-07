package com.cuevasdeayllon.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cuevasdeayllon.entity.Enlaces;
import com.cuevasdeayllon.entity.Mercadillo;
import com.cuevasdeayllon.entity.Usuario;
import com.cuevasdeayllon.repository.AnuncioRepositoryImpl;
import com.cuevasdeayllon.service.EnlacesService;

@Controller
public class EnlacesControllers {
	
	private static final Logger logger = LoggerFactory.getLogger(EnlacesControllers.class);
	
	@Autowired
	private EnlacesService enlacesService;
	
	@GetMapping("/enlaces")
			public String enlaces(HttpSession session,Model model) {

				logger.info("Entramos en metodo enlaces: ");
				List<String>tipoEnlace= Arrays.asList("Comercio","Vecino","Asociacion");
				
				Enlaces enlace=new Enlaces();
				
				model.addAttribute("tipo_enlace","Tipo Enlace" );
				model.addAttribute("nombre","Nombre del anunciante");
				model.addAttribute("apellidos","Apellido del anunciante");
				model.addAttribute("telefono","Telefono");
				model.addAttribute("direccion","Direccion");				
				model.addAttribute("texto1", "Texto1");
				model.addAttribute("texto2", "Texto2");
				model.addAttribute("texto3", "Texto3");
				model.addAttribute("foto1", "Foto 1");
				model.addAttribute("foto2", "Foto 2");
				model.addAttribute("enlaceweb", "Enlace web");
				
				
				model.addAttribute("telefono", "Telefono del anunciante");
				
				
				model.addAttribute("Enlaces",enlace);
				

				return "enlacesAdministrador";

			}
	
	@PostMapping("/insertarEnlace")
	public String insertarEnlace(@ModelAttribute Enlaces enlaces,Model model,@RequestParam("file1") MultipartFile file1,@RequestParam("file2") MultipartFile file2 ) {
		logger.info("Entramos en /insertarEnlace:" );
		
		
		
		enlacesService.salvarEnlace(enlaces, file1, file2);
		
		model.addAttribute("enlaceAgregado", "El enlace se ha agregado con exito");
		Enlaces enlace=new Enlaces();
		
		model.addAttribute("tipo_enlace","Tipo Enlace" );
		model.addAttribute("nombre","Nombre del anunciante");
		model.addAttribute("apellidos","Apellido del anunciante");
		model.addAttribute("telefono","Telefono");
		model.addAttribute("direccion","Direccion");				
		model.addAttribute("texto1", "Texto1");
		model.addAttribute("texto2", "Texto2");
		model.addAttribute("texto3", "Texto3");
		model.addAttribute("foto1", "Foto 1");
		model.addAttribute("foto2", "Foto 2");
		model.addAttribute("enlaceweb", "Enlace web");
		
		
		model.addAttribute("telefono", "Telefono del anunciante");
		
		
		model.addAttribute("Enlaces",enlace);
		
		return "enlacesAdministrador";
	}
	@PostMapping("/borrarEnlace")
	public String borrarEnlace(@RequestParam("idEnlace") int enlace,Model model ) {
		
		enlacesService.borrarEnlace(enlace);
		model.addAttribute("enlaceborrado", "El enlace se ha borrado con exito");
		
		return "enlacesAdministrador";
	}
	@GetMapping("/todosEnlace")
	public @ResponseBody List<Enlaces> todosEnlace() {
		
		
		List<Enlaces>enlacesList=enlacesService.todosLosElaces();
		
		return enlacesList;
	}
	@GetMapping("/listaEnlaces")
	public String  listaEnlace(Model model) {
		
		
		List<Enlaces>enlacesList=enlacesService.todosLosElaces();
		model.addAttribute("listaEnlaces", enlacesList);
		return "listaEnlaces";
	}
	@GetMapping("/unEnlace")
	public @ResponseBody Enlaces unEnlace(@RequestParam("idEnlace") int enlace) {
		
		Enlaces unEnlace=enlacesService.unEnlace(enlace);
		
		
		return unEnlace;
	}
}
