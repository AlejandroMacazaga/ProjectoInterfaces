package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import auxiliares.Evento;

public class EventosDAO {
	private final static String tablename = "Evento";
	
	public static ArrayList<Evento> getAllEventos() {
		ArrayList<Evento> listEventos = new ArrayList<Evento>();
		try {
			ConexionDB conn = new ConexionDB();
			String sql = "select id_evento, nombre, id_olimpiada, id_deporte from " + tablename;
			PreparedStatement ps = conn.getPreparedStatement(sql);
			ResultSet resultado = ps.executeQuery();
			while(resultado.next()) {
				listEventos.add(new Evento(
						resultado.getInt("id_evento"),
						OlimpiadasDAO.getOlimpiada(resultado.getInt("id_olimpiada")),
						DeportesDAO.getDeporte(resultado.getInt("id_deporte")),
						resultado.getString("nombre")));
			}
			ps.close();
			resultado.close();
			conn.cerrarConexion();
		} catch(SQLException ex) {
				
		}
		System.out.println(listEventos.toString());
		return listEventos;
	}
	
	public static Evento getEvento(int id_evento) throws SQLException {
		Evento e = null;
		ConexionDB conn = new ConexionDB();
		String sql = "select id_olimpiada, id_deporte, nombre from " + tablename + " where id_evento = ?";
		PreparedStatement ps = conn.getPreparedStatement(sql);
		ps.setInt(1, id_evento);
		ResultSet resultado = ps.executeQuery();
		if(resultado.next()) {
			e = new Evento(
					id_evento,
					OlimpiadasDAO.getOlimpiada(resultado.getInt("id_olimpiada")),
					DeportesDAO.getDeporte(resultado.getInt("id_deporte")),
					resultado.getString("nombre"));
		}
		ps.close();
		resultado.close();
		conn.cerrarConexion();
		return e;
	}
	
	public static boolean removeEvento(Evento e) {
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
	
	public static boolean addEvento(Evento e) {
		String sql = "insert into "+ tablename + " (nombre, id_olimpiada, id_deporte) values (?, ?, ?)";
		boolean success = false;
		try {
			ConexionDB conn = new ConexionDB();
			PreparedStatement ps = conn.getPreparedStatement(sql);
			ps.setString(1, e.getNombre());
			ps.setInt(2, e.getOlimpiada().getId_olimpiada());
			ps.setInt(3, e.getDeporte().getId_deporte());
			if(ps.executeUpdate() > 0) success = true;
			ps.close();
			conn.cerrarConexion();
		}
		catch(SQLException ex) {
			return false;
		}
		return success;
	}
	
	public static boolean modifyEvento(Evento e) {
		String sql = "update " + tablename + " set nombre = ?, id_olimpiada = ?, id_deporte = ?  where id_evento = ?";
		boolean success = false;
		try {
			ConexionDB conn = new ConexionDB();
			PreparedStatement ps = conn.getPreparedStatement(sql);
			ps.setString(1, e.getNombre());
			ps.setInt(2, e.getOlimpiada().getId_olimpiada());
			ps.setInt(3, e.getDeporte().getId_deporte());
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

