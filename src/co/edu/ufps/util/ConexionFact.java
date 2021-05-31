package co.edu.ufps.util;

import java.sql.ResultSet;

public interface ConexionFact {
	
	public void conectar();
	public ResultSet consultar(String sql);
	public void cerrarConexion();
}
