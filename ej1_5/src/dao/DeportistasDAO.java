package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import auxiliares.Deportista;

public class DeportistasDAO {
	static final private String tablename = "Deportista";
	
	static public ArrayList<Deportista> getAllDeportistas() throws SQLException {
		ArrayList<Deportista> listDeportistas = new ArrayList<Deportista>();
		ConexionDB conn = new ConexionDB();
		String sql = "select id_deportista, nombre, sexo, peso, altura from " + tablename;
		ResultSet resultado = conn.ejecutarConsulta(sql);
		while(resultado.next()) {
			listDeportistas.add(new Deportista(
					resultado.getInt("id_deportista"), 
					resultado.getString("nombre"),
					resultado.getString("sexo").charAt(0),
					resultado.getInt("peso"),
					resultado.getInt("altura")));
		}
		conn.cerrarConexion();
		return listDeportistas;
	}
	
	static public boolean removeDeportista(Deportista d) {
		String sql = "delete from " + tablename + " where id_deportista = ?";
		boolean success = false;
		try {
			ConexionDB conn = new ConexionDB();
			PreparedStatement ps = conn.getPreparedStatement(sql);
			ps.setInt(1, d.getId_deportista());
			if(ps.executeUpdate() > 0) success = true;
			ps.close();
			conn.cerrarConexion();
		}
		catch(SQLException e) {
			return false;
		}
		return success;
	}
	
	static public boolean addDeportista(Deportista d) {
		String sql = "insert into "+ tablename + " (id_deportista, nombre, sexo, peso, altura) values (?, '?', '?', ?, ?)";
		boolean success = false;
		try {
			ConexionDB conn = new ConexionDB();
			PreparedStatement ps = conn.getPreparedStatement(sql);
			ps.setInt(1, d.getId_deportista());
			ps.setString(2, d.getNombre());
			ps.setString(3, d.getSexo() + "");
			ps.setInt(4, d.getPeso());
			ps.setInt(5, d.getAltura());
			if(ps.executeUpdate() > 0) success = true;
			ps.close();
			conn.cerrarConexion();
		}
		catch(SQLException e) {
			return false;
		}
		return success;
	}
	
	static public boolean modifyDeportista(Deportista d) {
		String sql = "update " + tablename + " set nombre = '?', sexo = '?', peso = ?, altura = ? where id_deportista = ?";
		boolean success = false;
		try {
			ConexionDB conn = new ConexionDB();
			PreparedStatement ps = conn.getPreparedStatement(sql);
			ps.setString(1, d.getNombre());
			ps.setString(2, d.getSexo() + "");
			ps.setInt(3, d.getPeso());
			ps.setInt(4, d.getAltura());
			ps.setInt(5, d.getId_deportista());
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
