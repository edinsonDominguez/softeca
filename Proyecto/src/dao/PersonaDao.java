package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.Conexion;
import vo.PersonaVo;

public class PersonaDao {

	
	public PersonaVo consultarUsuarioLogin(String documento, String pass) {

		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		PersonaVo miPersona = null;
		//posible error
		connection = miConexion.getConexion();
		
		System.out.println("Documento: "+documento+" , pass: "+pass);
		
		try {
			if (connection != null) {
				
				String consulta = "SELECT * FROM usuario where idUsuario = ? and contraseniaUsuario = ? ";

				statement = connection.prepareStatement(consulta);

				statement.setString(1, documento);
				statement.setString(2, pass);
								
				result = statement.executeQuery();

				System.out.println("continua...");
				if (result.next() == true) {
					miPersona = new PersonaVo();
					miPersona.setDocumento(result.getString("idUsuario"));
					miPersona.setNombre(result.getString("nombreUsuario"));
					miPersona.setApellido(result.getString("apellidoUsuario"));
					miPersona.setDireccion(result.getString("direccionUsuario"));
					miPersona.setNacimientoUsuario(result.getString("nacimientoUsuario"));
					miPersona.setTelefono(result.getString("telefonoUsuario"));
					miPersona.setContraseniaUsuario(result.getString("contraseniaUsuario"));
					miPersona.setTipoUsuario(result.getString("tipoUsuario"));
					miPersona.setCorreoUsuario(result.getString("correoUsuario"));
				}

			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del usuario: " + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return miPersona;
	}




}
