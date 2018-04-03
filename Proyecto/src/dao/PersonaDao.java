package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.Conexion;
import vo.PersonaVo;
import vo.UsuarioVo;

public class PersonaDao {

	public String agregarPersona(PersonaVo miPersona) {
		String resultado = "";

		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;

		connection = conexion.getConexion();
		String consulta = "INSERT INTO persona (documento,nombre,apellido,edad,profesion,salario,sexo,password)"
				+ "  VALUES (?,?,?,?,?,?,?,?)";

		try {
			preStatement = connection.prepareStatement(consulta);
			preStatement.setString(1, miPersona.getDocumento());
			preStatement.setString(2, miPersona.getNombre());
			preStatement.setString(3, miPersona.getApellido());
			preStatement.setInt(4, miPersona.getEdad());
			preStatement.setString(5, miPersona.getProfesion());
			preStatement.setString(6, miPersona.getSalario() + "");
			preStatement.setString(7, miPersona.getSexo());
			preStatement.setString(8, miPersona.getPass());
			preStatement.execute();

			resultado = "Registro Exitoso";

		} catch (SQLException e) {
			System.out.println("No se pudo registra la persona: " + e.getMessage());
			resultado = "No se pudo registrar";
		} finally {
			conexion.desconectar();
		}

		return resultado;
	}

	public ArrayList<PersonaVo> obtenerListaPersonas() {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		PersonaVo miPersona = new PersonaVo();
		ArrayList<PersonaVo> listaPersonas = null;

		connection = miConexion.getConexion();

		String consulta = "SELECT * FROM persona ";

		try {
			if (connection != null) {
				listaPersonas = new ArrayList<>();
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();

				while (result.next() == true) {
					miPersona = new PersonaVo();
					miPersona.setDocumento(result.getString("documento"));
					miPersona.setNombre(result.getString("nombre"));
					miPersona.setApellido(result.getString("apellido"));
					miPersona.setEdad(result.getInt("edad"));
					miPersona.setProfesion(result.getString("profesion"));
					miPersona.setSalario(Double.parseDouble(result.getString("salario")));
					miPersona.setSexo(result.getString("sexo"));
					miPersona.setPass(result.getString("password"));
					listaPersonas.add(miPersona);
				}

			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del usuario: " + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return listaPersonas;
	}

	public String editarPersona(PersonaVo persona) {
		String resultado = "";
		Connection connection = null;
		Conexion miConexion = new Conexion();
		connection = miConexion.getConexion();
		try {
			String consulta = "UPDATE persona "
					+ " SET nombre = ? , apellido=? , edad=? , profesion=? , salario= ? , sexo= ? "
					+ " WHERE documento= ? ";
			PreparedStatement preStatement = connection.prepareStatement(consulta);

			preStatement.setString(1, persona.getNombre());
			preStatement.setString(2, persona.getApellido());
			preStatement.setInt(3, persona.getEdad());
			preStatement.setString(4, persona.getProfesion());
			preStatement.setString(5, persona.getSalario() + "");
			preStatement.setString(6, persona.getSexo());
			preStatement.setString(7, persona.getDocumento());
			preStatement.executeUpdate();

			resultado = "Se ha Actualizado la persona satisfactoriamente";

			miConexion.desconectar();

		} catch (SQLException e) {
			System.out.println(e);
			resultado = "No se pudo actualizar la persona";
		}
		return resultado;
	}

	public String eliminarPersona(PersonaVo persona) {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		connection = miConexion.getConexion();

		String resp = "";
		try {
			String sentencia = "DELETE FROM persona WHERE documento= ? ";

			PreparedStatement statement = connection.prepareStatement(sentencia);
			statement.setString(1, persona.getDocumento());

			statement.executeUpdate();

			resp = "Se ha eliminado exitosamente";
			statement.close();
			miConexion.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			resp = "No se pudo eliminar";
		}
		return resp;
	}
	
	public PersonaVo consultarUsuarioLogin(String documento, String pass) {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		PersonaVo miPersona = null;

		connection = miConexion.getConexion();
		
		System.out.println("Documento: "+documento+" , pass: "+pass);
		
		try {
			if (connection != null) {
				
				String consulta = "SELECT * FROM persona where documento = ? and password = ? ";

				statement = connection.prepareStatement(consulta);

				statement.setString(1, documento);
				statement.setString(2, pass);
								
				result = statement.executeQuery();
				System.out.println("continua...");
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
	}


	public PersonaVo consultarPersonaIndividual(String documento) {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		PersonaVo miPersona = null;

		connection = miConexion.getConexion();

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
	}
	
	
	// METODO CREADO POR EDINSON DOMINGUEZ DOMINGUEZ
	public UsuarioVo ingresoCredenciales(String documento){

		System.out.println("Estamos en el metodo de ingreso de credenciales !!");
		
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		// ESTE ES EL METODO PARA QUE FUNCIONE EL INGRESO DE CREDENCIALES POR FAVOR NO MODIFICAR NI BORRAR
		connection = miConexion.getConexion();
		UsuarioVo miPersona = null;
		String consulta = "SELECT * FROM usuario where idUsuario = ? ";

		try {
				statement = connection.prepareStatement(consulta);
				statement.setString(1, documento);
				result = statement.executeQuery();

				if (result.next() == true) {
					miPersona = new UsuarioVo();
					miPersona.setDocumento(result.getString("idUsuario"));
					miPersona.setNombre(result.getString("nombreUsuario"));
					miPersona.setApellidos(result.getString("apellidoUsuario"));
					miPersona.setContrasenia(result.getString("contraseniaUsuario"));
					miPersona.setTipo_Usuario(result.getInt("tipoUsuario"));
				}

			
		} catch (SQLException e) {
			
			System.out.println("Error en el ingreso de credenciales: " + e.getMessage());
		}
		
		miConexion.desconectar();
		
		
		return miPersona;
	}
	

}
