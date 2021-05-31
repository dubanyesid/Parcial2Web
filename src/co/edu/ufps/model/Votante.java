package co.edu.ufps.model;

public class Votante {
	
	private Integer id;
	private String nombre;
	private String email;
	private String documento;
	private TipoDocumento tipoDocumento;
	private Eleccion eleccion;
	public Votante() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Votante(Integer id, String nombre, String email, String documento, TipoDocumento tipoDocumento,
			Eleccion eleccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.documento = documento;
		this.tipoDocumento = tipoDocumento;
		this.eleccion = eleccion;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public Eleccion getEleccion() {
		return eleccion;
	}
	public void setEleccion(Eleccion eleccion) {
		this.eleccion = eleccion;
	}
	
	

}
