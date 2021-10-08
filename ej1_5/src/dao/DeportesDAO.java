package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import auxiliares.Deporte;

public class DeportesDAO {
	
		public final static String tablename = "Deporte";
		
		public static ArrayList<Deporte> getAllDeportes() throws SQLException {
			ArrayList<Deporte> listDeportes = new ArrayList<Deporte>();
			ConexionDB conn = new ConexionDB();
			String sql = "select id_deporte, nombre from " + tablename;
			ResultSet resultado = conn.ejecutarConsulta(sql);
			while(resultado.next()) {
				listDeportes.add(new Deporte(resultado.getInt("id_deporte"), resultado.getString("nombre")));
			}
			conn.cerrarConexion();
			return listDeportes;
		}
		
		public static boolean removeDeporte(Deporte d) {
			String sql = "delete from " + tablename + " where id_deporte = ?";
			boolean success = false;
			try {
				ConexionDB conn = new ConexionDB();
				PreparedStatement ps = conn.getPreparedStatement(sql);
				ps.setInt(1, d.getId_deporte());
				if(ps.executeUpdate() > 0) success = true;
				ps.close();
				conn.cerrarConexion();
			}
			catch(SQLException e) {
				return false;
			}
			return success;
		}
		
		public static boolean addDeporte(Deporte d) {
			String sql = "insert into " + tablename + " (id_deporte, nombre) values (?, '?')";
			boolean success = false;
			try {
				ConexionDB conn = new ConexionDB();
				PreparedStatement ps = conn.getPreparedStatement(sql);
				ps.setInt(1, d.getId_deporte());
				ps.setString(2, d.getNombre());
				if(ps.executeUpdate() > 0) success = true;
				ps.close();
				conn.cerrarConexion();
			}
			catch(SQLException e) {
				return false;
			}
			return success;
		}
		
		public static boolean modifyDeporte(Deporte d) {
			String sql = "update " + tablename + " set nombre = '?' where id_deporte = ?";
			boolean success = false;
			try {
				ConexionDB conn = new ConexionDB();
				PreparedStatement ps = conn.getPreparedStatement(sql);
				ps.setString(1, d.getNombre());
				ps.setInt(2, d.getId_deporte());
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
