package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexion.Conexion;

public class PerfilUsuarioDao {

	
	
	public boolean verificarContrasenia(String contraseniaActual){
		
		boolean verificacion = false;
		String valor = "";
		
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;
		
		connection = conexion.getConexion();
		
		String consulta = "SELECT contraseniaUsuario FROM usuario WHERE contraseniaUsuario LIKE ?";
		
		System.out.println("Valor de la variable contraseniaActual = " + contraseniaActual);
		
		try {
			
			statement = connection.prepareStatement(consulta);
			statement.setString(1, contraseniaActual);
			
			result = statement.executeQuery();			
			
			while(result.next()){
				
				valor = result.getString("contraseniaUsuario");
			
			}
			
			System.out.println("el contenido de la variable valor " + valor);
			
		
			if(valor.equals("")){
				System.out.println("No se encuentra la contrasenia en la base de datos !!");
			}else{
				
				verificacion = true;
			}
			
			
		} catch (SQLException e) {
				System.out.println("error en el metodo verificarContrasenia() / PerfilUsuarioDao");
		}
		
		
		
		conexion.desconectar();
		
		return verificacion;
		
	}
	
	
	public String cambiarContrasenia(String nuevaContrasenia, String contraseniaActual){
		
		System.out.println("estamos en ele metodo cambiarContrasenia() / PerfilUsuarioDao ");
		
		String resultado = "";
		
		System.out.println("Valor de la ContraseniaActual = " + contraseniaActual);
		System.out.println("Valor de la nuevaContrasenia = " + nuevaContrasenia);
		
		
		
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		
		connection = miConexion.getConexion();
		
		
		String consulta = "UPDATE usuario SET contraseniaUsuario = ? WHERE contraseniaUsuario = ?";
		
		try {
			statement = connection.prepareStatement(consulta);
			statement.setString(1, nuevaContrasenia);
			statement.setString(2, contraseniaActual);
			statement.executeUpdate();
			
			
		resultado = "ok";	
			
		} catch (SQLException e) {
			
			System.out.println("Error en el metodo cambiarContrasenia() / PerfilUsuarioDao ");

			System.out.println("Mensjase de la base de datos -----> " + e.getMessage());
		}
		
		miConexion.desconectar();
		
		
		return resultado;
		
	}
	
	
	
	
	
	public String guardarDocumento(String documento){
		
		String resultado = "";
		
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		
		connection = miConexion.getConexion();
		
		
			String consulta = "UPDATE seccionUsuario SET documentoSeccion = ?;";
		
		try {
			statement = connection.prepareStatement(consulta);
			statement.setString(1, documento);
			statement.executeUpdate();
			
			
		resultado = "ok";	
			
		} catch (SQLException e) {
			
			System.out.println("Error en el metodo cambiarContrasenia() / PerfilUsuarioDao ");

			System.out.println("Mensjase de la base de datos -----> " + e.getMessage());
			
			resultado = "error";
		}
		
		miConexion.desconectar();
		
		
		return resultado;
	}
	
	
	public int traerDocumento(){
		
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;
		
		int documento = 0;
		
		connection = miConexion.getConexion();
		
		String consulta = "SELECT documentoSeccion FROM seccionUsuario;";
		
	try {
		statement = connection.prepareStatement(consulta);
		result = statement.executeQuery();
		
		
		while(result.next()){
			
			documento = result.getInt("documentoSeccion");
		}
		
		
	} catch (SQLException e) {
		
		System.out.println("Error en el metodo cambiarContrasenia() / PerfilUsuarioDao ");

		System.out.println("Mensjase de la base de datos -----> " + e.getMessage());
		
	}
	
	miConexion.desconectar();
			
		
		
		
		
		return documento;
	}
	
	
	
	
}
