package dao;
import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexion.Conexion;

import vo.PrestamoLibroVo;
public class PrestamoLibroDao {

	
	String docDelete;
	String resp;
	public String agregarprestamo(PrestamoLibroVo miLibro){
		String resultado="";
		
		Connection connection=null;
		Conexion conexion=new Conexion();
		PreparedStatement preStatement =null;
		
		connection = conexion.getConexion();
		String registro="INSERT INTO prestamo (usuarioPrestamo,codigoLibro,fechaPrestamo,fechaRegreso)"
				+"values(?,?,?,?)";
		
		try {
			preStatement = connection.prepareStatement(registro);
			preStatement.setString(1,miLibro.getDocumento());
			preStatement.setInt(2,miLibro.getCodigoLibro());
			preStatement.setString(3, miLibro.getFechaPrestamo());
			preStatement.setString(4, miLibro.getFechaRegreso());
			preStatement.execute();
			resultado = "registro exitoso";
			
		} catch (Exception e) {
			System.out.println("No se pudo registrar el libro " +  e.getMessage());
			resultado="no se registro";
		}finally{
			conexion.desconectar();
		}
		
		return resultado;
		
		
	}
	 
	public ArrayList<PrestamoLibroVo> devolver(String codigoUsuario){
		
		Connection connection=null;
		Conexion conexion=new Conexion();
		PreparedStatement preStatement =null;
		ResultSet result = null;
		
		PrestamoLibroVo miLibroVo;
		
		connection = conexion.getConexion();
		
		
		ArrayList<PrestamoLibroVo> listaLibros = new ArrayList<> ();


		String consultaLibro="select libro.tituloLibro, usuario.nombreUsuario, prestamo.usuarioPrestamo,   prestamo.fechaPrestamo, prestamo.fechaRegreso "
				+ "from prestamo,usuario, libro where prestamo.usuarioPrestamo = usuario.idUsuario and libro.codLibro = prestamo.codigoLibro and usuario.idUsuario = ?";
		
		try {
			
			preStatement = connection.prepareStatement(consultaLibro);
			preStatement.setString(1, codigoUsuario);
			
			
			result = preStatement.executeQuery();
			while(result.next()){
				
			miLibroVo= new PrestamoLibroVo();
			//miLibroVo.setCodigo(result.getInt("codPrestamo"));
			miLibroVo.setNombreLibro(result.getString("tituloLibro"));
			miLibroVo.setNombreUsuario(result.getString("nombreUsuario"));
			miLibroVo.setDocumento(result.getString("usuarioPrestamo"));
			miLibroVo.setFechaPrestamo(result.getString("fechaprestamo"));
			miLibroVo.setFechaRegreso(result.getString("fechaRegreso"));
		
			
			listaLibros.add(miLibroVo);
				
			}
									
		} catch (Exception e) {
			conexion.desconectar();
	}
		return listaLibros;
}
	
		public String devolverLibroSancion( PrestamoLibroVo miLibro){
			String msj="";
			
			Connection connection=null;
			Conexion conexion=new Conexion();
			PreparedStatement preStatement =null;
			
			
			 docDelete = miLibro.getDocumento();
			System.out.println("doc es: "+ docDelete);
			
			connection = conexion.getConexion();
			
			String consulta="INSERT INTO sancion (usuarioSancion, fechaSancion, fechaExpiracion, tipoSancion, informacionTipo ) value(?,?,?,?,?) ";
			
			try {
				preStatement = connection.prepareStatement(consulta);
				preStatement.setString(1,miLibro.getDocumento());
				preStatement.setString(2,miLibro.getFecha_inicioSancion());
				preStatement.setString(3,miLibro.getFecha_finSancion());
				preStatement.setString(4,miLibro.getTipo_sancion());
				preStatement.setString(5,miLibro.getInfoObservaciones());
				
				
				preStatement.execute();
				
													
				msj = "registro exitoso";
				
				
			}
			
			catch (Exception e) {
				System.out.println(e.getMessage());
				msj="no se pudo registrar";
		}	
				finally {
				conexion.desconectar();
			}
			
			return msj;
		}
		
	/*	public String deletePrestamo(String doc){
			 resp="";
			
			Connection connection=null;
			Conexion conexion=new Conexion();
			PreparedStatement preStatement =null;
		
			 Libro miLibro = new Libro();
			
			connection = conexion.getConnection();
			
			
			String delete = "delete from prestamo where usuarioPrestamo = ?";
			try {
				preStatement = connection.prepareStatement(delete);
				preStatement.setString(1,miLibro.getDocumento());
				
				preStatement.execute();
				resp="exitoso";
			
				
			} catch (Exception e) {
				System.out.println("No se pudo registrar el libro " +  e.getMessage());
				resp="no exitoso";
			}finally{
				conexion.desconectar();
			}
			
			return resp;
		}
	*/
	/*String registro="INSERT INTO prestamo (usuarioPrestamo,codigoLibro,fechaPrestamo,fechaRegreso)"
				+"values(?,?,?,?)";
		
		try {
			preStatement = connection.prepareStatement(registro);
			preStatement.setInt(1,miLibro.getDocumento());
			preStatement.setInt(2,miLibro.getCodigoLibro());
			preStatement.setString(3, miLibro.getFechaPrestamo());
			preStatement.setString(4, miLibro.getFechaRegreso());
			preStatement.execute();
			resultado = "registro exitoso";
			
		} catch (Exception e) {
			System.out.println("No se pudo registrar el libro " +  e.getMessage());
			resultado="no se registro";
		}finally{
			conexion.desconectar();
		}
		
		return resultado;*/
	
}
