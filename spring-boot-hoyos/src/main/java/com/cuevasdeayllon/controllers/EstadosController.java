package com.cuevasdeayllon.controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cuevasdeayllon.dto.EstadosPropuestas;
import com.cuevasdeayllon.entity.Estados;
import com.cuevasdeayllon.entity.Propuestas;
import com.cuevasdeayllon.service.EstadosService;
import com.cuevasdeayllon.service.PropuestaService;
import com.cuevasdeayllon.utilidades.Utilidades;

@Controller
public class EstadosController {
	
	private static final Logger logger = LoggerFactory.getLogger(EstadosController.class);
	
	@Autowired
	private PropuestaService propuestaService;
	@Autowired
	private EstadosService estadosService;
	
	@GetMapping("/editarEstadoLista")
	public String editarEstadoLista(Model model) {
		logger.info("Entramos en metodo /editarEstadoLista");
		List<Propuestas> propuestas = propuestaService.findByTodas();
		logger.info("Entramos en metodo /editarEstadoLista:" + propuestas);
		propuestas = propuestas.stream().sorted(Comparator.comparing(Propuestas::getIdPropuesta).reversed())
				.collect(Collectors.toList());
		List<EstadosPropuestas> estadosPropuestas = new ArrayList<>();			
		
		 estadosPropuestas=Utilidades.listaPropuestasAlistaEstadosPropuestas(propuestas);
		 
		
		
		model.addAttribute("listaPropuestas", estadosPropuestas);
		return "administrador/editarEstado";

	}

