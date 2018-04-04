package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.Conexion;
import vo.Libro;

public class LibroDao {
	
	CategoriaDao daoCategoria;

	public LibroDao(){
		
		daoCategoria = new CategoriaDao();
	}

	
	public String agregarLibro(Libro miLibro){
		String resultado ="";
		
		Connection connection=null;
		Conexion conexion=new Conexion();
		PreparedStatement preStatement =null;
		
		
		connection = conexion.getConexion();
				String consulta="INSERT INTO libro (codLibro,tituloLibro,autorLibro,editorialLibro,estanteriaLibro,ejemplarLibro,categoriaLibro,disponible) VALUES (?,?,?,?,?,?,?)";
		
		
		try{
			preStatement = connection.prepareStatement(consulta);
			preStatement.setInt(1, miLibro.getCodigo());
			preStatement.setString(2, miLibro.getTitulo());
			preStatement.setString(3, miLibro.getAutor());
			preStatement.setString(4, miLibro.getEditorial());
			preStatement.setString(5, miLibro.getEstanteria());
			preStatement.setInt(6,  miLibro.getEjemplar());	
			preStatement.setInt(7, miLibro.getCategoria());	
			preStatement.setInt(8, miLibro.getEjemplar());
			preStatement.execute();

			resultado="Registro Exitoso ala base de datos ******************************";
			
		}catch (SQLException e) {
			System.out.println("Error en el metodo agregarLibro() !!");
			System.out.println("No se pudo registrar el libro " +  e.getMessage());
		resultado="No se pudo registrar";
		}finally{
			conexion.desconectar();
		}
		
		return resultado;
	}

	
	
	
	
	public String  actualizarLibro(Libro miLibro){
		
		String mensaje = "";
		
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		
		connection = miConexion.getConexion();
		
		
		String consulta = "UPDATE libro SET tituloLibro = ?, autorLibro = ?, editorialLibro = ?, estanteriaLibro = ?, ejemplarLibro = ?, categoriaLibro = ? WHERE codLibro = ?";
		
		try {
			statement = connection.prepareStatement(consulta);
			statement.setString(1, miLibro.getTitulo());
			statement.setString(2, miLibro.getAutor());
			statement.setString(3, miLibro.getEditorial());
			statement.setString(4, miLibro.getEstanteria());
			statement.setInt(5, miLibro.getEjemplar());
			statement.setInt(6, miLibro.getCategoria());			
			statement.setInt(7, miLibro.getCodigo());
			
			statement.executeUpdate();
			
		mensaje = "ok";	
			
		} catch (SQLException e) {
			
			System.out.println("Error en la clase dao: " + e.getMessage());
		}
		
		miConexion.desconectar();
		
		
		return mensaje;
	}	
	
	
	
	
	
	public String eliminarLibro(Libro miLibro){
		
		String mensaje = "";
		
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		
		connection = miConexion.getConexion();
		
		
		String consulta = "DELETE FROM libro WHERE codLibro =  ?";
		
		try {
			statement = connection.prepareStatement(consulta);
			statement.setInt(1, miLibro.getCodigo());
			
			statement.executeUpdate();
			statement.close();
			
		mensaje = "ok";	
		} catch (SQLException e) {
			
			System.out.println("Error en la clase dao: " + e.getMessage());
		}		
		
		miConexion.desconectar();
		
		return  mensaje;
	}
	
	// ESTE METODO ME TRAERA LOS DATOS DEL LIBRO PONINEDO EL ID.
	public ArrayList<Libro> hallarPorCodigo(String codigoLibro){
		
		int codigo = Integer.parseInt(codigoLibro);
		
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;
		ResultSet result = null;
		
		Libro libro = null;
		ArrayList<Libro> lista = new ArrayList<>();
		connection = conexion.getConexion();
		
		String consulta = "SELECT * FROM libro WHERE codLibro = ?";
		
		try {
			
			preStatement =connection.prepareStatement(consulta);
			preStatement.setInt(1, codigo); 
			result = preStatement.executeQuery();
			
			
			while(result.next()){
				
				libro = new Libro();
				libro.setCodigo(result.getInt("codLibro"));
				libro.setTitulo(result.getString("tituloLibro"));
				libro.setAutor(result.getString("autorLibro"));
				libro.setEditorial(result.getString("editorialLibro"));
				libro.setEstanteria(result.getString("estanteriaLibro"));
				libro.setEjemplar(result.getInt("ejemplarLibro"));
				libro.setCategoria(result.getInt("categoriaLibro"));
	
				String nombreCategoria = daoCategoria.buscarNombreCategoria(libro.getCategoria());
				libro.setNombreCategoria(nombreCategoria);
		
				lista.add(libro);
			}
			
			
		} catch (SQLException e) {
		
			System.out.println("Error en UsuarioDao " + e.getMessage());
			
		}
		
		conexion.desconectar();
		return lista;
	}
	
