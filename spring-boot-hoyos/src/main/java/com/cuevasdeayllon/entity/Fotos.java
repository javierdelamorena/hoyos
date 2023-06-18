package com.cuevasdeayllon.entity;

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
@Table(name="fotos")
public class Fotos {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idfotos")
	private int idFotos;
	
	private String fotos;
	


	
	@ManyToOne
	@JoinColumn(name="id_usuario",referencedColumnName ="id_usuario" )
	@JsonBackReference
	private Usuario usuario;

	public Fotos() {
		super();
	}

	public int getIdFotos() {
		return idFotos;
	}

	public void setIdFotos(int idFotos) {
		this.idFotos = idFotos;
	}

	public String getFotos() {
		return fotos;
	}

	public void setFotos(String fotos) {
		this.fotos = fotos;
	}

	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	
	
	
	

}
