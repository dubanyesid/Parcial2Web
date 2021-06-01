package co.edu.ufps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import co.edu.ufps.model.TipoDocumento;
import co.edu.ufps.model.Votante;
import co.edu.ufps.util.Conexion;

public class TipoDocumentoDao implements GenericDao<TipoDocumento, Integer>{
	private Conexion con;
	private Connection conection;
	private static final String INSERTAR_TIPODOCUMENTO_SQL = "INSERT INTO votante(id,documento,nombre,apellido,eleccion,numero) VALUES (?,?,?,?,?,?)";
	private static final String ELIMINAR_TIPODOCUMENTO_SQL = "DELETE FROM votante WHERE id=?";
	private static final String ACTUALIZAR_TIPODOCUMENTO_SQL = "UPDATE votante SET documento=?,nombre=?,apellido=?,eleccion=?,numero=? WHERE id=?";
	private static final String BUSCAR_TIPODOCUMENTO_SQL = "SELECT * FROM votante WHERE id=?";
	private static final String LISTAR_TIPODOCUMENTO_SQL = "SELECT * FROM votante";

	public TipoDocumentoDao() throws SQLException {
		this.con = new Conexion();
	}

	public boolean insertar(TipoDocumento t)throws SQLException {
		boolean rowInserted = false;

		this.con.conectar();
		this.conection = this.con.conectar();

		PreparedStatement prepared = this.conection.prepareStatement(INSERTAR_TIPODOCUMENTO_SQL );
		prepared.setInt(1, t.getId());
		prepared.setString(2, t.getDescripcion());
		

		rowInserted = prepared.executeUpdate() > 0;
		prepared.close();
		this.con.desconectar();

		return rowInserted;
	}

	public boolean actualizar(TipoDocumento t)  throws SQLException {
		boolean rowElimined = false;

		this.con.conectar();
		this.conection = this.con.conectar();

		PreparedStatement prepared = this.conection.prepareStatement(ACTUALIZAR_TIPODOCUMENTO_SQL );
		prepared.setInt(1, t.getId());
		prepared.setString(2, t.getDescripcion());
		
		
		rowElimined = prepared.executeUpdate() > 0;
		prepared.close();
		this.con.desconectar();

		return rowElimined;
	}

	public TipoDocumento buscar(Integer id) throws SQLException {
		TipoDocumento e = null;

		this.con.conectar();
		this.conection = this.con.conectar();

		PreparedStatement prepared = this.conection.prepareStatement(BUSCAR_TIPODOCUMENTO_SQL);
		prepared.setInt(1, id);

		ResultSet rs = prepared.executeQuery();

		if (rs!=null && rs.next()) {
			
			e = new TipoDocumento(id, rs.getString("descripcion"));
		}
		rs.close();
		this.con.desconectar();

		return e;
	}

	public boolean eliminar(Integer id) throws SQLException {
		boolean rowElimined = false;

		this.con.conectar();
		this.conection = this.con.conectar();

		PreparedStatement prepared = this.conection.prepareStatement(ELIMINAR_TIPODOCUMENTO_SQL );
		prepared.setInt(1, id);

		rowElimined = prepared.executeUpdate() > 0;
		prepared.close();
		this.con.desconectar();

		return rowElimined;
	}
	
	public List<TipoDocumento> list() throws SQLException {
		List<TipoDocumento> list = new ArrayList<>();

		this.con.conectar();
		this.conection = this.con.conectar();

		Statement statement = this.conection.createStatement();
		ResultSet rs = statement.executeQuery( LISTAR_TIPODOCUMENTO_SQL);

		while (rs.next()) {
			
			Integer id = rs.getInt("id");
			String descripcion = rs.getString("descripcion");
		
			TipoDocumento t = new TipoDocumento(id,descripcion);
			list.add(t);
		}

		this.con.desconectar();

		return list;
	}
}
