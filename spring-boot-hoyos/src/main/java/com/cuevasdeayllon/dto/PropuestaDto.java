package com.cuevasdeayllon.dto;

import java.util.Date;
import java.util.List;

import com.cuevasdeayllon.entity.Comentarios;
import com.cuevasdeayllon.entity.Estados;
import com.cuevasdeayllon.entity.Usuario;

public class PropuestaDto {
	
	int idPropuesta;
	
	private String propuesta;
	private String titulo;
	
	private String activa;
	private Date fecha;
	

	
	private Usuario usuario;
	
	private List<Comentarios> comentario;
	
	
	public int getIdPropuesta() {
		return idPropuesta;
	}


	public void setIdPropuesta(int idPropuesta) {
		this.idPropuesta = idPropuesta;
	}


	public String getPropuesta() {
		return propuesta;
	}


	public void setPropuesta(String propuesta) {
		this.propuesta = propuesta;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getActiva() {
		return activa;
	}


	public void setActiva(String activa) {
		this.activa = activa;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public List<Comentarios> getComentario() {
		return comentario;
	}


	public void setComentario(List<Comentarios> comentario) {
		this.comentario = comentario;
	}


	public List<Estados> getEstados() {
		return estados;
	}


	public void setEstados(List<Estados> estados) {
		this.estados = estados;
	}


	private List<Estados> estados;

}