	@PostMapping("/editarEstadoVotacion")
	public String editarEstadoVotacion(@RequestParam("idPropuesta") int idPropuesta, Model model) {
		
		Estados estado=estadosService.findByIdPropuesta(idPropuesta);
		Propuestas propuesta=propuestaService.findByIdPropuesta(idPropuesta);
		estado.setId(idPropuesta);
		estado.setVotacion("votacion");
		estado.setRealizada(null);
		estado.setPleno(null);
		estado.setDesestimada(null);
		estado.setEncurso(null);
		estado.setId(estado.getId());
		estado.setPropuesta(propuesta);
		estado.setTextoDesestimada("");
		estadosService.actualizarEstado(estado);
		
		List<Propuestas> propuestas = propuestaService.findByTodas();
		logger.info("Entramos en metodo  /editarEstadoPleno:" + propuestas);
		propuestas = propuestas.stream().sorted(Comparator.comparing(Propuestas::getIdPropuesta).reversed())
				.collect(Collectors.toList());
		List<EstadosPropuestas> estadosPropuestas = new ArrayList<>();			
		
		estadosPropuestas=Utilidades.listaPropuestasAlistaEstadosPropuestas(propuestas);
		
		model.addAttribute("listaPropuestas", estadosPropuestas);
		
		logger.info("recibimos idPropuesta: " + idPropuesta);
		
		
		logger.info("Entramos en metodo /editarEstadoVotacion");
		
		model.addAttribute("input","La propuesta "+propuesta.getTitulo()+" ha sido editada correctamente en estado Votacion ");
		return "administrador/editarEstado";

	}
	@PostMapping("/editarEstadoEnCurso")
	public String editarEstadoEnCurso(@RequestParam("idPropuesta") int idPropuesta, Model model) {
		
		Estados estado=estadosService.findByIdPropuesta(idPropuesta);
		Propuestas propuesta=propuestaService.findByIdPropuesta(idPropuesta);
		estado.setId(idPropuesta);
		estado.setVotacion(null);
		estado.setRealizada(null);
		estado.setDesestimada(null);
		estado.setPleno(null);
		estado.setEncurso("encurso");
		estado.setId(estado.getId());
		estado.setPropuesta(propuesta);
		estado.setTextoDesestimada("");
		estadosService.actualizarEstado(estado);
		
		List<Propuestas> propuestas = propuestaService.findByTodas();
		logger.info("Entramos en metodo  /editarEstadoPleno:" + propuestas);
		propuestas = propuestas.stream().sorted(Comparator.comparing(Propuestas::getIdPropuesta).reversed())
				.collect(Collectors.toList());
		List<EstadosPropuestas> estadosPropuestas = new ArrayList<>();			
		
		estadosPropuestas=Utilidades.listaPropuestasAlistaEstadosPropuestas(propuestas);
		model.addAttribute("listaPropuestas", estadosPropuestas);
		
		logger.info("recibimos idPropuesta: " + idPropuesta);
		
		
		logger.info("Entramos en metodo /editarEstadoEncurso");
		
		model.addAttribute("input","La propuesta "+propuesta.getTitulo()+" ha sido editada correctamente en estado En Curso ");
		return "administrador/editarEstado";

	}
	@PostMapping("/editarEstadoPleno")
	public  String editarEstadoPleno(@RequestParam("idPropuesta") int idPropuesta, Model model) {
		
		Estados estado=estadosService.findByIdPropuesta(idPropuesta);
		Propuestas propuesta=propuestaService.findByIdPropuesta(idPropuesta);
		estado.setId(idPropuesta);
		estado.setVotacion(null);
		estado.setRealizada(null);
		estado.setPleno("pleno");
		estado.setEncurso(null);
		estado.setDesestimada(null);
		estado.setId(estado.getId());
		estado.setPropuesta(propuesta);
		estado.setTextoDesestimada("");
		estadosService.actualizarEstado(estado);
		List<Propuestas> propuestas = propuestaService.findByTodas();
		logger.info("Entramos en metodo  /editarEstadoPleno:" + propuestas);
		propuestas = propuestas.stream().sorted(Comparator.comparing(Propuestas::getIdPropuesta).reversed())
				.collect(Collectors.toList());
		List<EstadosPropuestas> estadosPropuestas = new ArrayList<>();			
		
		estadosPropuestas=Utilidades.listaPropuestasAlistaEstadosPropuestas(propuestas);
		model.addAttribute("listaPropuestas", estadosPropuestas);
		
		logger.info("recibimos idPropuesta: " + idPropuesta);
		
		
		logger.info("Entramos en metodo /editarEstadoPleno");
		
		model.addAttribute("input","La propuesta "+propuesta.getTitulo()+" ha sido editada correctamente en estado Pleno ");
		return "administrador/editarEstado";

	}
	@PostMapping("/editarEstadoRealizada")
	public String editarEstadoRealizada(@RequestParam("idPropuesta") int idPropuesta, Model model) {
		
		Estados estado=estadosService.findByIdPropuesta(idPropuesta);
		Propuestas propuesta=propuestaService.findByIdPropuesta(idPropuesta);
		estado.setId(idPropuesta);
		estado.setVotacion(null);
		estado.setRealizada("realizada");
		estado.setPleno(null);
		estado.setEncurso(null);
		estado.setDesestimada(null);
		estado.setId(estado.getId());
		estado.setPropuesta(propuesta);
		estado.setTextoDesestimada("");
		estadosService.actualizarEstado(estado);
		
		List<Propuestas> propuestas = propuestaService.findByTodas();
		logger.info("Entramos en metodo  /editarEstadoRealizada:" + propuestas);
		propuestas = propuestas.stream().sorted(Comparator.comparing(Propuestas::getIdPropuesta).reversed())
				.collect(Collectors.toList());
		List<EstadosPropuestas> estadosPropuestas = new ArrayList<>();			
		
		estadosPropuestas=Utilidades.listaPropuestasAlistaEstadosPropuestas(propuestas);
		
		model.addAttribute("listaPropuestas", estadosPropuestas);
		
		logger.info("recibimos idPropuesta: " + idPropuesta);
		
		
		logger.info("Entramos en metodo /editarEstadoRealizada");
		
		model.addAttribute("input","La propuesta "+propuesta.getTitulo()+" ha sido editada correctamente en estado realizada ");
		return "administrador/editarEstado";

	}
	@PostMapping("/editarEstadoDesestimada")
	public String editarEstadoDesestimada(@RequestParam("idPropuesta") int idPropuesta,@RequestParam("textoDesestimada") String textoDesestimada, Model model) {
		
		Estados estado=estadosService.findByIdPropuesta(idPropuesta);
		Propuestas propuesta=propuestaService.findByIdPropuesta(idPropuesta);
		
		if(textoDesestimada.isEmpty()) {
			List<Propuestas> propuestas = propuestaService.findByTodas();
			logger.info("Entramos en metodo /editarEstadoLista:" + propuestas);
			propuestas = propuestas.stream().sorted(Comparator.comparing(Propuestas::getIdPropuesta).reversed())
					.collect(Collectors.toList());
			List<EstadosPropuestas> estadosPropuestas = new ArrayList<>();			
			
			estadosPropuestas=Utilidades.listaPropuestasAlistaEstadosPropuestas(propuestas);
			model.addAttribute("listaPropuestas", estadosPropuestas);
			
			logger.info("recibimos idPropuesta: " + idPropuesta);
			
			
			logger.info("Entramos en metodo /editarEstadoDesestimada");
			
			model.addAttribute("input","La propuesta "+propuesta.getTitulo()+" no ha sido editada correctamente en estado desestimada porque no tiene un explicacion.");
			return "administrador/editarEstado";
			
		}
		estado.setId(idPropuesta);
		estado.setVotacion(null);
		estado.setRealizada(null);
		estado.setPleno(null);
		estado.setEncurso(null);
		estado.setDesestimada("desestimada");
		estado.setId(estado.getId());
		estado.setPropuesta(propuesta);
		estado.setTextoDesestimada(textoDesestimada);
		
		estadosService.actualizarEstado(estado);
		
		List<Propuestas> propuestas = propuestaService.findByTodas();
		logger.info("Entramos en metodo /editarEstadoLista:" + propuestas);
		propuestas = propuestas.stream().sorted(Comparator.comparing(Propuestas::getIdPropuesta).reversed())
				.collect(Collectors.toList());
		List<EstadosPropuestas> estadosPropuestas = new ArrayList<>();			
		
		estadosPropuestas=Utilidades.listaPropuestasAlistaEstadosPropuestas(propuestas);

		
		model.addAttribute("listaPropuestas", estadosPropuestas);
		
		logger.info("recibimos idPropuesta: " + idPropuesta);
		
		
		logger.info("Entramos en metodo /editarEstadoDesestimada");
		
		model.addAttribute("input","La propuesta "+propuesta.getTitulo()+" ha sido editada correctamente en estado desestimada ");
		return "administrador/editarEstado";
		

	}
	@GetMapping(value=("estadosPropuestasAjax"), produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<EstadosPropuestas> estadosPropuestasAjax(Model model) {

		List<EstadosPropuestas> estadosPropuestas = new ArrayList<>();			
		List<Propuestas> propuestas = propuestaService.findByTodas();

		estadosPropuestas=Utilidades.listaPropuestasAlistaEstadosPropuestas(propuestas);
    
		return estadosPropuestas;

	}

}
