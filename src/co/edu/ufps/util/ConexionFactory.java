package co.edu.ufps.util;

public class ConexionFactory {

	static String tipo = "postgresql";

	

	public static ConexionFact getConexion() {
		if (tipo.contentEquals("postgresql")) {
			return  ConexionPostgreSQL.getConexion();
		} else if (tipo.contentEquals("mysql")) {
			return  ConexionMysql.getConexion();
		}

		return null;
	}

}
