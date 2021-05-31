package co.edu.ufps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import co.edu.ufps.model.Candidato;
import co.edu.ufps.util.Conexion;

public class VotanteDao {
	private Conexion con;
	private Connection conection;
	private static final String INSERTAR_VOTANTE_SQL = "INSERT INTO votante(id,documento,nombre,apellido,eleccion,numero) VALUES (?,?,?,?,?,?)";
	private static final String ELIMINAR_VOTANTE_SQL = "DELETE FROM votante WHERE id=?";
	private static final String ACTUALIZAR_VOTANTE_SQL = "UPDATE votante SET documento=?,nombre=?,apellido=?,eleccion=?,numero=? WHERE id=?";
	private static final String BUSCAR_VOTANTE_SQL = "SELECT * FROM votante WHERE id=?";
	private static final String LISTAR_VOTANTE_SQL = "SELECT * FROM votante";

	public VotanteDao() throws SQLException {
		this.con = new Conexion();
	}

	public boolean insertar(Candidato c)throws SQLException {
		boolean rowInserted = false;

		this.con.conectar();
		this.conection = this.con.conectar();

		PreparedStatement prepared = this.conection.prepareStatement(INSERTAR_VOTANTE_SQL);
		prepared.setInt(1, c.getId());
		prepared.setString(2, c.getDocumento());
		prepared.setString(3, c.getNombre());
		prepared.setString(4, c.getApellido());
		prepared.setInt(5, c.getEleccion());
		prepared.setInt(6, c.getNumero());

		rowInserted = prepared.executeUpdate() > 0;
		prepared.close();
		this.con.desconectar();

		return rowInserted;
	}

	public boolean actualizar(Candidato c)  throws SQLException {
		boolean rowElimined = false;

		this.con.conectar();
		this.conection = this.con.conectar();

		PreparedStatement prepared = this.conection.prepareStatement( ACTUALIZAR_VOTANTE_SQL);
		prepared.setInt(1, c.getId());
		prepared.setString(2, c.getDocumento());
		prepared.setString(3, c.getNombre());
		prepared.setString(4, c.getApellido());
		prepared.setInt(5, c.getEleccion());
		prepared.setInt(6, c.getNumero());

		rowElimined = prepared.executeUpdate() > 0;
		prepared.close();
		this.con.desconectar();

		return rowElimined;
	}

	public Candidato buscar(Integer id) throws SQLException {
		Candidato e = null;

		this.con.conectar();
		this.conection = this.con.conectar();

		PreparedStatement prepared = this.conection.prepareStatement(BUSCAR_VOTANTE_SQL);
		prepared.setInt(1, id);

		ResultSet rs = prepared.executeQuery();

		if (rs!=null && rs.next()) {
			
			e = new Candidato(id, rs.getString("documento"), rs.getString("nombre"), rs.getString("apellido"),
					rs.getInt("eleccion"),rs.getInt("numero"));
		}
		rs.close();
		this.con.desconectar();

		return e;
	}

	public boolean eliminar(Integer id) throws SQLException {
		boolean rowElimined = false;

		this.con.conectar();
		this.conection = this.con.conectar();

		PreparedStatement prepared = this.conection.prepareStatement(ELIMINAR_VOTANTE_SQL);
		prepared.setInt(1, id);

		rowElimined = prepared.executeUpdate() > 0;
		prepared.close();
		this.con.desconectar();

		return rowElimined;
	}
	
	public List<Candidato> list() throws SQLException {
		List<Candidato> list = new ArrayList<>();

		this.con.conectar();
		this.conection = this.con.conectar();

		Statement statement = this.conection.createStatement();
		ResultSet rs = statement.executeQuery( LISTAR_VOTANTE_SQL );

		while (rs.next()) {
			
			Integer id = rs.getInt("id");
			String documento = rs.getString("documento");
			String nombre = rs.getString("nombre");
			String apellido = rs.getString("apellido");
			Integer eleccion = rs.getInt("eleccion");
			Integer numero = rs.getInt("numero");
			
			

			Candidato c = new Candidato(id, documento, nombre, apellido, eleccion,numero);
			list.add(c);
		}

		this.con.desconectar();

		return list;
	}

}
