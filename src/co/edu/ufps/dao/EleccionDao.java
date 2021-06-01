package co.edu.ufps.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import co.edu.ufps.model.Eleccion;
import co.edu.ufps.util.Conexion;

public class EleccionDao implements GenericDao <Eleccion, Integer> {
	private Conexion con;
	private Connection conection;
	private static final String INSERTAR_ELECCION_SQL = "INSERT INTO eleccion(id,nombre,fechainicio,fechafin,cargo) VALUES (?,?,?,?,?)";
	private static final String ELIMINAR_ELECCION_SQL = "DELETE FROM eleccion WHERE id=?";
	private static final String ACTUALIZAR_ELECCION_SQL = "UPDATE eleccion SET nombre=?,fechainicio=?,fechafin=?,cargo=? WHERE id=?";
	private static final String BUSCAR_ELECCION_SQL = "SELECT * FROM eleccion WHERE id=?";
	private static final String LISTAR_ELECCION_SQL = "SELECT * FROM eleccion";

	public EleccionDao() throws SQLException {
		this.con = new Conexion();
	}

	public boolean insertar(Eleccion e)throws SQLException {
		boolean rowInserted = false;

		this.con.conectar();
		this.conection = this.con.conectar();

		PreparedStatement prepared = this.conection.prepareStatement(INSERTAR_ELECCION_SQL);
		prepared.setInt(1, e.getId());
		prepared.setString(2, e.getNombre());
		prepared.setDate(3, (Date)e.getFecha());
		prepared.setDate(4, (Date)e.getFechaFin());
		prepared.setString(5, e.getCargo());
		
		rowInserted = prepared.executeUpdate() > 0;
		prepared.close();
		this.con.desconectar();

		return rowInserted;
	}

	public boolean actualizar(Eleccion e)  throws SQLException {
		boolean rowElimined = false;

		this.con.conectar();
		this.conection = this.con.conectar();

		PreparedStatement prepared = this.conection.prepareStatement( ACTUALIZAR_ELECCION_SQL);
		prepared.setInt(1, e.getId());
		prepared.setString(2, e.getNombre());
		prepared.setDate(3, (Date)e.getFecha());
		prepared.setDate(4, (Date)e.getFechaFin());
		prepared.setString(5, e.getCargo());
		
		rowElimined = prepared.executeUpdate() > 0;
		prepared.close();
		this.con.desconectar();

		return rowElimined;
	}

	public Eleccion  buscar(Integer id) throws SQLException {
		Eleccion e = null;

		this.con.conectar();
		this.conection = this.con.conectar();

		PreparedStatement prepared = this.conection.prepareStatement(BUSCAR_ELECCION_SQL);
		prepared.setInt(1, id);

		ResultSet rs = prepared.executeQuery();

		if (rs!=null && rs.next()) {
			
			e = new Eleccion(id, rs.getString("nombre"), rs.getDate("fechainicio"), rs.getDate("fechafin"),
					rs.getString("cargo"));
		}
		rs.close();
		this.con.desconectar();

		return e;
	}

	public boolean eliminar(Integer id) throws SQLException {
		boolean rowElimined = false;

		this.con.conectar();
		this.conection = this.con.conectar();

		PreparedStatement prepared = this.conection.prepareStatement(ELIMINAR_ELECCION_SQL );
		prepared.setInt(1, id);

		rowElimined = prepared.executeUpdate() > 0;
		prepared.close();
		this.con.desconectar();

		return rowElimined;
	}
	
	public List<Eleccion> list() throws SQLException {
		List<Eleccion> list = new ArrayList<>();

		this.con.conectar();
		this.conection = this.con.conectar();

		Statement statement = this.conection.createStatement();
		ResultSet rs = statement.executeQuery( LISTAR_ELECCION_SQL);

		while (rs.next()) {
			
			Integer id = rs.getInt("id");
			String nombre = rs.getString("nombre");
			Date fecha = rs.getDate("fechainicio");
			Date fechafin = rs.getDate("fechafin");
			String cargo = rs.getString("cargo");
			
			

			Eleccion e = new Eleccion(id, nombre, fecha, fechafin,cargo);
			list.add(e);
		}

		this.con.desconectar();

		return list;
	}
}
