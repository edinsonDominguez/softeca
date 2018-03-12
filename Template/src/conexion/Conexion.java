package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {


	private String nombreBD = "softeca";
	private String usuario = "root";
	private String password = "edinson17861";
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

=======
import java.sql.*;

public class Conexion {
	private String nombreBd="softeca";
	private String usuario="root";
	private String password="usbw";
	private String url="jdbc:mysql://localhost:3306/"+nombreBd;

	Connection conn=null;
	//constructor de la clase
	
	public Conexion(){
		try {
			//obtener el driver
			//driver verfificar si este esta funcionando
			Class.forName("com.mysql.jdbc.Driver");
			//obtener la conexion
			//verificar este paso
			conn=DriverManager.getConnection(url,usuario,password);
			if (conn!=null) {
				System.out.println("Conexion Exitosa  a la BD: "+nombreBd);
			}else{
				System.out.println("******************NO SE PUDO CONECTAR "+nombreBd);
			}
		}
		catch (ClassNotFoundException e) {
			System.out.println("ocurre una ClassNotFoundException : "+e.getMessage());
		} catch (SQLException e) {
			System.out.println("ocurre una SQLException: "+e.getMessage());
			System.out.println("Verifique que Mysql esté encendido...");
		}
	}
	public Connection getConnection(){
		return conn;
	}
	public void desconectar(){
		conn=null;
	}
}

