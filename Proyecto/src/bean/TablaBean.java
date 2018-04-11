package bean;

import java.util.ArrayList;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import dao.PrestamoLibroDao;

import vo.PrestamoLibroVo;

@ManagedBean
@ViewScoped
public class TablaBean {
	private PrestamoLibroVo miLibro;
	private PrestamoLibroDao miLibroDao;
	private String respuesta;
	private boolean datosDevolver;
	
	private String codigoUsuario;
	private String devolverLibroSancion;
	private String mensajePrestamo;

	ArrayList <PrestamoLibroVo> listaDevolucionLibros = new ArrayList <> ();
	
	public TablaBean(){
		miLibro=new PrestamoLibroVo();
		miLibroDao=new PrestamoLibroDao();
	}
	
	public void registrarPrestamo(){
		String resp="";
		respuesta = miLibroDao.agregarprestamo(miLibro);
		
		if(respuesta.equalsIgnoreCase("registro exitoso")){
			respuesta = "se registro satisfactoriamente";
			
			resp = miLibroDao.actualizarContador(miLibro);
			if(resp.equalsIgnoreCase("ok")){
				System.out.println("El contador se actualizo");
				mensajePrestamo="Prestamo realizado correctamente";
				
				
			}else{
				System.out.println("No se actualizo el contador");
			}
			
		}else{
			respuesta = "no se pudo registra, Intentelo nuevamente";
			mensajePrestamo="No se pudo registrar el prestamo, Intentelo nuevamente";
			
		}
	
	}
	
	public void RevisionDevolverLibro(){
		
		listaDevolucionLibros.clear();
		
		System.out.println("el documento del usuario = " + miLibro.getDocumento());
		
		listaDevolucionLibros = miLibroDao.devolver(miLibro.getDocumento());
		
		
		
		if(listaDevolucionLibros.size() == 0){
			datosDevolver= false;
			
			System.out.println("No hay datos de registro");
			
		}else{
			datosDevolver = true;
			
		}
		
		
	}
	
	public void devolverLibro(){
		
		String respSancion=""; 
		
		devolverLibroSancion= miLibroDao.devolverLibroSancion(miLibro);
		
		if(devolverLibroSancion.equalsIgnoreCase("registro exitoso")){
			respSancion="registro satisfactorio";
			
			devolverLibroSancion = miLibroDao.aumentarCantidad(miLibro);
			if (devolverLibroSancion.equalsIgnoreCase("ok")) {
				System.out.println("aumento exitoso");
			}else{
				System.out.println("no se aumento");
			}
			
			respSancion = miLibroDao.eliminarPrestamo(miLibro);
			if(respSancion.equalsIgnoreCase("satisfactorio")){
				System.out.println("se elimino el prestamo");
			}else{
				System.out.println("No se elimino");
			}
			
			System.out.println("registro exitoso de la sancion");
		}else{
			System.out.println("error al registrar sancion");
		}
	}
	
	
	

	public String getMensajePrestamo() {
		return mensajePrestamo;
	}

	public void setMensajePrestamo(String mensajePrestamo) {
		this.mensajePrestamo = mensajePrestamo;
	}

	public boolean isDatosDevolver() {
		return datosDevolver;
	}

	public void setDatosDevolver(boolean datosDevolver) {
		this.datosDevolver = datosDevolver;
	}

	public String getDevolverLibroSancion() {
		return devolverLibroSancion;
	}

	public void setDevolverLibroSancion(String devolverLibroSancion) {
		this.devolverLibroSancion = devolverLibroSancion;
	}

	public String getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}



	public ArrayList<PrestamoLibroVo> getListaDevolucionLibros() {
		return listaDevolucionLibros;
	}

	public void setListaDevolucionLibros(ArrayList<PrestamoLibroVo> listaDevolucionLibros) {
		this.listaDevolucionLibros = listaDevolucionLibros;
	}


	public PrestamoLibroDao getMiLibroDao() {
		return miLibroDao;
	}

	public void setMiLibroDao(PrestamoLibroDao miLibroDao) {
		this.miLibroDao = miLibroDao;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public PrestamoLibroVo getMiLibro() {
		return miLibro;
	}

	public void setMiLibro(PrestamoLibroVo miLibro) {
		this.miLibro = miLibro;
	}


	
}
