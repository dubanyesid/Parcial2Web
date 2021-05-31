package co.edu.ufps.model;

import java.io.Serializable;

public class Candidato implements Serializable {
	
	private Integer id;
	private String documento;
	private String nombre;
	private String apellido;
	private Integer eleccion;
	private Integer numero;
	
	public Candidato() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Candidato(Integer id, String documento, String nombre, String apellido, Integer eleccion, Integer numero) {
		super();
		this.id = id;
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.eleccion = eleccion;
		this.numero = numero;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getEleccion() {
		return eleccion;
	}

	public void setEleccion(Integer eleccion) {
		this.eleccion = eleccion;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	
	

}
