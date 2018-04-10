package bean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import accionesBean.LoginBean;
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
	LoginBean miLogin;
	PersonaVo miUsuario;
	
	
	public ConsultaPrestamo(){
	
		miLogin = new LoginBean();
		miUsuario = miLogin.getMiPersonaVo();
	}
	
	public void imprimiendoPersona(){
		
		System.out.println("documento" +miUsuario.getDocumento());
		System.out.println(documentoConsulta + "hola");
	}
	
	public void consultaPrestamoMetodo(){
	
		imprimiendoPersona();
		System.out.println("su nuevo valor es: " + miLogin.getMiPersonaVo().getDocumento());
		
		System.out.println("estamos en el metodo sin Parametro de consultarPrestamo"); 
		
		daoReporte = new ReporteDao();
		
		listaPrestamo.clear();
	
		listaPrestamo = daoReporte.listaPrestamosUsuario(documentoConsulta);
		
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

	public int getDocumentoConsulta() {
		System.out.println("lo que va a retornar en get es: " + this.documentoConsulta);
		return documentoConsulta;
	}

	public void setDocumentoConsulta(int documentoConsulta) {
		System.out.println("el valor del documento en set es " + documentoConsulta);
		this.documentoConsulta = documentoConsulta;
		
		System.out.println("su nuevo valor en set es:  " + this.documentoConsulta);
	}


	
}
