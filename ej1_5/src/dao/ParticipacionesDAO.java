package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import auxiliares.Participacion;

public class ParticipacionesDAO {
static final private String tablename = "Participacion";
	
	static public ArrayList<Participacion> getAllParticipaciones() {
		ArrayList<Participacion> listParticipaciones = new ArrayList<Participacion>();
		try {
			ConexionDB conn = new ConexionDB();
			String sql = "select id_deportista, id_evento, id_equipo, edad, medalla from " + tablename;
			PreparedStatement ps = conn.getPreparedStatement(sql);
			ResultSet resultado = ps.executeQuery();
			while(resultado.next()) {
				listParticipaciones.add(new Participacion(
						EventosDAO.getEvento(resultado.getInt("id_evento")),
						DeportistasDAO.getDeportista(resultado.getInt("id_deportista")),
						EquiposDAO.getEquipo(resultado.getInt("id_equipo")),
						resultado.getInt("edad"),
						resultado.getString("medalla")));
			}
			ps.close();
			resultado.close();
			conn.cerrarConexion();
		} catch(SQLException ex) {
			
		}
		System.out.println(listParticipaciones.toString());
		return listParticipaciones;
	}
	
	static public boolean removeParticipacion(Participacion p) {
		String sql = "delete from " + tablename + " where id_deportista = ? and id_evento = ? and id_equipo = ?";
		boolean success = false;
		try {
			ConexionDB conn = new ConexionDB();
			PreparedStatement ps = conn.getPreparedStatement(sql);
			ps.setInt(1, p.getDeportista().getId_deportista());
			ps.setInt(2, p.getEvento().getId_evento());
			ps.setInt(3, p.getEquipo().getId_equipo());
			if(ps.executeUpdate() > 0) success = true;
			ps.close();
			conn.cerrarConexion();
		}
		catch(SQLException ex) {
			return false;
		}
		return success;
	}
	
	static public boolean addParticipacion(Participacion p) {
		String sql = "insert into "+ tablename + " (id_deportista, id_evento, id_equipo, edad, medalla) values (?, ?, ?, ?, ?)";
		boolean success = false;
		try {
			ConexionDB conn = new ConexionDB();
			PreparedStatement ps = conn.getPreparedStatement(sql);
			ps.setInt(1, p.getDeportista().getId_deportista());
			ps.setInt(2, p.getEvento().getId_evento());
			ps.setInt(3, p.getEquipo().getId_equipo());
			ps.setInt(4, p.getEdad());
			ps.setString(5, p.getMedalla());
			if(ps.executeUpdate() > 0) success = true;
			ps.close();
			conn.cerrarConexion();
		}
		catch(SQLException ex) {
			return false;
		}
		return success;
	}
	
	static public boolean modifyParticipacion(Participacion p) {
		String sql = "update " + tablename + " set edad = ?, medalla = ? where id_deportista = ? and id_evento = ? and id_equipo = ?";
		boolean success = false;
		try {
			ConexionDB conn = new ConexionDB();
			PreparedStatement ps = conn.getPreparedStatement(sql);
			ps.setInt(1, p.getEdad());
			ps.setString(2, p.getMedalla());
			ps.setInt(3, p.getDeportista().getId_deportista());
			ps.setInt(4, p.getEvento().getId_evento());
			ps.setInt(5, p.getEquipo().getId_equipo());
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

