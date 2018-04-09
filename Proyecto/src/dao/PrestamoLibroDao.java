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
		String registro="INSERT INTO prestamo (usuarioPrestamo, libroPrestamo,fechaPrestamo,fechaRegreso,estado)"
				+"values(?,?,?,?,?);";
		try {
			preStatement = connection.prepareStatement(registro);
			preStatement.setString(1,miLibro.getDocumento());
			preStatement.setInt(2,miLibro.getCodigoLibro());
			preStatement.setString(3, miLibro.getFechaPrestamo());
			preStatement.setString(4, miLibro.getFechaRegreso());
			preStatement.setString(5, miLibro.getEstadoPrestamo());
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
	
			public String actualizarContador(PrestamoLibroVo miLibro){
				String dato="";
				Connection connection=null;
				Conexion conexion=new Conexion();
				PreparedStatement preStatement =null;
				
				connection = conexion.getConexion();
				
				String actualizarContador="UPDATE libro SET disponible = (disponible - 1) WHERE (codLibro = ? ) AND (disponible != 0);";
				
				
	try {
		preStatement = connection.prepareStatement(actualizarContador);
		preStatement.setInt(1, miLibro.getCodigoLibro());
		preStatement.execute();
		dato="ok";
	} catch (Exception e) {
		System.out.println(e.getMessage());
		dato="no actualizo";
	}			
				
	return dato;
								
			}
			
			public String aumentarCantidad(PrestamoLibroVo miLibro){
				String aumento="";
				Connection connection=null;
				Conexion conexion=new Conexion();
				PreparedStatement preStatement =null;
				
				connection = conexion.getConexion();
				
				String actualizacion="UPDATE libro SET disponible = (disponible + 1) WHERE (codLibro = ?) AND (disponible < ejemplarLibro);";
				
				try {
					preStatement = connection.prepareStatement(actualizacion);
					preStatement.setInt(1, miLibro.getCodigoLibro());
					preStatement.execute();
					aumento="ok";
				} catch (Exception e) {
					System.out.println(e.getMessage());
					aumento="no ok";
				}
				
				return aumento;
			}
	 
	public ArrayList<PrestamoLibroVo> devolver(String codigoUsuario){
		
		
		Connection connection=null;
		Conexion conexion=new Conexion();
		PreparedStatement preStatement =null;
		ResultSet result = null;
		
		System.out.println("codigo Uusario ----- "  + codigoUsuario);
		
		PrestamoLibroVo miLibroVo = null;
		
		connection = conexion.getConexion();
		
		
		ArrayList<PrestamoLibroVo> listaLibros = new ArrayList<> ();


		String consultaLibro="SELECT libro.tituloLibro, usuario.nombreUsuario, prestamo.usuarioPrestamo, prestamo.fechaPrestamo, prestamo.fechaRegreso FROM prestamo,usuario, libro WHERE prestamo.usuarioPrestamo = usuario.idUsuario AND libro.codLibro = prestamo.libroPrestamo AND usuario.idUsuario = ?;";
		
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
		
			System.out.println("Error en la base de datos");
			System.out.println(e.getMessage());
		
		}
		
		
		conexion.desconectar();
		
		
		System.out.println("cantidad de registros en la clase PrestamoLibroDao" + listaLibros.size());
		
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
		


	public String eliminarPrestamo(PrestamoLibroVo miLibro) {
		String respEliminar="";
		Connection connection=null;
		Conexion conexion=new Conexion();
		PreparedStatement preStatement =null;
		
		connection = conexion.getConexion();
		
		String eliminarPres = "UPDATE prestamo SET estado = 'Inactivo' WHERE usuarioPrestamo = ? AND libroPrestamo = ?";
		
		try {
			preStatement = connection.prepareStatement(eliminarPres);
			preStatement.setString(1, miLibro.getDocumento());
			preStatement.setInt(2, miLibro.getCodigoLibro());
			preStatement.execute();
			
			respEliminar="satisfactorio";
		} catch (Exception e) {
			respEliminar ="no satisfactorio";
			System.out.println("Error en la base de datos!1");
		}
		
		return respEliminar;
	}
	
	
	
	
	
}
