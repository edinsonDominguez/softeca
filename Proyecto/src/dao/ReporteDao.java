package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.Conexion;
import vo.Libro;
import vo.Reporte;
import vo.Sancion;
import vo.UsuarioVo;

public class ReporteDao {

	public Libro HallarLibro(String tituloLibro){
		
		
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;
	
		
		connection = conexion.getConexion();
		
		Libro miLibro = null;
		
		String consulta = "SELECT codLibro, tituloLibro, autorLibro, editorialLibro, estanteriaLibro, ejemplarLibro, nombreCategoria, disponible  FROM libro, categoria WHERE (categoriaLibro = codCategoria) AND (tituloLibro = ?);";
		
		
	try {
			
			statement = connection.prepareStatement(consulta);
			statement.setString(1, tituloLibro);
			result = statement.executeQuery();
			
			while(result.next()){
				
				miLibro = new Libro();
				miLibro.setCodigo(result.getInt("codLibro"));
				miLibro.setTitulo(result.getString("tituloLibro"));
				miLibro.setAutor(result.getString("autorLibro"));
				miLibro.setEditorial(result.getString("editorialLibro"));
				miLibro.setEstanteria(result.getString("estanteriaLibro"));
				miLibro.setEjemplar(result.getInt("ejemplarLibro"));
				miLibro.setNombreCategoria(result.getString("nombreCategoria"));
				miLibro.setDisponible(result.getInt("disponible"));
			}
			
		} catch (SQLException e) {
		
		System.out.println("Error en el metodo <Hallarlibro(String )> / ReporteDao ");
		System.out.println("Error en la consulta " + e.getMessage());
		}
		
		conexion.desconectar();
	
		
		return miLibro;
	}
	

	public ArrayList<Reporte> listaPrestamosLibro(String tituloLibro){
	
	Connection connection = null;
	Conexion conexion = new Conexion();
	PreparedStatement statement = null;
	ResultSet result = null;
	
	ArrayList<Reporte> lista = new ArrayList<>();
	Reporte miReporte = null;
	
	connection = conexion.getConexion();
	
	String consulta = "SELECT idUsuario, nombreUsuario, fechaPrestamo, fechaRegreso FROM libro, prestamo, usuario WHERE (usuarioPrestamo = idUsuario) AND (libroPrestamo = codLibro) AND (libro.tituloLibro = ?);";
	
	try {
		
		statement = connection.prepareStatement(consulta);
		statement.setString(1, tituloLibro);
		result = statement.executeQuery();
		
		
		while(result.next()){
			
			miReporte = new Reporte();
			
			miReporte.setIdUsuario(result.getString("idUsuario"));
			miReporte.setNombreUsuario(result.getString("nombreUsuario"));
			miReporte.setFechaPrestamo(result.getString("fechaPrestamo"));
			miReporte.setFechaRegreso(result.getString("fechaRegreso"));
			
			boolean estadoSancion = verificarSancion(tituloLibro, miReporte.getIdUsuario()); 
			
			miReporte.setSancionPrestamo(estadoSancion);
			
			lista.add(miReporte);
			
		}
		
	} catch (SQLException e) {
		
	System.out.println("Error en el metodo <hallarprestamosLibro(String)>/PrestamoDao");
	e.getMessage();
		
	}
	
	conexion.desconectar();
	
	System.out.println("cantidad de prestamos en la clase ReporteDao" + lista.size());
	
	return lista;
	}


	
	public boolean verificarSancion(String tituloLibro, String idUsuario){
		
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;
		

		boolean estado = false;
		Sancion sancion = null;
		
		connection = conexion.getConexion();
		
		String consulta = "SELECT fechasancion, fechaExpiracion, nombreTipo, informacionTipo FROM tipoSancion, sancion, usuario, libro WHERE (idUsuario = ?) AND (tituloLibro = ?);";
		
		
		
		try {
			
			statement = connection.prepareStatement(consulta);
			statement.setString(1, idUsuario);
			statement.setString(2, tituloLibro);
			result = statement.executeQuery();
			
			
			while(result.next()){
				
				sancion = new Sancion();
				sancion.setFechaSancion("fechaSancion");
				sancion.setFechaExpiracion("fechaExpiracion");
				sancion.setNombreTipo("nombreTipo");
				sancion.setDescripcionSancion("informacionTipo");
				
			}
			
			if(sancion != null){
				estado = true;
			}
			
			
		} catch (SQLException e) {
			
		System.out.println("Error en el metodo <hallarprestamosLibro(String)>/PrestamoDao");
		e.getMessage();
			
		}
		
		conexion.desconectar();
		
		return estado;
		
	}
	
	
	
