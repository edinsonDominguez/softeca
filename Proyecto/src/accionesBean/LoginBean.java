package accionesBean;



import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.PersonaDao;
import vo.PersonaVo;

@ManagedBean
@ViewScoped
public class LoginBean {
	
	String resp="";
	
	private PersonaVo miPersonaVo;
	PersonaDao miPersonaDao;
	private String mensaje;
	private String navegacion;
	private String docUsuario;
	private String passwordUsuario;

	
	public LoginBean(){

		miPersonaVo=new PersonaVo();
		miPersonaDao=new PersonaDao();
		
	}
	
public String ingresoUsuario(){
		
		
		System.out.println("*****************************************************");
		System.out.println("Contraseña: " + miPersonaVo.getContraseniaUsuario());
		//System.out.println("Documento: "+ getDocUsuario());
		System.out.println("Desde el vo : "+ miPersonaVo.getDocumento()+ " " + miPersonaVo.getContraseniaUsuario());
		
		PersonaVo persona=miPersonaDao.consultarUsuarioLogin(miPersonaVo.getDocumento(), miPersonaVo.getContraseniaUsuario());
		
		if (persona!=null) {
			
			mensaje="";
			miPersonaVo=persona;
			//System.out.println("USUARIO VALIDO: "+miBean.getUsuario()+" "+ miBean.getContrasena());
			System.out.println("Ingresa : "+ miPersonaVo.getNombre()+ " " + miPersonaVo.getContraseniaUsuario() + " tipo usuario: " + miPersonaVo.getTipoUsuario());
			
			if(miPersonaVo.getTipoUsuario().equals("1")){
				System.out.print("Ingresa al sistema y es administrador");
				resp="editar_Eliminar.jsf";
			}else{				
				System.out.println("Ingresa al sistema pero es usuario");
				resp="usuario_Consulta.jsf";		
			}
		}else{
			resp="#";
			mensaje="El usuario no es Valido, Verifique nuevamente...";
			System.out.println("USUARIO NO VALIDO");
		}
		
		System.out.println("*****************************************************");
		return resp;
	}

	
	
	

	public String getDocUsuario() {
	return docUsuario;
}

public void setDocUsuario(String docUsuario) {
	this.docUsuario = docUsuario;
}

public String getPasswordUsuario() {
	return passwordUsuario;
}

public void setPasswordUsuario(String passwordUsuario) {
	this.passwordUsuario = passwordUsuario;
}

	public PersonaVo getMiPersonaVo() {
		return miPersonaVo;
	}

	public void setMiPersonaVo(PersonaVo miPersonaVo) {
		this.miPersonaVo = miPersonaVo;
	}

	public PersonaDao getMiPersonaDao() {
		return miPersonaDao;
	}

	public void setMiPersonaDao(PersonaDao miPersonaDao) {
		this.miPersonaDao = miPersonaDao;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getNavegacion() {
		return navegacion;
	}

	public void setNavegacion(String navegacion) {
		this.navegacion = navegacion;
	}

	public String getResp() {
		return resp;
	}

	public void setResp(String resp) {
		this.resp = resp;
	}
	
	
}
