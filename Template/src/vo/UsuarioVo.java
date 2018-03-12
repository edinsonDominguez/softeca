package vo;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class UsuarioVo {
	private String nombre;
	private String apellidos;
	private String tipo_Usuario;
	private String documento;
	private String direccion;
	private String telefono;
	private String fecha;
	private String contrasenia;
	private String correo;
	private boolean editar;
	


	public UsuarioVo(){
		
	}
	
	public UsuarioVo(String nombre, String apellidos, String tipo_Usuario, String documento, String direccion,
			String telefono, String fecha, String contrasenia, String correo, boolean editar){
		super();
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.tipo_Usuario=tipo_Usuario;
		this.documento=documento;
		this.direccion=direccion;
		this.telefono=telefono;
		this.fecha=fecha;
		this.contrasenia=contrasenia;
		this.correo=correo;
		this.editar=editar;
	}
	
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getTipo_Usuario() {
		return tipo_Usuario;
	}


	public void setTipo_Usuario(String tipo_Usuario) {
		this.tipo_Usuario = tipo_Usuario;
	}


	


	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public boolean isEditar() {
		return editar;
	}

	public void setEditar(boolean editar) {
		this.editar = editar;
	}


	

	
}
