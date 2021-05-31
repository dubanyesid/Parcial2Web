package co.edu.ufps.model;

import java.io.Serializable;

public class Estamento implements Serializable{
	private int id;
	private int eleccion;
	private String descripcion;
	public Estamento() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Estamento(int id, int eleccion, String descripcion) {
		super();
		this.id = id;
		this.eleccion = eleccion;
		this.descripcion = descripcion;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEleccion() {
		return eleccion;
	}
	public void setEleccion(int eleccion) {
		this.eleccion = eleccion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
