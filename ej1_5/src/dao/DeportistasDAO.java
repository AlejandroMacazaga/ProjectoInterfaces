package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import auxiliares.Deportista;

public class DeportistasDAO {
	private final static String tablename = "Deportista";
	
	public static ArrayList<Deportista> getAllDeportistas() {
		ArrayList<Deportista> listDeportistas = new ArrayList<Deportista>();
		try {
			ConexionDB conn = new ConexionDB();
			String sql = "select id_deportista, nombre, sexo, peso, altura from " + tablename;
			PreparedStatement ps = conn.getPreparedStatement(sql);
			ResultSet resultado = ps.executeQuery();
			while(resultado.next()) {
				listDeportistas.add(new Deportista(
						resultado.getInt("id_deportista"), 
						resultado.getString("nombre"),
						resultado.getString("sexo").charAt(0),
						resultado.getInt("peso"),
						resultado.getInt("altura")));
			}
			ps.close();
			resultado.close();
			conn.cerrarConexion();
		}catch(SQLException ex) {
			
		}
		System.out.println(listDeportistas.toString());
		return listDeportistas;
	}
	
	public static Deportista getDeportista(int id_deportista) throws SQLException {
		Deportista d = null;
		ConexionDB conn = new ConexionDB();
		String sql = "select nombre, sexo, peso, altura from " + tablename + " where id_deportista = ?";
		PreparedStatement ps = conn.getPreparedStatement(sql);
		ps.setInt(1,id_deportista);
		ResultSet resultado = ps.executeQuery();
		if(resultado.next()) {
			d = new Deportista(
					id_deportista,
					resultado.getString("nombre"),
					resultado.getString("sexo").charAt(0),
					resultado.getInt("peso"),
					resultado.getInt("altura"));
		}
		ps.close();
		resultado.close();
		conn.cerrarConexion();
		return d;
	}
	
	public static boolean removeDeportista(Deportista d) {
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
	
	public static boolean addDeportista(Deportista d) {
		String sql = "insert into "+ tablename + " (nombre, sexo, peso, altura) values (?, ?, ?, ?)";
		boolean success = false;
		try {
			ConexionDB conn = new ConexionDB();
			PreparedStatement ps = conn.getPreparedStatement(sql);
			ps.setString(1, d.getNombre());
			ps.setString(2, d.getSexo() + "");
			ps.setInt(3, d.getPeso());
			ps.setInt(4, d.getAltura());
			if(ps.executeUpdate() > 0) success = true;
			ps.close();
			conn.cerrarConexion();
		}
		catch(SQLException e) {
			return false;
		}
		return success;
	}
	
	public static boolean modifyDeportista(Deportista d) {
		String sql = "update " + tablename + " set nombre = ?, sexo = ?, peso = ?, altura = ? where id_deportista = ?";
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

