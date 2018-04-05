package accionesBean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import dao.ReporteDao;
import vo.Reporte;
import vo.UsuarioVo;

@ManagedBean
public class ModuloReporteUsuario {
	
	String obtenerDato;
	UsuarioVo miUsuario;
	ReporteDao daoReporte;
	String validacionUsuario = "";
	String validacionPrestamo = "";
	String validacionSancion = "";
	
	ArrayList<Reporte> listaPrestamos = new ArrayList<>();
	
	
	public ModuloReporteUsuario(){
		
		daoReporte = new ReporteDao();
	}
	
	
	public void accionUsuario(){
		
		buscarUsuario();
		buscarPrestamo();
	}
	
	
	
	
	public void buscarUsuario(){
	
		System.out.println("estamos en el metodo buscar usuario ");
		if(getObtenerDato().equals("")){
		
			validacionUsuario = "Error, debes digitar el documento del usuario y despues presiona el boton buscar";
			
					
		}else{
			
			System.out.println("estamos en la condicion del metodo buscarUsuario() ");
			
			System.out.println("valor de la variable obtenerDato " + getObtenerDato());
		int documentoUsuario = Integer.parseInt(getObtenerDato());
			
			System.out.println("valor del documentoUsuario "  + documentoUsuario);
			
		miUsuario = daoReporte.hallarUsuario(documentoUsuario);

		if(miUsuario != null){
			validacionUsuario = "Usuario encontrado !!";
		}else{
			validacionUsuario = "Usuario no encontrado !!. Debes digitar bien el documento";
		}

		}
	}

	public void buscarPrestamo(){
		
		System.out.println("Estamos en el metodo buscarPrestamo ");
		
		
		if(getObtenerDato().equals("") ){
			validacionUsuario = "Error, debes digitar el documento del usuario y despues presiona el boton buscar";
			
			System.out.println("error contenido !!");
					
		}else{
			
			System.out.println("estamos en la condicion buscarPrestamos ");
		
		int documentoUsuario = Integer.parseInt(getObtenerDato());
		
		
		listaPrestamos = daoReporte.listaPrestamosUsuario(documentoUsuario);
		
		if(listaPrestamos.size() == 0){
			
			validacionPrestamo = "El usuario no ha realizado prestamos";
			
		}else{
			
			validacionPrestamo = "El usuario si ha realizado Prestamos";
		}

		}
		
	}


	public String getObtenerDato() {
		return obtenerDato;
	}



	public void setObtenerDato(String obtenerDato) {
		this.obtenerDato = obtenerDato;
	}



	public UsuarioVo getMiUsuario() {
		return miUsuario;
	}



	public void setMiUsuario(UsuarioVo miUsuario) {
		this.miUsuario = miUsuario;
	}



	public ArrayList<Reporte> getListaPrestamos() {
		return listaPrestamos;
	}



	public void setListaPrestamos(ArrayList<Reporte> listaPrestamos) {
		this.listaPrestamos = listaPrestamos;
	}


	public String getValidacionUsuario() {
		return validacionUsuario;
	}


	public void setValidacionUsuario(String validacionUsuario) {
		this.validacionUsuario = validacionUsuario;
	}


	public String getValidacionPrestamo() {
		return validacionPrestamo;
	}


	public void setValidacionPrestamo(String validacionPrestamo) {
		this.validacionPrestamo = validacionPrestamo;
	}


	public String getValidacionSancion() {
		return validacionSancion;
	}


	public void setValidacionSancion(String validacionSancion) {
		this.validacionSancion = validacionSancion;
	}
	

	
	

}