	// TRAERA EL LIBRO POR EL TITULO 
	
	public ArrayList<Libro> hallarPorNombre(String tituloLibro){
		
		
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;
		ResultSet result = null;
		
		Libro libro = null;
		ArrayList<Libro> lista = new ArrayList<>();
		connection = conexion.getConexion();
		
		String consulta = "SELECT * FROM libro WHERE tituloLibro = ?";
		
		try {
			
			preStatement =connection.prepareStatement(consulta);
			preStatement.setString(1, tituloLibro); 
			result = preStatement.executeQuery();
			
			
			while(result.next()){
				
				libro = new Libro();
				libro.setCodigo(result.getInt("codLibro"));
				libro.setTitulo(result.getString("tituloLibro"));
				libro.setAutor(result.getString("autorLibro"));
				libro.setEditorial(result.getString("editorialLibro"));
				libro.setEstanteria(result.getString("estanteriaLibro"));
				libro.setEjemplar(result.getInt("ejemplarLibro"));
				libro.setCategoria(result.getInt("categoriaLibro"));
		
				String nombreCategoria = daoCategoria.buscarNombreCategoria(libro.getCategoria());
				libro.setNombreCategoria(nombreCategoria);
		
				lista.add(libro);
			}
			
			
		} catch (SQLException e) {
		
			System.out.println("Error en UsuarioDao " + e.getMessage());
			
		}
		
		conexion.desconectar();
		return lista;
	}
	
	// ------------------------------------------------
	
	
public ArrayList<Libro> hallarPorAutor(String autorLibro){
		
		
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;
		ResultSet result = null;
		
		Libro libro = null;
		ArrayList<Libro> lista = new ArrayList<>();
		connection = conexion.getConexion();
		
		String consulta = "SELECT * FROM libro WHERE autorLibro = ?";
		
		try {
			
			preStatement =connection.prepareStatement(consulta);
			preStatement.setString(1, autorLibro); 
			result = preStatement.executeQuery();
			
			
			while(result.next()){
				
				libro = new Libro();
				libro.setCodigo(result.getInt("codLibro"));
				libro.setTitulo(result.getString("tituloLibro"));
				libro.setAutor(result.getString("autorLibro"));
				libro.setEditorial(result.getString("editorialLibro"));
				libro.setEstanteria(result.getString("estanteriaLibro"));
				libro.setEjemplar(result.getInt("ejemplarLibro"));
				libro.setCategoria(result.getInt("categoriaLibro"));
		
				String nombreCategoria = daoCategoria.buscarNombreCategoria(libro.getCategoria());
				libro.setNombreCategoria(nombreCategoria);
		
				
				lista.add(libro);
			}
			
			
		} catch (SQLException e) {
		
			System.out.println("Error en UsuarioDao " + e.getMessage());
			
		}
		
		conexion.desconectar();
		return lista;
	}
	
	// --------------------------------------------------------------------

