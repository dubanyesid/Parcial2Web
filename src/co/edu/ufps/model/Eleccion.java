package co.edu.ufps.model;

import java.io.Serializable;

public class Eleccion implements Serializable {
	
	
	private Integer id;
	private String nombre;
	private String fecha;
	private String fechaFin;
	private String cargo;
	public Eleccion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Eleccion(Integer id, String nombre, String fecha, String fechaFin, String cargo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fecha = fecha;
		this.fechaFin = fechaFin;
		this.cargo = cargo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	
}
