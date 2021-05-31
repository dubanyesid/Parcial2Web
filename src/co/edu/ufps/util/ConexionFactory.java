package co.edu.ufps.util;

public class ConexionFactory {

	public ConexionFact getConexion(String tipo) {
		
		switch(tipo.toUpperCase()) {
		case "MYSQL":
			return new ConexionMySQL();
		case "POSTGRESQL":
			return new ConexionPostgreSQL();
		default:
			return null;
		}
	}

}
