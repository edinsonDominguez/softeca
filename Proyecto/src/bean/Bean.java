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
			 mensaje="el usuario no existe";
			 
			
			if(miUsuario.getContrasenia() == getContrasena()){
				System.out.println("el usuario puede ingresar");
				mensaje="el usuario puede ingresar";
				
			} else{
				
			}
			
		}else{
			System.out.println("el usuario no existe !!");
		}
		
		
	}
	
	public void busquedaUsuarioPrueba(){
		System.out.println("Ingresa a la prueba");
		UsuarioVo miUsuario = new UsuarioVo();
		String respuestaLogin = daoPersona.pruebaIngresoLogin(getUsuario());
		
		if(respuestaLogin.equalsIgnoreCase("ingreso correcto")){
			System.out.println("Ingreso correcto login");
			mensaje = "no";
			
			if(miUsuario.getContrasenia() == getContrasena()){
				System.out.println("Campos exitosos puede ingresar");
				
				mensaje ="si";
				
			}else{
				System.out.println("No puede ingresar campos incorrectos");
			}
			
			
			
		}else{
			System.out.println("Ingreso incorrecto en el login");
		}
	}
	
}
