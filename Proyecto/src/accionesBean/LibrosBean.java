package accionesBean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.LibroDao;
import vo.Libro;

@ViewScoped
@ManagedBean

public class LibrosBean {	

	LibroDao daoLibro;
	Libro miLibro;
	ArrayList<Libro> listaLibros = new ArrayList<Libro>();
	String mensaje;
	String textoTraer;
	String validaciones = "validacion";
	String opcion;
	
	
	public LibrosBean(){
	
		
		miLibro = new Libro();
		
		daoLibro = new LibroDao();
		
	}

	

	
	
	
	
		public void filtrarOpcion(){
		
		listaLibros.clear();
		
		
		
		switch(getOpcion()){
	
			case "nombre":
					listaLibros = daoLibro.hallarPorNombre(getTextoTraer());
					break;
					
			case "icbn":
					listaLibros = daoLibro.hallarPorCodigo(getTextoTraer());
					break;		
				
			case "autor":
					listaLibros = daoLibro.hallarPorAutor(getTextoTraer());
					break;
			
			case "categoria":
					listaLibros = daoLibro.hallarPorCategoria(getTextoTraer());
				break;
		}	
		
	}
	
	
	
	
	

	public String EditarLibro(Libro libro){
		
		mensaje = "ingresa";	
		libro.setEditar(true);
		
		return "index";
	}
	
	public void guardarCambios(Libro libro){
		
		setMensaje(daoLibro.actualizarLibro(libro));
		String validacion = getMensaje();
		
		if(validacion.equals("error_categoria")){
			validaciones = "La categoria no existe :( !!";
		}
		
		libro.setEditar(false);
	}
	
	
	
	public void eliminarLibro(Libro libro){

		setMensaje(daoLibro.eliminarLibro(libro));
		listaLibros.remove(libro);
		
	}
	
	/* 	REGISTRAR LIBRO...
	 * 
	 * EL METODO REGISTRAR LIBRO ESTA HECHO POR BRAYAN 
	 * SU FUNCION ES REGISTRAR LIBRO
	 * 
	 * 
	 * */
	
	
	
	public void registrarLibro(){
		
		System.out.println(miLibro.getCategoria());
		setMensaje(daoLibro.agregarLibro(miLibro));
		
		
		if (mensaje.equals("ok")) {
			
			validaciones = "El libro no registrado con exito !!";
			
		}else{
			validaciones = " Libro registrado con exito !!";
		}
		
		miLibro = new Libro();
	
	}


	
	/// ************************************************************************
	
	
	
	
	public String getValidacion() {
		return validaciones;
	}

	public String getOpcion() {
		return opcion;
	}

	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}

	public void setValidacion(String validacion) {
		this.validaciones = validacion;
	}
	
	public Libro getMiLibro() {
		return miLibro;
	}

	public void setMiLibro(Libro miLibro) {
		this.miLibro = miLibro;
	}

	public ArrayList<Libro> getListaLibros() {
		return listaLibros;
	}

	public void setListaLibros(ArrayList<Libro> listaLibros) {
		this.listaLibros = listaLibros;
	}


	public String getMensaje() {
		return mensaje;
	}


	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getTextoTraer() {
		return textoTraer;
	}

	public void setTextoTraer(String textoTraer) {
		this.textoTraer = textoTraer;
	}


}
