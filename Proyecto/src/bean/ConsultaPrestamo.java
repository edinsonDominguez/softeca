package bean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import accionesBean.LoginBean;
import dao.PerfilUsuarioDao;
import dao.ReporteDao;
import vo.Libro;
import vo.PersonaVo;
import vo.Reporte;
import vo.UsuarioVo;

@ManagedBean
@SessionScoped
public class ConsultaPrestamo {

	Libro miLibro;
	ReporteDao daoReporte ;
	ArrayList<Reporte>  listaPrestamo = new  ArrayList<>();
	int documentoConsulta;
	PerfilUsuarioDao daoPerfil;
	
	
	
	public ConsultaPrestamo(){
	
		daoPerfil = new PerfilUsuarioDao();
		daoReporte = new ReporteDao();
	}
	
	
	public void consultaPrestamoMetodo(){

		System.out.println("estamos en el metodo sin Parametro de consultarPrestamo"); 

		listaPrestamo.clear();
			
		int documentoUsuario =  daoPerfil.traerDocumento();
		
		System.out.println("su nuevo valor es: " + documentoUsuario);
		
			
		listaPrestamo = daoReporte.listaPrestamosUsuario(documentoUsuario);
		
		System.out.println("cantidad de prestamos " + listaPrestamo.size());
		
		if(listaPrestamo.size() == 0){
			
			System.out.println("no hay prestamos "); 
			
		}else{
			System.out.println("si hay prestamos "); 
			
		}
		
	}

	public ArrayList<Reporte> getListaPrestamo() {
		return listaPrestamo;
	}


	public void setListaPrestamo(ArrayList<Reporte> listaPrestamo) {
		this.listaPrestamo = listaPrestamo;
	}


	
}
