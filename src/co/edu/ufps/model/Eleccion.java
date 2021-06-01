package co.edu.ufps.model;

import java.io.Serializable;
import java.util.Date;

public class Eleccion implements Serializable {
	
	
	private Integer id;
	private String nombre;
	private Date fechainicio;
	private Date fechaFin;
	private String cargo;
	public Eleccion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Eleccion(Integer id, String nombre, Date fechainicio, Date fechaFin, String cargo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechainicio = fechainicio;
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
	public Date getFecha() {
		return fechainicio;
	}
	public void setFecha(Date fecha) {
		this.fechainicio = fecha;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	
}
