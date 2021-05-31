package co.edu.ufps.model;

import java.io.Serializable;

public class TipoDocumento implements Serializable{

	private Integer id;
	private String descripcion;
	
	
	public TipoDocumento() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TipoDocumento(Integer id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
	
	
}
