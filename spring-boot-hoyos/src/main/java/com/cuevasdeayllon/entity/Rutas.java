package com.cuevasdeayllon.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rutas")
public class Rutas implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idrutas")
	private int id;
	private String nombre;  
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private String texto1;

	private String texto2;

	private String texto3;

	private String texto4;

	private String texto5;

	private String foto1;

	private String foto2;

	private String foto3;

	private String foto4;

	private String foto5;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTexto1() {
		return texto1;
	}

	public void setTexto1(String texto1) {
		this.texto1 = texto1;
	}

	public String getTexto2() {
		return texto2;
	}

	public void setTexto2(String texto2) {
		this.texto2 = texto2;
	}

	public String getTexto3() {
		return texto3;
	}

	public void setTexto3(String texto3) {
		this.texto3 = texto3;
	}

	public String getTexto4() {
		return texto4;
	}

	public void setTexto4(String texto4) {
		this.texto4 = texto4;
	}

	public String getTexto5() {
		return texto5;
	}

	public void setTexto5(String texto5) {
		this.texto5 = texto5;
	}

	public String getFoto1() {
		return foto1;
	}

	public void setFoto1(String foto1) {
		this.foto1 = foto1;
	}

	public String getFoto2() {
		return foto2;
	}

	public void setFoto2(String foto2) {
		this.foto2 = foto2;
	}

	public String getFoto3() {
		return foto3;
	}

	public void setFoto3(String foto3) {
		this.foto3 = foto3;
	}

	public String getFoto4() {
		return foto4;
	}

	public void setFoto4(String foto4) {
		this.foto4 = foto4;
	}

	public String getFoto5() {
		return foto5;
	}

	public void setFoto5(String foto5) {
		this.foto5 = foto5;
	}

}
