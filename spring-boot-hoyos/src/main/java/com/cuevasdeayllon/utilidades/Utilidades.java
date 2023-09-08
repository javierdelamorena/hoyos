package com.cuevasdeayllon.utilidades;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.cuevasdeayllon.dto.ComentariosDto;
import com.cuevasdeayllon.dto.EstadosPropuestas;
import com.cuevasdeayllon.dto.PropuestaDto;
import com.cuevasdeayllon.entity.Comentarios;
import com.cuevasdeayllon.entity.Propuestas;

public class Utilidades {

	public static ComentariosDto comentariosTocomentariosDto(Comentarios comentarios) {

		ComentariosDto comentariosDto = new ComentariosDto();

		comentariosDto.setComentario(comentarios.getComentario());
		comentariosDto.setId(comentarios.getId());
		comentariosDto.setPropuesta(comentarios.getPropuesta());
		comentariosDto.setUsuario(comentarios.getUsuario());
		comentariosDto.setEditable(comentarios.getEditable());
		return comentariosDto;

	}

	public static Comentarios comentariosDtoTocomentarios(ComentariosDto comentariosDTO) {

		Comentarios comentarios = new Comentarios();

		comentarios.setComentario(comentariosDTO.getComentario());
		comentarios.setId(comentariosDTO.getId());
		comentarios.setPropuesta(comentariosDTO.getPropuesta());
		comentarios.setUsuario(comentariosDTO.getUsuario());
		comentarios.setEditable(comentariosDTO.getEditable());
		return comentarios;

	}

	public static List<Comentarios> comentariosDtoListTocomentarios(List<ComentariosDto> comentariosLitaDto) {
		List<Comentarios> comentariosLita = new ArrayList<>();
		
		Comentarios comentarios = null;
		for (int i = 0; i < comentariosLitaDto.size(); i++) {
			comentarios = new Comentarios();
			comentarios.setComentario(comentariosLitaDto.get(i).getComentario());
			comentarios.setId(comentariosLitaDto.get(i).getId());
			comentarios.setPropuesta(comentariosLitaDto.get(i).getPropuesta());
			comentarios.setUsuario(comentariosLitaDto.get(i).getUsuario());
			comentarios.setEditable(comentariosLitaDto.get(i).getEditable());
			comentariosLita.add(comentarios);
		}
		return comentariosLita;

	}

	public static List<EstadosPropuestas> listaPropuestasAlistaEstadosPropuestas(List<Propuestas> propuestas) {

		List<EstadosPropuestas> estadosPropuestas = new ArrayList<>();

		for (int i = 0; i < propuestas.size(); i++) {
			EstadosPropuestas estadoPropuesta = new EstadosPropuestas();

			estadoPropuesta.setIdPropuesta(propuestas.get(i).getIdPropuesta());
			estadoPropuesta.setPropuesta(propuestas.get(i).getPropuesta());
			estadoPropuesta.setTitulo(propuestas.get(i).getTitulo());
			estadoPropuesta.setActiva(propuestas.get(i).getActiva());
			estadoPropuesta.setUsuario(propuestas.get(i).getUsuario());
			estadoPropuesta.setFecha(propuestas.get(i).getFecha());

			for (int j = 0; j < propuestas.get(i).getEstados().size(); j++) {

				estadoPropuesta.setId_estado(propuestas.get(i).getEstados().get(j).getId());
				estadoPropuesta.setVotacion(propuestas.get(i).getEstados().get(j).getVotacion());
				estadoPropuesta.setEncurso(propuestas.get(i).getEstados().get(j).getEncurso());
				estadoPropuesta.setPleno(propuestas.get(i).getEstados().get(j).getPleno());
				estadoPropuesta.setRealizada(propuestas.get(i).getEstados().get(j).getRealizada());
				estadoPropuesta.setDesestimada(propuestas.get(i).getEstados().get(j).getDesestimada());
				estadoPropuesta.setTextoDesestimada(propuestas.get(i).getEstados().get(j).getTextoDesestimada());

			}

			estadosPropuestas.add(estadoPropuesta);

			estadosPropuestas = estadosPropuestas.stream()
					.sorted(Comparator.comparing(EstadosPropuestas::getIdPropuesta).reversed())
					.collect(Collectors.toList());

		}
		return estadosPropuestas;

	}
	public static PropuestaDto propuestaApropuestaDto(Propuestas propuesta) {
		PropuestaDto propuestaDto=new PropuestaDto() ;
			propuestaDto.setActiva(propuesta.getActiva());
			propuestaDto.setEstados(propuesta.getEstados());
			propuestaDto.setComentario(propuesta.getComentario());
			propuestaDto.setFecha(propuesta.getFecha());
			propuestaDto.setTitulo(propuesta.getTitulo());
			propuestaDto.setUsuario(propuesta.getUsuario());
			propuestaDto.setIdPropuesta(propuesta.getIdPropuesta());
			propuestaDto.setPropuesta(propuesta.getPropuesta());
			return propuestaDto;
			
		
		
	}
}
