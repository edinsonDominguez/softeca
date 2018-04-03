package accionesBean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.ReporteDao;
import vo.Libro;
import vo.Reporte;

@SessionScoped
@ManagedBean
public class ModuloReporteLibro {

	
	String obtenerDato;
	String estadoLibro = "sin estado";
	String estadoPrestamo = "sin estado";
	String estadoSancion = "sin estado";
	Libro miLibro;
	ReporteDao daoReporte;
	ArrayList<Reporte> listaPrestamos = new ArrayList<>();
	
	
	
	public ModuloReporteLibro(){
		
		daoReporte = new ReporteDao();
		
	}
	
	public void accionReporte(){
		
		System.out.println("Estamos en el metodo // accion reporte");
		
		buscarLibro();
		
		buscarPrestamosLibro();
	}
	
	
	public void buscarPrestamosLibro(){
	
		listaPrestamos = daoReporte.listaPrestamosLibro(getObtenerDato());
	
		
		System.out.println("cantidad de libros en la clase ModuloReporte " + listaPrestamos.size());
		
		if(listaPrestamos.size() == 0){
			
			estadoPrestamo = "NO SE HAN REALIZADO PRESTAMOS CON EL LIBRO";
		}else{
			estadoPrestamo = "SI SE HAN REALIZADO PRESTAMOS";
		}
		
	}
	
	
	public void buscarLibro(){
	
		miLibro = daoReporte.HallarLibro(getObtenerDato()); 
		
		if(miLibro != null){
			
			estadoLibro = "Hay un Libro !!  en la base de datos";
		}else{
			estadoLibro = "No se encontro el libro !!";
		}
		
	}
	
	
	
	
	public String getEstadoPrestamo() {
		return estadoPrestamo;
	}


	public void setEstadoPrestamo(String estadoPrestamo) {
		this.estadoPrestamo = estadoPrestamo;
	}


	public String getEstadoSancion() {
		return estadoSancion;
	}


	public void setEstadoSancion(String estadoSancion) {
		this.estadoSancion = estadoSancion;
	}


	public ArrayList<Reporte> getListaPrestamos() {
		return listaPrestamos;
	}


	public void setListaPrestamos(ArrayList<Reporte> listaPrestamos) {
		this.listaPrestamos = listaPrestamos;
	}


	public String getEstadoLibro() {
		return estadoLibro;
	}

	public void setEstadoLibro(String estadoLibro) {
		this.estadoLibro = estadoLibro;
	}

	public Libro getMiLibro() {
		return miLibro;
	}

	public void setMiLibro(Libro miLibro) {
		this.miLibro = miLibro;
	}
	
	
	public String getObtenerDato() {
		return obtenerDato;
	}

	public void setObtenerDato(String obtenerDato) {
		this.obtenerDato = obtenerDato;
	}
	
	

	
}
