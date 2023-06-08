package com.cuevasdeayllon.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import com.cuevasdeayllon.entity.Comentarios;
import com.cuevasdeayllon.entity.Usuario;

public class EstadosPropuestas {

	private int id_estado;
	private int idPropuesta ;
	private String votacion;
    private String encurso;
    private String realizada;
    private String desestimada;
    private String pleno;
    private String textoDesestimada;
    private Usuario usuario;
    
    private String propuesta;
	private String titulo;
	
	private String activa;
	private Date fecha;
	
	public EstadosPropuestas() {
		super();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getId_estado() {
		return id_estado;
	}
	public void setId_estado(int id_estado) {
		this.id_estado = id_estado;
	}
	
	public int getIdPropuesta() {
		return idPropuesta;
	}

	public void setIdPropuesta(int idPropuesta) {
		this.idPropuesta = idPropuesta;
	}

	
	public String getVotacion() {
		return votacion;
	}
	public void setVotacion(String votacion) {
		this.votacion = votacion;
	}
	public String getEncurso() {
		return encurso;
	}
	public void setEncurso(String encurso) {
		this.encurso = encurso;
	}
	public String getRealizada() {
		return realizada;
	}
	public void setRealizada(String realizada) {
		this.realizada = realizada;
	}
	public String getDesestimada() {
		return desestimada;
	}
	public void setDesestimada(String desestimada) {
		this.desestimada = desestimada;
	}
	public String getPleno() {
		return pleno;
	}
	public void setPleno(String pleno) {
		this.pleno = pleno;
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

	public String getTextoDesestimada() {
		return textoDesestimada;
	}

	public void setTextoDesestimada(String textoDesestimada) {
		this.textoDesestimada = textoDesestimada;
	}
	
	
	
	
	
	
	
	
}
