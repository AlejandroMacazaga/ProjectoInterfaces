package dao;

import java.sql.*;
import java.util.TimeZone;

public class MySQLDAO {
	private Connection conn;
	
	public MySQLDAO() throws SQLException {
        String user = "admin";
        String password = "password";
        String strConn = "jdbc:mysql://" + host + "?serverTimezone=" + TimeZone.getDefault().getID();
        conn = DriverManager.getConnection(strConn, user, password);
        conn.setAutoCommit(true);
	}
	
	public Error createDatabase(String fileRoute) {
		Error err = new Error();
		try {
			// Creamos la base de datos, en caso de ya existir la borramos primero
			String strCreateDB = "CREATE DATABASE ATLETAS";
			PreparedStatement ps = conn.prepareStatement(strCreateDB);
			if(ps.executeUpdate() != 1) {
				String strRemoveDB = "DELETE DATABASE ATLETAS";
				PreparedStatement ps2 = conn.prepareStatement(strRemoveDB);
				ps2.executeQuery();
				ps2.close();
				ps.executeUpdate();
			}
			ps.close();
			
			
			
		} catch(SQLException ex) {
			
		}
		return err;
		
	}
}
