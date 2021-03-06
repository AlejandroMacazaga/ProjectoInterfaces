package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import auxiliares.Deportista;
import auxiliares.Equipo;
import auxiliares.Evento;

public class EquiposDAO {
	private final static String tablename = "Equipo";
	
	public static ArrayList<Equipo> getAllEquipos() {
		ArrayList<Equipo> listEquipos = new ArrayList<Equipo>();
		try {
			ConexionDB conn = new ConexionDB();
			String sql = "select id_equipo, nombre, iniciales from " + tablename;
			PreparedStatement ps = conn.getPreparedStatement(sql);
			ResultSet resultado = ps.executeQuery();
			while(resultado.next()) {
				listEquipos.add(new Equipo(resultado.getInt("id_equipo"), resultado.getString("nombre"), resultado.getString("iniciales")));
			}
			ps.close();
			resultado.close();
			conn.cerrarConexion();
		} catch(SQLException ex) {
			
		}
		System.out.println(listEquipos.toString());
		return listEquipos;
	}
	
	public static Equipo getEquipo(int id_equipo) throws SQLException {
		Equipo e = null;
		ConexionDB conn = new ConexionDB();
		String sql = "select nombre, iniciales from " + tablename + " where id_equipo = ?";
		PreparedStatement ps = conn.getPreparedStatement(sql);
		ps.setInt(1, id_equipo);
		ResultSet resultado = ps.executeQuery();
		if(resultado.next()) {
			e = new Equipo(
					id_equipo,
					resultado.getString("nombre"),
					resultado.getString("iniciales"));
		}
		ps.close();
		resultado.close();
		conn.cerrarConexion();
		return e;
	}
	
	public static boolean removeEquipo(Equipo e) {
		String sql = "delete from " + tablename + " where id_equipo = ?";
		boolean success = false;
		try {
			ConexionDB conn = new ConexionDB();
			PreparedStatement ps = conn.getPreparedStatement(sql);
			ps.setInt(1, e.getId_equipo());
			if(ps.executeUpdate() > 0) success = true;
			ps.close();
			conn.cerrarConexion();
		}
		catch(SQLException ex) {
			return false;
		}
		return success;
	}
	
	public static boolean addEquipo(Equipo e) {
		String sql = "insert into " + tablename + " (nombre, iniciales) values (?, ?)";
		boolean success = false;
		try {
			ConexionDB conn = new ConexionDB();
			PreparedStatement ps = conn.getPreparedStatement(sql);
			ps.setString(1, e.getNombre());
			ps.setString(2, e.getIniciales());
			if(ps.executeUpdate() > 0) success = true;
			ps.close();
			conn.cerrarConexion();
		}
		catch(SQLException ex) {
			return false;
		}
		return success;
	}
	
	static public boolean modifyEquipo(Equipo e) {
		String sql = "update " + tablename + " set nombre = ?, iniciales = ' where id_equipo = ?";
		boolean success = false;
		try {
			ConexionDB conn = new ConexionDB();
			PreparedStatement ps = conn.getPreparedStatement(sql);
			ps.setString(1, e.getNombre());
			ps.setString(2, e.getIniciales());
			ps.setInt(3, e.getId_equipo());
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
