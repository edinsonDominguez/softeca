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
	ArrayList<Reporte> listaPrestamos = new ArrayList<>();
	
	
	public ModuloReporteUsuario(){
		
		daoReporte = new ReporteDao();
		
	}
	
	
	public void accionUsuario(){
		
		buscarUsuario();
		buscarPrestamo();
	}
	
	
	
	
	public void buscarUsuario(){
	
		int documentoUsuario = Integer.parseInt(getObtenerDato());
		
		miUsuario = daoReporte.hallarUsuario(documentoUsuario);
		
	}

	public void buscarPrestamo(){
		
		int documentoUsuario = Integer.parseInt(getObtenerDato());
		listaPrestamos = daoReporte.listaPrestamosUsuario(documentoUsuario);
		
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
	

	
	

}
