package co.edu.ufps.util;

public class Prueba2 {
	public static void main(String args[]) {
	   	 ConexionPostgreSQL conexion=new ConexionPostgreSQL();
	   	conexion.consultar("SELECT * FROM votante;");
	   	 
	    }

}
