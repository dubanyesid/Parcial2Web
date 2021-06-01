package co.edu.ufps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import co.edu.ufps.model.Estamento;
import co.edu.ufps.util.Conexion;

public class EstamentoDao implements GenericDao<Estamento, Integer> {
	
	private Conexion con;
	private Connection conection;
	private static final String INSERTAR_ESTAMENTO_SQL = "INSERT INTO estamento(id,eleccion,descripcion) VALUES (?,?,?)";
	private static final String ELIMINAR_ESTAMENTO_SQL = "DELETE FROM estamento WHERE id=?";
	private static final String ACTUALIZAR_ESTAMENTO_SQL = "UPDATE estamento SET eleccion=?,descripcion=? WHERE id=?";
	private static final String BUSCAR_ESTAMENTO_SQL = "SELECT * FROM estamenot WHERE id=?";
	private static final String LISTAR_ESTAMENTO_SQL = "SELECT * FROM estamento";

	public EstamentoDao() throws SQLException {
		this.con = new Conexion();
	}

	public boolean insertar(Estamento e)throws SQLException {
		boolean rowInserted = false;

		this.con.conectar();
		this.conection = this.con.conectar();

		PreparedStatement prepared = this.conection.prepareStatement(INSERTAR_ESTAMENTO_SQL);
		prepared.setInt(1, e.getId());
		prepared.setInt(2, e.getEleccion());
		prepared.setString(3, e.getDescripcion());
		

		rowInserted = prepared.executeUpdate() > 0;
		prepared.close();
		this.con.desconectar();

		return rowInserted;
	}

	public boolean actualizar(Estamento e)  throws SQLException {
		boolean rowElimined = false;

		this.con.conectar();
		this.conection = this.con.conectar();

		PreparedStatement prepared = this.conection.prepareStatement( ACTUALIZAR_ESTAMENTO_SQL);
		prepared.setInt(1, e.getId());
		prepared.setInt(2, e.getEleccion());
		prepared.setString(3, e.getDescripcion());
		rowElimined = prepared.executeUpdate() > 0;
		prepared.close();
		this.con.desconectar();

		return rowElimined;
	}

	public Estamento buscar(Integer id) throws SQLException {
		Estamento e = null;

		this.con.conectar();
		this.conection = this.con.conectar();

		PreparedStatement prepared = this.conection.prepareStatement( BUSCAR_ESTAMENTO_SQL );
		prepared.setInt(1, id);

		ResultSet rs = prepared.executeQuery();

		if (rs!=null && rs.next()) {
			
			e = new Estamento(id, rs.getInt("eleccion"), rs.getString("descripcion"));
		}
		rs.close();
		this.con.desconectar();

		return e;
	}

	public boolean eliminar(Integer id) throws SQLException {
		boolean rowElimined = false;

		this.con.conectar();
		this.conection = this.con.conectar();

		PreparedStatement prepared = this.conection.prepareStatement(ELIMINAR_ESTAMENTO_SQL);
		prepared.setInt(1, id);

		rowElimined = prepared.executeUpdate() > 0;
		prepared.close();
		this.con.desconectar();

		return rowElimined;
	}
	
	public List<Estamento> list() throws SQLException {
		List<Estamento> list = new ArrayList<>();

		this.con.conectar();
		this.conection = this.con.conectar();

		Statement statement = this.conection.createStatement();
		ResultSet rs = statement.executeQuery( LISTAR_ESTAMENTO_SQL );

		while (rs.next()) {
			
			
			Integer id = rs.getInt("id");
			Integer eleccion = rs.getInt("eleccion");
			String descripcion = rs.getString("descripcion");
			
			
			

			Estamento v = new Estamento(id, eleccion,descripcion);
			list.add(v);
		}

		this.con.desconectar();

		return list;
	}

	

}
