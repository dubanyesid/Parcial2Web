package co.edu.ufps.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {

private Connection jdbcConnection = null;
	
	private static final String host = "queenie.db.elephantsql.com";
	private static final String dbName = "mnjgxshj";
	private static final String url = "jdbc:postgresql://" + host + ":5432/" + dbName;
	private static final String driver = "org.postgresql.Driver";
	private static final String userName = "mnjgxshj";
	private static final String password = "Uzjqo00sxV0W9OzPEB1q3wpoVvGMbbUV";
	
	@SuppressWarnings("static-access")
	public Connection conectar() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName(driver);
				jdbcConnection = DriverManager.getConnection(this.url, this.userName, this.password);
				System.out.println("Se conect� correctamente");
				
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
		}
		return jdbcConnection;
	}

	
	
	public void desconectar() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}
}