	public ArrayList<Libro> hallarPorCategoria(String categoriaLibro){
	
	Connection connection = null;
	Conexion conexion = new Conexion();
	PreparedStatement preStatement = null;
	ResultSet result = null;
	
	Libro libro = null;
	ArrayList<Libro> lista = new ArrayList<>();
	connection = conexion.getConexion();
	
	String consulta = "SELECT codLibro, tituloLibro, autorLibro, editorialLibro, estanteriaLibro, ejemplarLibro, categoriaLibro FROM libro lib, categoria cat WHERE  (cat.codCategoria  = lib.categoriaLibro) AND (cat.nombreCategoria = ?);";
	
	
	try {
		
		preStatement =connection.prepareStatement(consulta);
		preStatement.setString(1, categoriaLibro); 
		result = preStatement.executeQuery();
		
		
		while(result.next()){
			
			libro = new Libro();
			libro.setCodigo(result.getInt("codLibro"));
			libro.setTitulo(result.getString("tituloLibro"));
			libro.setAutor(result.getString("autorLibro"));
			libro.setEditorial(result.getString("editorialLibro"));
			libro.setEstanteria(result.getString("estanteriaLibro"));
			libro.setEjemplar(result.getInt("ejemplarLibro"));
			libro.setCategoria(result.getInt("categoriaLibro"));
		
			String nombreCategoria = daoCategoria.buscarNombreCategoria(libro.getCategoria());
			libro.setNombreCategoria(nombreCategoria);
	
			
			lista.add(libro);
		}
		
		
	} catch (SQLException e) {
	
		System.out.println("Error en UsuarioDao " + e.getMessage());
		
	}
	
	conexion.desconectar();
	return lista;
}
		




	
	// ********************************************************************
	
	
	public ArrayList<Libro> consultarLista(){
		
			Connection connection = null;
			Conexion conexion = new Conexion();
			PreparedStatement statement = null;	
			ResultSet result = null;
			
			ArrayList<Libro> lista = new ArrayList<>();
			Libro miLibro = null;
			
			
			connection = conexion.getConexion();
			String consulta = "SELECT * FROM libro ";
			
			try {
				
				statement = connection.prepareStatement(consulta);
				result = statement.executeQuery();
				
				while(result.next()){
					
					miLibro =  new Libro();
					miLibro.setCodigo(result.getInt("codLibro"));
					miLibro.setTitulo(result.getString("tituloLibro"));
					miLibro.setAutor(result.getString("autorLibro"));
					miLibro.setEditorial(result.getString("editorialLibro"));
					miLibro.setEstanteria(result.getString("estanteriaLibro"));
					miLibro.setEjemplar(result.getInt("ejemplarLibro"));
					miLibro.setCategoria(result.getInt("categoriaLibro"));
					
					lista.add(miLibro);
					
				}
				
			} catch (SQLException e) {
			
				System.out.println("Error  en el metodo listaLibros()/LibroDao"); 
			
			}
			
			conexion.desconectar();
			
			
			return lista;
		
	}
	

	
	
	public ArrayList<Libro> consultarLibro(String icbn){
	
		// ESTE METODO HALLA EL LIBRO POR MEDIO DEL ICBN
		int codICBN = Integer.parseInt(icbn);
		
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;
		
		ArrayList<Libro> lista = new ArrayList<>();
		Libro miLibro = null;
		
		connection = conexion.getConexion();
		
		String consulta = "SELECT * FROM libro WHERE codLibro = ?";
		
		
		try {
		
			statement = connection.prepareStatement(consulta);
			statement.setInt(1, codICBN);
			result = statement.executeQuery();
			
			while(result.next()){
				
				miLibro = new Libro();
				miLibro.setCodigo(result.getInt("codLibro"));
				miLibro.setTitulo(result.getString("tituloLibro"));
				miLibro.setAutor(result.getString("autorLibro"));
				miLibro.setEditorial(result.getString("editorialLibro"));
				miLibro.setEstanteria(result.getString("estanteriaLibro"));
				miLibro.setEjemplar(result.getInt("ejemplarlibro"));
				miLibro.setCategoria(result.getInt("categoriaLibro"));
				
				System.out.println("Mi Titulo: " + miLibro.getTitulo());
				lista.add(miLibro);
			}
			
			
		} catch (SQLException e) {
		
			System.out.println("Error en el metodo buscarGeneral()/LibroDao");
		
		}
		
		conexion.desconectar();
		
		return lista;
	}


	
	
	public ArrayList<Libro> buscarGeneral(String letra){
		
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;
		
		ArrayList<Libro> lista = new ArrayList<>();
		Libro miLibro = null;
		
		connection = conexion.getConexion();
		
		String consulta = "SELECT * FROM libro WHERE tituloLibro = ?";
		
		
		try {
		
			statement = connection.prepareStatement(consulta);
			statement.setString(1, letra + "%");
			result = statement.executeQuery();
			
			while(result.next()){
				
				miLibro = new Libro();
				miLibro.setCodigo(result.getInt("codLibro"));
				miLibro.setTitulo(result.getString("tituloLibro"));
				miLibro.setAutor(result.getString("autorLibro"));
				miLibro.setEditorial(result.getString("editorialLibro"));
				miLibro.setEstanteria(result.getString("estanteriaLibro"));
				miLibro.setEjemplar(result.getInt("ejemplarlibro"));
				miLibro.setCategoria(result.getInt("categoriaLibro"));
				
				lista.add(miLibro);
			}
			
			
		} catch (SQLException e) {
		
			System.out.println("Error en el metodo buscarGeneral()/LibroDao");
		
		}
		
		conexion.desconectar();
		
		return lista;
	}



}
