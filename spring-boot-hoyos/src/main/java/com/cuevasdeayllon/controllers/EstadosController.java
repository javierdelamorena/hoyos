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
		

		for (int i = 0; i < propuestas.size(); i++) {
			EstadosPropuestas estadoPropuesta = new EstadosPropuestas();
			
			estadoPropuesta.setIdPropuesta(propuestas.get(i).getIdPropuesta());
			estadoPropuesta.setPropuesta(propuestas.get(i).getPropuesta());
			estadoPropuesta.setTitulo(propuestas.get(i).getTitulo());
			estadoPropuesta.setActiva(propuestas.get(i).getActiva());
			estadoPropuesta.setUsuario(propuestas.get(i).getUsuario());
			estadoPropuesta.setFecha(propuestas.get(i).getFecha());
			
			for (int j = 0;j < propuestas.get(i).getEstados().size(); j++) {
				
				estadoPropuesta.setId_estado(propuestas.get(i).getEstados().get(j).getId());
				estadoPropuesta.setVotacion(propuestas.get(i).getEstados().get(j).getVotacion());
				estadoPropuesta.setEncurso(propuestas.get(i).getEstados().get(j).getEncurso());
				estadoPropuesta.setPleno(propuestas.get(i).getEstados().get(j).getPleno());
				estadoPropuesta.setRealizada(propuestas.get(i).getEstados().get(j).getRealizada());
				estadoPropuesta.setDesestimada(propuestas.get(i).getEstados().get(j).getDesestimada());
				estadoPropuesta.setTextoDesestimada(propuestas.get(i).getEstados().get(j).getTextoDesestimada());
    
			}
    
			estadosPropuestas.add(estadoPropuesta);
			
			estadosPropuestas.forEach(p->logger.info("estos son los estados: "+p.getIdPropuesta()));
    
		}
		
		model.addAttribute("listaPropuestas", estadosPropuestas);
		return "editarEstado";

	}

	@PostMapping("/editarEstadoVotacion")
	public @ResponseBody String editarEstadoVotacion(@RequestParam("idPropuesta") int idPropuesta, Model model) {
		
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
		estadosService.actualizarEstado(estado);
		
		logger.info("Entramos en metodo /editarEstadoVotacion");
		
		String votaciones="La propuesta "+propuesta.getTitulo()+" ha sido editada correctamente en estado votacion ";
		return votaciones;

	}
	@PostMapping("/editarEstadoEnCurso")
	public @ResponseBody String editarEstadoEnCurso(@RequestParam("idPropuesta") int idPropuesta, Model model) {
		
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
		estadosService.actualizarEstado(estado);
		
		
		
		logger.info("Entramos en metodo /editarEstadoEnCurso");
		
		String enCursos="La propuesta "+propuesta.getTitulo()+" ha sido editada correctamente en estado en curso ";
		return enCursos;

	}
	@PostMapping("/editarEstadoPleno")
	public @ResponseBody String editarEstadoPleno(@RequestParam("idPropuesta") int idPropuesta, Model model) {
		
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
		estadosService.actualizarEstado(estado);
		
		logger.info("recibimos idPropuesta: " + idPropuesta);
		
		
		logger.info("Entramos en metodo /editarEstadoPleno");
		
		String plenos="La propuesta "+propuesta.getTitulo()+" ha sido editada correctamente en estado pleno ";
		return plenos;

	}
	@PostMapping("/editarEstadoRealizada")
	public @ResponseBody String editarEstadoRealizada(@RequestParam("idPropuesta") int idPropuesta, Model model) {
		
		Estados estado=estadosService.findByIdPropuesta(idPropuesta);
		Propuestas propuesta=propuestaService.findByIdPropuesta(idPropuesta);
		estado.setId(idPropuesta);
		estado.setVotacion(null);
		estado.setRealizada("realizada");
		estado.setPleno(null);
		estado.setEncurso(null);
		estado.setId(estado.getId());
		estado.setPropuesta(propuesta);
		estadosService.actualizarEstado(estado);
		
		logger.info("recibimos idPropuesta: " + idPropuesta);
		
		logger.info("Entramos en metodo /editarEstadoRealizada");
		
		String relizadas="La propuesta "+propuesta.getTitulo()+" ha sido editada correctamente en estado relizada ";
		return relizadas;

	}
	@PostMapping("/editarEstadoDesestimada")
	public @ResponseBody String editarEstadoDesestimada(@RequestParam("idPropuesta") int idPropuesta,@RequestParam("textoDesestimada") String textoDesestimada, Model model) {
		
		Estados estado=estadosService.findByIdPropuesta(idPropuesta);
		Propuestas propuesta=propuestaService.findByIdPropuesta(idPropuesta);
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
		
		logger.info("recibimos idPropuesta: " + idPropuesta);
		
		
		logger.info("Entramos en metodo /editarEstadoDesestimada");
		
		String desestimadas="La propuesta "+propuesta.getTitulo()+" ha sido editada correctamente en estado desestimada ";
		return desestimadas;

	}
	@GetMapping(value=("estadosPropuestasAjax"), produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<EstadosPropuestas> estadosPropuestasAjax(Model model) {

		List<EstadosPropuestas> estadosPropuestas = new ArrayList<>();			
		List<Propuestas> propuestas = propuestaService.findByTodas();

		for (int i = 0; i < propuestas.size(); i++) {
			EstadosPropuestas estadoPropuesta = new EstadosPropuestas();
			
			estadoPropuesta.setIdPropuesta(propuestas.get(i).getIdPropuesta());
			estadoPropuesta.setPropuesta(propuestas.get(i).getPropuesta());
			estadoPropuesta.setTitulo(propuestas.get(i).getTitulo());
			estadoPropuesta.setActiva(propuestas.get(i).getActiva());
			
			for (int j = 0;j < propuestas.get(i).getEstados().size(); j++) {
				
				estadoPropuesta.setId_estado(propuestas.get(i).getEstados().get(j).getId());
				estadoPropuesta.setVotacion(propuestas.get(i).getEstados().get(j).getVotacion());
				estadoPropuesta.setEncurso(propuestas.get(i).getEstados().get(j).getEncurso());
				estadoPropuesta.setPleno(propuestas.get(i).getEstados().get(j).getPleno());
				estadoPropuesta.setRealizada(propuestas.get(i).getEstados().get(j).getRealizada());
				estadoPropuesta.setDesestimada(propuestas.get(i).getEstados().get(j).getDesestimada());
				estadoPropuesta.setTextoDesestimada(propuestas.get(i).getEstados().get(j).getTextoDesestimada());
    
			}
    
			estadosPropuestas.add(estadoPropuesta);
			
			estadosPropuestas.forEach(p->logger.info("estos son los estados: "+p.getIdPropuesta()));
    
		}
    
		return estadosPropuestas;

	}

}
