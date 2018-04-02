package bean;

import java.util.ArrayList;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import dao.PrestamoLibroDao;

import vo.PrestamoLibroVo;

@ManagedBean
@SessionScoped
public class TablaBean {
	private PrestamoLibroVo miLibro;
	private PrestamoLibroDao miLibroDao;
	private String respuesta;
	private boolean datosDevolver;
	
	private String codigoUsuario;
	private String devolverLibroSancion;

	ArrayList <PrestamoLibroVo> listaDevolucionLibros = new ArrayList <> ();
	
	public TablaBean(){
		miLibro=new PrestamoLibroVo();
		miLibroDao=new PrestamoLibroDao();
	}
	
	public void registraPrestamo(){
		respuesta = miLibroDao.agregarprestamo(miLibro);
		
		if(respuesta.equalsIgnoreCase("registro exitoso")){
			respuesta = "se registro satisfactoriamente";
		}else{
			respuesta = "no se pudo registra, Intentelo nuevamente";
		}
	
	}
	
	public void RevisionDevolverLibro(){
		
		listaDevolucionLibros.clear();
		
		listaDevolucionLibros = miLibroDao.devolver(miLibro.getDocumento());
		
		if(listaDevolucionLibros.size() == 0){
			datosDevolver= false;
			
			System.out.println("No hay datos de registro");
			
		}else{
			datosDevolver = true;
			
		}
		
		
	}
	
	public void devolverLibro(){
		
	
		
		devolverLibroSancion= miLibroDao.devolverLibroSancion(miLibro);
		
		if(devolverLibroSancion.equalsIgnoreCase("registro exitoso")){
			System.out.println("registro exitoso de la sancion");
		}else{
			System.out.println("error al registrar sancion");
		}
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
