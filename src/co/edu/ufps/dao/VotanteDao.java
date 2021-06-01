package co.edu.ufps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import co.edu.ufps.model.Candidato;
import co.edu.ufps.model.Votante;
import co.edu.ufps.util.Conexion;

public class VotanteDao implements GenericDao<Votante, Integer> {
	private Conexion con;
	private Connection conection;
	private static final String INSERTAR_VOTANTE_SQL = "INSERT INTO votante(id,documento,nombre,apellido,eleccion,numero) VALUES (?,?,?,?,?,?)";
	private static final String ELIMINAR_VOTANTE_SQL = "DELETE FROM votante WHERE id=?";
	private static final String ACTUALIZAR_VOTANTE_SQL = "UPDATE votante SET nombre=?,email=?,documento=?,tipodocumento=?,eleccion=? WHERE id=?";
	private static final String BUSCAR_VOTANTE_SQL = "SELECT * FROM votante WHERE id=?";
	private static final String LISTAR_VOTANTE_SQL = "SELECT * FROM votante";

	public VotanteDao() throws SQLException {
		this.con = new Conexion();
	}

	public boolean insertar(Votante v)throws SQLException {
		boolean rowInserted = false;

		this.con.conectar();
		this.conection = this.con.conectar();

		PreparedStatement prepared = this.conection.prepareStatement(INSERTAR_VOTANTE_SQL);
		prepared.setInt(1, v.getId());
		prepared.setString(2, v.getNombre());
		prepared.setString(3, v.getEmail());
		prepared.setString(4, v.getDocumento());
		prepared.setInt(5, v.getTipoDocumento());
		prepared.setInt(6, v.getEleccion());

		rowInserted = prepared.executeUpdate() > 0;
		prepared.close();
		this.con.desconectar();

		return rowInserted;
	}

	public boolean actualizar(Votante v)  throws SQLException {
		boolean rowElimined = false;

		this.con.conectar();
		this.conection = this.con.conectar();

		PreparedStatement prepared = this.conection.prepareStatement( ACTUALIZAR_VOTANTE_SQL);
		prepared.setInt(1, v.getId());
		prepared.setString(2, v.getNombre());
		prepared.setString(3, v.getEmail());
		prepared.setString(4, v.getDocumento());
		prepared.setInt(5, v.getTipoDocumento());
		prepared.setInt(6, v.getEleccion());
		rowElimined = prepared.executeUpdate() > 0;
		prepared.close();
		this.con.desconectar();

		return rowElimined;
	}

	public Votante buscar(Integer id) throws SQLException {
		Votante e = null;

		this.con.conectar();
		this.conection = this.con.conectar();

		PreparedStatement prepared = this.conection.prepareStatement(BUSCAR_VOTANTE_SQL);
		prepared.setInt(1, id);

		ResultSet rs = prepared.executeQuery();

		if (rs!=null && rs.next()) {
			
			e = new Votante(id, rs.getString("nombre"), rs.getString("email"), rs.getString("documento"),
					rs.getInt("tipodocumento"),rs.getInt("eleccion"));
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
	
	public List<Votante> list() throws SQLException {
		List<Votante> list = new ArrayList<>();

		this.con.conectar();
		this.conection = this.con.conectar();

		Statement statement = this.conection.createStatement();
		ResultSet rs = statement.executeQuery( LISTAR_VOTANTE_SQL );

		while (rs.next()) {
			
			Integer id = rs.getInt("id");
			String nombre = rs.getString("nombre");
			String email = rs.getString("email");
			String documento = rs.getString("documento");
			Integer tipoDocumento = rs.getInt("tipodocumento");
			Integer eleccion = rs.getInt("eleccion");
			
			

			Votante v = new Votante(id, nombre, email, documento,tipoDocumento, eleccion);
			list.add(v);
		}

		this.con.desconectar();

		return list;
	}

}
