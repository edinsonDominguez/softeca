package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexion.Conexion;
import vo.Categoria;

public class CategoriaDao {

public Categoria hallarCategoria(int codigoCategoria){
		
		
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;
		ResultSet result = null;
				
		
		Categoria miCategoria = null;
		
		connection = conexion.getConexion();
		
		String consulta = "SELECT * FROM categoria WHERE codCategoria = ?";
		
		try {
			
			preStatement =connection.prepareStatement(consulta);
			preStatement.setInt(1, codigoCategoria); 
			result = preStatement.executeQuery();
			
			
			while(result.next()){
				
				miCategoria = new Categoria();
				miCategoria.setCodigo(result.getInt("codCategoria"));
				miCategoria.setNombre(result.getString("nombreCategoria"));
				
			}
			
			
		} catch (SQLException e) {
		
			System.out.println("Error en UsuarioDao " + e.getMessage());
			
		}
		
		conexion.desconectar();
		
		return miCategoria;
	}

	public Categoria HallarCategoriaNombre(int numCategoria){
		
		Connection connection = null;
		Conexion conexion =  new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;
		
		Categoria miCategoria = null;
		
		connection = conexion.getConexion();
		
		String consulta = "SELECT * FROM categoria WHERE codCategoria = ?";
		
		try {
			
			statement = connection.prepareStatement(consulta);
			statement.setInt(1, numCategoria);
			result = statement.executeQuery();
			
			
			while(result.next()){
				
				miCategoria = new Categoria();
				miCategoria.setCodigo(result.getInt("codCategoria"));
				miCategoria.setNombre(result.getString("nombreCategoria"));
			}
			
			
			
		} catch (SQLException e) {
		
			System.out.println("Error en el metodo HallarCategoriaNombre()/CategoriaDao");
		}
		
		conexion.desconectar();
		
		return miCategoria;
		
	}
	
	
	public String buscarNombreCategoria(int codCategoria){
		
		String nombreCategoria = "";
		
		
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement statement  = null;
		ResultSet result = null;
		
		
		
		connection = conexion.getConexion();
		
		String consulta = "SELECT nombreCategoria FROM categoria WHERE codCategoria = ?";
		
		try {
			
			statement = connection.prepareStatement(consulta);
			statement.setInt(1, codCategoria);
			result = statement.executeQuery();
			
			while (result.next()){
				
				nombreCategoria = result.getString("nombreCategoria");
			}
			
		} catch (SQLException e) {
			
			System.out.println("Error en el metodo buscarNombreCategoria()/CategoriaDao");
			
		}
		
		return nombreCategoria;
		
	}
	

	
	
	
}