	// ************************* BUSCAR PRESTAMOS POR USUARIO **************************************
	

	public UsuarioVo hallarUsuario(int documentoUsuario){
		
		
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;
	
		
		connection = conexion.getConexion();
		
		UsuarioVo miUsuario = null;
		String consulta = "SELECT idUsuario, nombreUsuario, apellidoUsuario, direccionUsuario, telefonoUsuario, correoUsuario FROM usuario WHERE (idUsuario = ?);";
		
		
	try {
			
			statement = connection.prepareStatement(consulta);
			statement.setInt(1, documentoUsuario);
			result = statement.executeQuery();
			
			while(result.next()){
				
				miUsuario = new UsuarioVo();
				miUsuario.setDocumento(result.getString("idUsuario"));
				miUsuario.setNombre(result.getString("nombreUsuario"));
				miUsuario.setApellidos(result.getString("apellidoUsuario"));
				miUsuario.setDireccion(result.getString("direccionUsuario"));
				miUsuario.setTelefono(result.getString("telefonoUsuario"));
				miUsuario.setCorreo(result.getString("correoUsuario"));
				
			}
			
		} catch (SQLException e) {
		
		System.out.println("Error en el metodo <hallarUsuario(int )> / ReporteDao ");
		System.out.println("Error en la consulta " + e.getMessage());
		}
		
		conexion.desconectar();
	
		
		return miUsuario;
	}


	public ArrayList<Reporte> listaPrestamosUsuario(int documentoUsuario){
	
	Connection connection = null;
	Conexion conexion = new Conexion();
	PreparedStatement statement = null;
	ResultSet result = null;
	
	ArrayList<Reporte> lista = new ArrayList<>();
	Reporte miReporte = null;
	
	connection = conexion.getConexion();
	
	String consulta = "SELECT tituloLibro, fechaPrestamo, fechaRegreso FROM libro, prestamo, usuario WHERE (usuarioPrestamo = idUsuario) AND (libroPrestamo = codLibro) AND (idUsuario = ?);";
	
	try {
		
		statement = connection.prepareStatement(consulta);
		statement.setInt(1, documentoUsuario);
		result = statement.executeQuery();
		
		
		while(result.next()){
			
			miReporte = new Reporte();
			
			miReporte.setTituloLibro(result.getString("tituloLibro"));
			miReporte.setFechaPrestamo(result.getString("fechaPrestamo"));
			miReporte.setFechaRegreso(result.getString("fechaRegreso"));
			
			
			
			boolean sancion = verificarSancion(miReporte.getTituloLibro(), documentoUsuario + "" );
			
			miReporte.setSancionPrestamo(sancion);
			//boolean estadoSancion = verificarSancion(tituloLibro, miReporte.getIdUsuario()); 
			
			//miReporte.setSancionPrestamo(estadoSancion);
			
			lista.add(miReporte);
			
		}
		
	} catch (SQLException e) {
		
	System.out.println("Error en el metodo <hallarprestamosUsuario(String)>/ReporteDao");
	e.getMessage();
		
	}
	
	conexion.desconectar();
	
	System.out.println("cantidad de prestamos en la clase ReporteDao" + lista.size());
	
	return lista;
	}


	
}
