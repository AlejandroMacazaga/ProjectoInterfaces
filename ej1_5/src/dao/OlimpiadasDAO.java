package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import auxiliares.Olimpiada;

public class OlimpiadasDAO {
	static final private String tablename = "Olimpiada";
	
	static public ArrayList<Olimpiada> getAllOlimpiadas() throws SQLException {
		ArrayList<Olimpiada> listOlimpiadas = new ArrayList<Olimpiada>();
		ConexionDB conn = new ConexionDB();
		String sql = "select id_olimpiada, nombre, anio, temporada, ciudad from " + tablename;
		ResultSet resultado = conn.ejecutarConsulta(sql);
		while(resultado.next()) {
			listOlimpiadas.add(new Olimpiada(
					resultado.getInt("id_olimpiada"),
					resultado.getString("nombre"),
					resultado.getString("anio"),
					resultado.getString("temporada"),
					resultado.getString("ciudad")
					));
		}
		conn.cerrarConexion();
		return listOlimpiadas;
	}
	
	static public boolean removeOlimpiada(Olimpiada o) {
		String sql = "delete from " + tablename + " where id_olimpiada = ?";
		boolean success = false;
		try {
			ConexionDB conn = new ConexionDB();
			PreparedStatement ps = conn.getPreparedStatement(sql);
			ps.setInt(1, o.getId_olimpiada());
			if(ps.executeUpdate() > 0) success = true;
			ps.close();
			conn.cerrarConexion();
		}
		catch(SQLException e) {
			return false;
		}
		return success;
	}
	
	static public boolean addOlimpiada(Olimpiada o) {
		String sql = "insert into "+ tablename + " (id_olimpiada, nombre, anio, temporada, ciudad) values (?, '?', '?', '?', '?')";
		boolean success = false;
		try {
			ConexionDB conn = new ConexionDB();
			PreparedStatement ps = conn.getPreparedStatement(sql);
			ps.setInt(1, o.getId_olimpiada());
			ps.setString(2, o.getNombre());
			ps.setString(3, o.getAnio());
			ps.setString(4, o.getTemporada());
			ps.setString(5, o.getCiudad());
			if(ps.executeUpdate() > 0) success = true;
			ps.close();
			conn.cerrarConexion();
		}
		catch(SQLException e) {
			return false;
		}
		return success;
	}
	
	static public boolean modifyOlimpiada(Olimpiada o) {
		String sql = "update " + tablename + " set nombre = '?', anio = '?', temporada = '?', ciudad = '?' where id_olimpiada = ?";
		boolean success = false;
		try {
			ConexionDB conn = new ConexionDB();
			PreparedStatement ps = conn.getPreparedStatement(sql);
			ps.setString(1, o.getNombre());
			ps.setString(2, o.getAnio());
			ps.setString(3, o.getTemporada());
			ps.setString(4, o.getCiudad());
			ps.setInt(5, o.getId_olimpiada());
			if(ps.executeUpdate() > 0) success = true;
			ps.close();
			conn.cerrarConexion();
		}
		catch(SQLException e) {
			return false;
		}
		return success;
	}
}
