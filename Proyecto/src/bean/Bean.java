package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.PersonaDao;
import vo.UsuarioVo;

@ManagedBean
@ViewScoped
public class Bean {

	
	PersonaDao daoPersona;
	String usuario;
	String contrasena;
	String mensaje;
	
	public Bean(){
	
		System.out.println("Estamos en la clase bean !!");
		daoPersona = new PersonaDao();
		
	}
	
	public void setUsuario(String usuario){
		this.usuario = usuario;
	}
	
	public String getUsuario(){
		return usuario;
	}
	
	public void setContrasena(String contrasena){
		this.contrasena = contrasena;
	}
	
	public String getContrasena(){
		return contrasena;
	}
	
	public void setMensaje(String mensaje){
		this.mensaje = mensaje;
	}
	
	public String getMensaje(){
		return mensaje;
	}
	
	public void buscarUsuario(){
		
		System.out.println("Presionaste en la accion de buscar usuario");
		
		UsuarioVo miUsuario = daoPersona.ingresoCredenciales(getUsuario()); 
		
		if(miUsuario != null){
			
			if(miUsuario.getContrasenia() == getContrasena()){
				System.out.println("el usuario puede ingresar");
				
			}
			
		}else{
			System.out.println("el usuario no existe !!");
		}
		
		
	}
	
}