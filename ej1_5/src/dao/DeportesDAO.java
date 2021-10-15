package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import auxiliares.Deporte;

public class DeportesDAO {
	
		public final static String tablename = "Deporte";
		
		public static ArrayList<Deporte> getAllDeportes() {
			ArrayList<Deporte> listDeportes = new ArrayList<Deporte>();
			try  {
				ConexionDB conn = new ConexionDB();
				String sql = "select id_deporte, nombre from " + tablename;
				ResultSet resultado = conn.ejecutarConsulta(sql);
				while(resultado.next()) {
					listDeportes.add(new Deporte(resultado.getInt("id_deporte"), resultado.getString("nombre")));
				}
				resultado.close();
				conn.cerrarConexion();
			} catch(SQLException ex) {
				
			}
			System.out.println(listDeportes.toString());
			return listDeportes;
		}
		
		public static Deporte getDeporte(int id_deporte) throws SQLException {
			Deporte d = null;
			ConexionDB conn = new ConexionDB();
			String sql = "select nombre from " + tablename + " where id_deporte = " + id_deporte;
			ResultSet resultado = conn.ejecutarConsulta(sql);
			while(resultado.next()) {
				d = new Deporte(
						id_deporte,
						resultado.getString("nombre"));
			}
			resultado.close();
			conn.cerrarConexion();
			return d;
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
			System.out.println("Terminada");
			String sql = "insert into " + tablename + " (nombre) values (?)";
			System.out.println(sql);
			boolean success = false;
			try {
				ConexionDB conn = new ConexionDB();
				System.out.println("Conexion creada");
				PreparedStatement ps = conn.getPreparedStatement(sql);
				System.out.println("Statement creado");
				ps.setString(1, d.getNombre());
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
		
		public static boolean modifyDeporte(Deporte d) {
			String sql = "update " + tablename + " set nombre = ? where id_deporte = ?";
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
