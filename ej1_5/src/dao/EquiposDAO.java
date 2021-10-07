package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import auxiliares.Equipo;

public class EquiposDAO {
	static final private String tablename = "Equipo";
	
	static public ArrayList<Equipo> getAllEquipos() throws SQLException {
		ArrayList<Equipo> listEquipos = new ArrayList<Equipo>();
		ConexionDB conn = new ConexionDB();
		String sql = "select id_equipo, nombre, iniciales from " + tablename;
		ResultSet resultado = conn.ejecutarConsulta(sql);
		while(resultado.next()) {
			listEquipos.add(new Equipo(resultado.getInt("id_equipo"), resultado.getString("nombre"), resultado.getString("iniciales")));
		}
		conn.cerrarConexion();
		return listEquipos;
	}
	
	static public boolean removeEquipo(Equipo e) {
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
	
	static public boolean addDeporte(Equipo e) {
		String sql = "insert into " + tablename + " () values (?)";
		boolean success = false;
		try {
			ConexionDB conn = new ConexionDB();
			PreparedStatement ps = conn.getPreparedStatement(sql);

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
		String sql = "update " + tablename + " set nombre = '?', iniciales = '?' where id_equipo = ?";
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