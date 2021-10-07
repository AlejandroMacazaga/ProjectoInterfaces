package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import auxiliares.Evento;

public class EventosDAO {
	static final private String tablename = "Evento";
	
	static public ArrayList<Evento> getAllEventos() throws SQLException {
		ArrayList<Evento> listDeportistas = new ArrayList<Evento>();
		ConexionDB conn = new ConexionDB();
		String sql = "select id_evento, nombre, id_olimpiada, id_deporte from " + tablename;
		ResultSet resultado = conn.ejecutarConsulta(sql);
		while(resultado.next()) {
			listDeportistas.add(new Evento(
					resultado.getInt("id_evento"),
					resultado.getInt("id_olimpiada"),
					resultado.getInt("id_deporte"),
					resultado.getString("nombre")));
		}
		conn.cerrarConexion();
		return listDeportistas;
	}
	
	static public boolean removeEvento(Evento e) {
		String sql = "delete from " + tablename + " where id_evento = ?";
		boolean success = false;
		try {
			ConexionDB conn = new ConexionDB();
			PreparedStatement ps = conn.getPreparedStatement(sql);
			ps.setInt(1, e.getId_evento());
			if(ps.executeUpdate() > 0) success = true;
			ps.close();
			conn.cerrarConexion();
		}
		catch(SQLException ex) {
			return false;
		}
		return success;
	}
	
	static public boolean addEvento(Evento e) {
		String sql = "insert into "+ tablename + " (id_evento, nombre, id_olimpiada, id_deporte) values (?, '?', ?, ?)";
		boolean success = false;
		try {
			ConexionDB conn = new ConexionDB();
			PreparedStatement ps = conn.getPreparedStatement(sql);
			ps.setInt(1, e.getId_evento());
			ps.setString(2, e.getNombre());
			ps.setInt(3, e.getId_olimpiada());
			ps.setInt(4, e.getId_deporte());
			if(ps.executeUpdate() > 0) success = true;
			ps.close();
			conn.cerrarConexion();
		}
		catch(SQLException ex) {
			return false;
		}
		return success;
	}
	
	static public boolean modifyEvento(Evento e) {
		String sql = "update " + tablename + " set nombre = '?', id_olimpiada = ?, id_deporte = ?  where id_evento = ?";
		boolean success = false;
		try {
			ConexionDB conn = new ConexionDB();
			PreparedStatement ps = conn.getPreparedStatement(sql);
			ps.setString(1, e.getNombre());
			ps.setInt(2, e.getId_olimpiada());
			ps.setInt(3, e.getId_deporte());
			ps.setInt(4, e.getId_evento());
			if(ps.executeUpdate() > 0) success = true;
			ps.close();
			conn.cerrarConexion();
		}
		catch(SQLException ex) {
			return false;
		}
		return success;
	}
}