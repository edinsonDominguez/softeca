package dao;

import java.lang.reflect.Array;


import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import conexion.Conexion;

import vo.UsuarioVo;

@ManagedBean
@ViewScoped
public class UsuarioDao {

	
	public String agregarUsuario(UsuarioVo miUsuarioVo){
		String resultado="";
		java.sql.Connection connection = null;
		Conexion conexion = new Conexion();
		java.sql.PreparedStatement preStatement = null;
		
		connection = conexion.getConexion();
		System.out.println("antes de la consulta");
		String consulta = "INSERT INTO usuario (idUsuario,nombreUsuario,apellidoUsuario,direccionUsuario,nacimientoUsuario,telefonoUsuario,contraseniaUsuario,tipoUsuario,correoUsuario)"
				+ "  VALUES (?,?,?,?,?,?,?,?,?)";
		
		System.out.println("antes de ltrycath");
		try {
			preStatement= connection.prepareStatement(consulta);
			preStatement.setString(1, miUsuarioVo.getDocumento());
			preStatement.setString(2, miUsuarioVo.getNombre());
			preStatement.setString(3, miUsuarioVo.getApellidos());
			preStatement.setString(4, miUsuarioVo.getDireccion());
			preStatement.setString(5, miUsuarioVo.getFecha());
			preStatement.setString(6, miUsuarioVo.getTelefono());
			preStatement.setString(7, miUsuarioVo.getContrasenia());
			preStatement.setInt(8, miUsuarioVo.getTipo_Usuario());
			preStatement.setString(9, miUsuarioVo.getCorreo());
		
			preStatement.execute();
			resultado="Registro exitoso";
			System.out.println("dentro de trycath");
		} catch (SQLException e) {
			System.out.println("No se pudo realizar el registro" + e.getMessage());
			resultado="No se pudo realizar el registro";
		}  
		finally {
			conexion.desconectar();
		}
		
		
		return resultado;
	}
	//revisar si es Static o no
	public ArrayList<UsuarioVo> consultarUsuario(String docUsuario){
		
		java.sql.Connection connection = null;
		Conexion conexion = new Conexion();
		java.sql.PreparedStatement preStatement = null;
		java.sql.ResultSet result = null;
		
		UsuarioVo miUsuarioVo = null;
		
		ArrayList <UsuarioVo> lista = new ArrayList<>();
		
		
		connection = conexion.getConexion();
		String consultaUsuario = "select * from usuario where idUsuario = ?";
		
		try {
			
			
				preStatement = connection.prepareStatement(consultaUsuario);
				preStatement.setString(1, docUsuario);
				
				result = preStatement.executeQuery();
				
				while(result.next()){
				    miUsuarioVo = new UsuarioVo();
					miUsuarioVo.setDocumento(result.getString("idUsuario"));
					miUsuarioVo.setNombre(result.getString("nombreUsuario"));
					miUsuarioVo.setApellidos(result.getString("apellidoUsuario"));
					miUsuarioVo.setDireccion(result.getString("direccionUsuario"));
					miUsuarioVo.setFecha(result.getString("nacimientoUsuario"));
					miUsuarioVo.setTelefono(result.getString("telefonoUsuario"));
					miUsuarioVo.setContrasenia(result.getString("contraseniaUsuario"));
					miUsuarioVo.setTipo_Usuario(result.getInt("tipoUsuario"));
					miUsuarioVo.setCorreo(result.getString("correoUsuario"));
				
					lista.add(miUsuarioVo);
					
					
				}
			
			
			
		} catch (Exception e) {
			
		}
		conexion.desconectar();
		
		return lista;
	}
	
	
	public String actualizarUsuario(UsuarioVo miUsuarioVo){
		String mensaje="";
		
		java.sql.Connection connection = null;
		Conexion miConexion = new Conexion();
		java.sql.PreparedStatement preStatement = null;
		
		connection = miConexion.getConexion();
		
		String consulta = "UPDATE usuario SET nombreUsuario = ?, apellidoUsuario = ?, direccionUsuario = ?, nacimientoUsuario = ?, telefonoUsuario = ?,  contraseniaUsuario = ?, tipoUsuario = ?, correoUsuario = ? WHERE idUsuario = ?";
		
		try {
			preStatement = connection.prepareStatement(consulta);
			

			preStatement.setString(1, miUsuarioVo.getNombre());
			preStatement.setString(2, miUsuarioVo.getApellidos());
			preStatement.setString(3, miUsuarioVo.getDireccion());
			preStatement.setString(4, miUsuarioVo.getFecha());
			preStatement.setString(5, miUsuarioVo.getTelefono());
			preStatement.setString(6, miUsuarioVo.getContrasenia());
			preStatement.setInt(7, miUsuarioVo.getTipo_Usuario());
			preStatement.setString(8, miUsuarioVo.getCorreo());
			preStatement.setString(9, miUsuarioVo.getDocumento());
			
			preStatement.executeUpdate();
			
			mensaje="ok";
			
		} catch (Exception e) {
			System.out.println("Error en la clase dao" + e.getMessage());
		}
		
		miConexion.desconectar();
		return mensaje;
	}
	
