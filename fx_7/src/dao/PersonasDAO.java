package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import aux.Person;

public class PersonasDAO {
	public final static String tablename = "persona";
	
	public static ArrayList<Person> getAllPersons() {
		ArrayList<Person> listPersons = new ArrayList<Person>();
		try  {
			ConexionDB conn = new ConexionDB();
			
			String sql = "select id_persona, nombre, apellidos, edad from " + tablename;
			PreparedStatement ps = conn.getPreparedStatement(sql);
			ResultSet resultado = ps.executeQuery();
			while(resultado.next()) {
				listPersons.add(new Person(resultado.getInt("id_persona"), resultado.getString("nombre"), resultado.getString("apellidos"), resultado.getInt("edad")));
			}
			resultado.close();
			conn.cerrarConexion();
		} catch(SQLException ex) {
			
		}
		System.out.println(listPersons.size());
		return listPersons;
	}
	
	public static Person getPerson(int id_persona) throws SQLException {
		Person d = null;
		ConexionDB conn = new ConexionDB();
		String sql = "select id_persona, nombre, apellidos, edad from " + tablename + " where id_persona = ?";
		PreparedStatement ps = conn.getPreparedStatement(sql);
		ps.setInt(1, id_persona);
		ResultSet resultado = ps.executeQuery();
		while(resultado.next()) {
			d = new Person(resultado.getInt("id_persona"), resultado.getString("name"), resultado.getString("apellidos"), resultado.getInt("edad"));
		}
		ps.close();
		resultado.close();
		conn.cerrarConexion();
		return d;
	}
	
	public static boolean removePerson(Person d) {
		String sql = "delete from " + tablename + " where id_persona = ?";
		boolean success = false;
		try {
			ConexionDB conn = new ConexionDB();
			PreparedStatement ps = conn.getPreparedStatement(sql);
			ps.setInt(1, d.getId());
			if(ps.executeUpdate() > 0) success = true;
			ps.close();
			conn.cerrarConexion();
		}
		catch(SQLException e) {
			return false;
		}
		return success;
	}
	
	public static boolean addPerson(Person d) {
		String sql = "insert into " + tablename + " (nombre, apellidos, edad) values (?, ?, ?)";
		System.out.println(sql);
		boolean success = false;
		try {
			ConexionDB conn = new ConexionDB();
			System.out.println("Conexion creada");
			PreparedStatement ps = conn.getPreparedStatement(sql);
			System.out.println("Statement creado");
			ps.setString(1, d.getName());
			ps.setString(2, d.getSurname());
			ps.setInt(3, d.getAge());
			System.out.println("Statement preparado");
			if(ps.executeUpdate() > 0) success = true;
			System.out.println("Update ejecutada");
			ps.close();
			conn.cerrarConexion();
		}
		catch(SQLException e) {
			System.out.println("ERROR DE SQL");
			e.printStackTrace();
			return false;
		}
		return success;
	}
	
	public static boolean modifyPerson(Person d) {
		String sql = "update " + tablename + " set nombre = ?, apellidos = ?, edad = ? where id_persona = ?";
		boolean success = false;
		try {
			ConexionDB conn = new ConexionDB();
			PreparedStatement ps = conn.getPreparedStatement(sql);
			ps.setString(1, d.getName());
			ps.setString(2, d.getSurname());
			ps.setInt(3, d.getAge());
			ps.setInt(4, d.getId());
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
