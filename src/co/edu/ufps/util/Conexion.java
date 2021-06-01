package co.edu.ufps.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {

private Connection jdbcConnection = null;
	
/*private static final String host = "queenie.db.elephantsql.com";
private static final String dbName = "mnjgxshj";
private static final String url = "jdbc:postgresql://" + host + ":5432/" + dbName;
private static final String driver = "org.postgresql.Driver";
private static final String userName = "mnjgxshj";
private static final String password = "Uzjqo00sxV0W9OzPEB1q3wpoVvGMbbUV";*/
	
private static final String host = "kashin.db.elephantsql.com";
private static final String dbName = "mpybktnb";
private static final String url = "jdbc:postgresql://" + host + ":5432/" + dbName;
private static final String driver = "org.postgresql.Driver";
private static final String userName = "mpybktnb";
private static final String password = "WhyxLHVX1nhKKGqqdEHfXNUYo4wS3HVA";
	
	
	@SuppressWarnings("static-access")
	public Connection conectar() throws SQLException {
		System.out.println("a"+jdbcConnection);
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName(driver);
				System.out.println("b"+jdbcConnection);
				jdbcConnection = (Connection)DriverManager.getConnection(this.url, this.userName, this.password);
				System.out.println("Se conectó correctamente");
				System.out.println(jdbcConnection);
			} catch (Exception e) {
				System.out.println(e.getMessage());
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
