package accionesBean;

import java.util.ArrayList;

import dao.LibroDao;
import vo.Libro;

public class Buscador {

	Libro miLibro;
	LibroDao daoLibro;
	ArrayList<Libro> lista = new ArrayList<>();
	String mensaje;
	String textoTraer;
	String opcion;
	
	
	public Buscador(){
		
		miLibro = new Libro();
		daoLibro = new LibroDao();
		
	}

	public void filtrarOpcion(){
		
		lista.clear();
		
		switch(getOpcion()){
	
			case "nombre":
					lista = daoLibro.hallarPorNombre(getTextoTraer());
					break;
					
			case "icbn":
					lista = daoLibro.hallarPorCodigo(getTextoTraer());
					break;		
				
			case "autor":
					lista = daoLibro.hallarPorAutor(getTextoTraer());
					break;
			
			case "categoria":
					lista = daoLibro.hallarPorCategoria(getTextoTraer());
				break;
		}
		
		
		System.out.println("Cantidad de Libros: " + lista.size());
		
	}
		
	
	
	public Libro getMiLibro() {
		return miLibro;
	}


	public void setMiLibro(Libro miLibro) {
		this.miLibro = miLibro;
	}


	public ArrayList<Libro> getLista() {
		return lista;
	}


	public void setLista(ArrayList<Libro> lista) {
		this.lista = lista;
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


	public void setTextoTraer(String letraTraer) {
		this.textoTraer = letraTraer;
	}

	public String getOpcion() {
		return opcion;
	}

	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}


	
}
