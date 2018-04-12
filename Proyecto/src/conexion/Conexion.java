package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {


	private String nombreBD = "softeca";
	private String usuario = "root";
	private String password = "softeca";
	private String url = "jdbc:mysql://localhost:3306/" + nombreBD;
	Connection conn = null;
	
	public Conexion(){
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(url,usuario,password);
				
			if(conn != null){
				System.out.println("La conexion a la BD exitosa !!");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			
		}catch (SQLException e){
			System.out.println(e.getMessage());
			System.out.println("Verifique si mysql esta encendido !!");
			
				}
	}
	
	public Connection getConexion(){
		return conn;
	}
	
	public void desconectar(){
		conn = null;
	}
	

	
}

