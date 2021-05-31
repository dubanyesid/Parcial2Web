package co.edu.ufps.util;
import co.edu.ufps.dao.CandidatoDao;
import co.edu.ufps.model.*;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class Prueba {
	public static void main(String[] args) {
		/*
		 * ConexionFactoryImpl con = new ConexionFactoryImpl();
		 * 
		 * ConexionFactory conexionFactory = con.getConexion("PostgreSQL");
		 * 
		 * if(conexionFactory!=null) { ResultSet
		 * rs=conexionFactory.consultar("select * from persona");
		 * 
		 * try { while(rs.next()) { System.out.println(rs.getString(2));
		 * 
		 * 
		 * } } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * }else { System.out.println("pailas"); }
		 */
		
		
		
		try {
			CandidatoDao cDAO = new CandidatoDao();
			
			
			
			  Date date= Date.valueOf(LocalDate.of(2000, 11, 07));
			  
				
				  Candidato c =new Candidato(1, "cedula","duban","Silva", 1, 2 );
				 cDAO.insertar(c);
			  
			
			List<Candidato> l=cDAO.list();
			
			for(Candidato cl:l) {
				
				System.out.println(cl);
			}
			cDAO.eliminar(0);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
