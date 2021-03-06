package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.PerfilUsuarioDao;

@ManagedBean
@ViewScoped
public class PerfilUsuario {

	
	PerfilUsuarioDao daoPerfil;
	String contraseniaActual;
	String contraseniaNueva;
	String validacionContraseniaActual;
	String validacionContraseniaNueva;
	String mensaje;
	
	
	public PerfilUsuario(){
		
		daoPerfil = new PerfilUsuarioDao();

	}
	
	
	public void verificarContraseniaUsuario(){
		
		System.out.println("estamos en el metodo verificarContraseniaUsuario() / PerfilUsuario");
		
		if(getContraseniaActual().equals("")){
			
			System.out.println("El campo Contraseņa Actual esta vacio !!");
			validacionContraseniaActual = "No se puede cambiar la contraseņa por que el campo Nueva Contraseņa esta vacio";
			
		}else{
		
			boolean verificacion = daoPerfil.verificarContrasenia(getContraseniaActual());
			
			if(verificacion != false){
				System.out.println("<condicion> ( verificarContraseniaUsuario() )");
				
				cambiarContraseniaUsuario();	
				
			}else{
				System.out.println("La contraseņa no se puede cambiar por que la contraseņa actual no es la correcta");
				validacionContraseniaActual = "La contraseņa no se puede cambiar por que la CONTRASEŅA ACTUAL no es la correcta";
			}
		}
		
	}


	public void cambiarContraseniaUsuario(){
		System.out.println("Estamos en el metodo cambiarContraseniaUsuario() / PerfilUsuario");
		
		if(contraseniaNueva.equals("")){
			System.out.println("<condicion> ( cambiarContraseniaUsuario() )");
			System.out.println("No se puede cambiar la contraseņa por que el campo nueva contraseņa esta vacio");
			
			validacionContraseniaNueva = "No se puede cambiar la contraseņa por que el campo Contraseņa Actual esta vacio";
		
		}else{
			
			String resultado = daoPerfil.cambiarContrasenia(getContraseniaNueva(), getContraseniaActual());
			
			if(resultado.equals("ok")){
				
				System.out.println("<condicion <condicion>> ( cambiarContraseniaUsuario() )");
				mensaje = "La contraseņa fue actualizada con exito !!";
				
			}else{
				mensaje = "hubo un error vuelve a intentarlo";
				System.out.println("Error en la base de datos !!");
			}
		
		}
		
		
	}
	
	
	
	

	public String getValidacionContraseniaNueva() {
		return validacionContraseniaNueva;
	}


	public void setValidacionContraseniaNueva(String validacionContraseniaNueva) {
		this.validacionContraseniaNueva = validacionContraseniaNueva;
	}


	public String getMensaje() {
		return mensaje;
	}


	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


	public String getValidacionContraseniaActual() {
		return validacionContraseniaActual;
	}


	public void setValidacionContraseniaActual(String validacionContraseniaActual) {
		this.validacionContraseniaActual = validacionContraseniaActual;
	}


	public String getContraseniaActual() {
		return contraseniaActual;
	}


	public void setContraseniaActual(String contraseniaActual) {
		this.contraseniaActual = contraseniaActual;
	}


	public String getContraseniaNueva() {
		return contraseniaNueva;
	}


	public void setContraseniaNueva(String contraseniaNueva) {
		this.contraseniaNueva = contraseniaNueva;
	}
	
}
