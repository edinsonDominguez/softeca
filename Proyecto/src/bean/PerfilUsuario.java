package bean;

import javax.faces.bean.ManagedBean;

import dao.PerfilUsuarioDao;

@ManagedBean
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
		
		String documento = "0000";
		
		boolean verificacion = daoPerfil.verificarContrasenia(getContraseniaActual(), documento);
		
		if(verificacion != false){
			System.out.println("<condicion> ( verificarContraseniaUsuario() )");
			
			cambiarContraseniaUsuario();	
			
		}else{
			System.out.println("La contraseña no se puede cambiar por que la contraseña actual no es la correcta");
			validacionContraseniaActual = "La contraseña no se puede cambiar por que la CONTRASEÑA ACTUAL no es la correcta";
		}
		
	}


	public void cambiarContraseniaUsuario(){
		System.out.println("Estamos en el metodo cambiarContraseniaUsuario() / PerfilUsuario");
		
		if(contraseniaActual.equals("")){
			System.out.println("<condicion> ( cambiarContraseniaUsuario() )");
			System.out.println("No se puede cambiar la contraseña por que el campo nueva contraseña esta vacio");
			
			validacionContraseniaNueva = "No se puede cambiar la contraseña por que el campo contraseña actual esta vacio";
		
		}else{
			
			String resultado = daoPerfil.cambiarContrasenia(getContraseniaNueva(), getContraseniaActual());
			
			if(resultado.equals("ok")){
				
				System.out.println("<condicion <condicion>> ( cambiarContraseniaUsuario() )");
				mensaje = "la contraseña fue actualizada con exito !!";
				
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
		this.contraseniaActual = contraseniaNueva;
	}
	
}
