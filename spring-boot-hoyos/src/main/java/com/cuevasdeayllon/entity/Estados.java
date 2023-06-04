package com.cuevasdeayllon.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="estadospropuestas")
public class Estados implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_estado")
	private int id;
	
		
	private String votacion;
    private String encurso;
    private String realizada;
    private String desestimada;
    
    @ManyToOne
	@JoinColumn(name="id_propuesta",referencedColumnName ="id_propuesta" )
	@JsonBackReference
	private Propuestas propuesta;

    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Propuestas getPropuestas() {
		return propuesta;
	}
	public void setPropuestas(Propuestas propuestas) {
		this.propuesta = propuestas;
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
    
    
}