	public String eliminarUsuario (UsuarioVo miUsuarioVo){
		String mensaje="";
		
		java.sql.Connection connection = null;
		Conexion miConexion = new Conexion();
		java.sql.PreparedStatement preStatement = null;
		
		connection = miConexion.getConexion();
		
		String consulta = "DELETE FROM usuario WHERE idUsuario = ?";
		
		try {
			preStatement = connection.prepareStatement(consulta);
			preStatement.setString(1, miUsuarioVo.getDocumento());
			
			preStatement.executeUpdate();
			preStatement.close();
			
			mensaje="ok";
		} catch (Exception e) {
			System.out.println("erroren la clase dao al eliminar " + e.getMessage());
		}
		miConexion.desconectar();
		
		return mensaje;
	}
	/*
	public UsuarioVo consultarUsuarioIndividual(String documento) {
		java.sql.Connection connection = null;
		Conexion miConexion = new Conexion();
		java.sql.PreparedStatement statement = null;
		ResultSet result = null;

		UsuarioVo misuarioVo = null;

		connection = miConexion.getConnection();

		String consulta = "SELECT * FROM persona where documento = "+documento;

		try {
			if (connection != null) {
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();

				if (result.next() == true) {
					miPersona = new PersonaVo();
					miPersona.setDocumento(result.getString("documento"));
					miPersona.setNombre(result.getString("nombre"));
					miPersona.setApellido(result.getString("apellido"));
					miPersona.setEdad(result.getInt("edad"));
					miPersona.setProfesion(result.getString("profesion"));
					miPersona.setSalario(Double.parseDouble(result.getString("salario")));
					miPersona.setSexo(result.getString("sexo"));
				}

			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del usuario: " + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return miPersona;
	}*/
	
	/*public String consultaUsuario(String consIndividual){
		java.sql.Connection connection = null;
		Conexion miConexion = new Conexion();
		java.sql.PreparedStatement statement = null;
		java.sql.ResultSet result = null;
		
		UsuarioVo miUsuario = new UsuarioVo();
		ArrayList<UsuarioVo> listaPersonas = null;
		
		connection = miConexion.getConnection();
		
		String consultaInd = "SELECT * FROM usuario WHERE idUsuario = ?";
		
		try {
			if (connection != null) {
				listaPersonas = new ArrayList<>();
				statement = connection.prepareStatement(consultaInd);

				result = statement.executeQuery();

				while (result.next() == true) {
					miUsuario = new UsuarioVo();
					miUsuario.setDocumento(result.getString("idUsuario"));
					miUsuario.setNombre(result.getString("nombreUsuario"));
					miUsuario.setApellidos(result.getString("apellidoUsuario"));
					miUsuario.setDireccion(result.getString("direccionUsuario"));
					miUsuario.setFecha(result.getString("nacimientoUsuario"));
					miUsuario.setTelefono(result.getString("telefonoUsuario"));
					miUsuario.setContrasenia(result.getString("contraseniaUsuario"));
					miUsuario.setTipo_Usuario(result.getString("tipoUsuario"));
					miUsuario.setCorreo(result.getString("correoUsuario"));
					listaPersonas.add(miUsuario);
					
					consIndividual="consulta exitosa";
				}

			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del usuario: " + e.getMessage());
			consIndividual="error en la consulta";
		} finally {
			miConexion.desconectar();
		}
		return consIndividual;
	}
	*/
	
	
	
}
