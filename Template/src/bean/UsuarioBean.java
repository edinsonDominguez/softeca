package bean;

import java.util.ArrayList;


import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;

import dao.UsuarioDao;
import vo.UsuarioVo;


@ViewScoped
@ManagedBean
public class UsuarioBean {
	
		private UsuarioVo miUsuarioVo;
		private UsuarioDao miUsuarioDao;
		private String respuesta;
		private String mjsListaUsuario;
		private String mjsUsuario;
	
		private String docUsuario;
		ArrayList <UsuarioVo> listaUsuario =  new ArrayList<>();
		
	

	


	public  UsuarioBean(){
		miUsuarioVo = new UsuarioVo();
		miUsuarioDao = new UsuarioDao();
			
	}
	

	public void registrarUsuario(){

		
		respuesta=miUsuarioDao.agregarUsuario(miUsuarioVo);
		if(respuesta.equalsIgnoreCase("Registro exitoso")){
			respuesta="El usuario a sido registrado exitosamente";
			//
		}else{
			respuesta="No se puedo realizar el registro, Por favor intentelo nuevamente.";
			//
		}
		
		miUsuarioVo = new UsuarioVo();
	}
	
	public void consultaIndividual(){
	
	listaUsuario.clear();
		
	listaUsuario = miUsuarioDao.consultarUsuario(getDocUsuario());
	
	if(listaUsuario.size() == 0){
	
		mjsListaUsuario="El usuario con documento: "+getDocUsuario()+" No se encuentra registrado!";
		System.out.println("NO HAY DATOS");
		System.out.println(getMjsListaUsuario());
		
	}else{
		
	}
			
	}
	
	public String EditarUsuario(UsuarioVo miUsuario){
		mjsUsuario="ingresa";
		miUsuario.setEditar(true);
		return "index";
	}
	
	public void guardarCambiosUsuario(UsuarioVo miUsuario){
		setmjsUsuario(miUsuarioDao.actualizarUsuario(miUsuario));
		
		String validacion = getmjsUsuario();
		
		if(validacion.equals("error")){
			validacion="no guardo cambios";
		}
		
		miUsuario.setEditar(false);
	}
	
	public void EliminarUsuario(UsuarioVo miUsuario){
		setmjsUsuario(miUsuarioDao.eliminarUsuario(miUsuario));
		listaUsuario.remove(miUsuario);
	}
	
	public String getMjsListaUsuario() {
		return mjsListaUsuario;
	}


	public void setMjsListaUsuario(String mjsListaUsuario) {
		this.mjsListaUsuario = mjsListaUsuario;
	}
	
	
	public ArrayList<UsuarioVo> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(ArrayList<UsuarioVo> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	
	public String getDocUsuario() {
		return docUsuario;
	}

	public void setDocUsuario(String docUsuario) {
		this.docUsuario = docUsuario;
	}
	
	
	public UsuarioVo getMiUsuarioVo() {
		return miUsuarioVo;
	}
	public void setMiUsuarioVo(UsuarioVo miUsuarioVo) {
		this.miUsuarioVo = miUsuarioVo;
	}
	public UsuarioDao getMiUsuarioDao() {
		return miUsuarioDao;
	}
	public void setMiUsuarioDao(UsuarioDao miUsuarioDao) {
		this.miUsuarioDao = miUsuarioDao;
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}


	public String getmjsUsuario() {
		return mjsUsuario;
	}


	public void setmjsUsuario(String mjsUsuario) {
		this.mjsUsuario = mjsUsuario;
	}
	
	
		
}
