package vo;

import javax.faces.bean.ManagedBean;


public class PersonaVo {

	private String documento;
	private String nombre;
	private String Apellido;
	private String direccion;
	private String telefono;
	private String nacimientoUsuario;
	private String contraseniaUsuario;
	private String tipoUsuario;
	private String correoUsuario;
	
	
	public PersonaVo(){ 	}
	
	public PersonaVo(String documento,String nombre, String apellido,String direccion, String telefono, String nacimiento, 
			String contrasenia, String tipoUsuario, String correoUsuario) {
		super();
		this.documento=documento;
		this.nombre = nombre;
		this.Apellido = apellido;
		this.direccion = direccion;
		this.telefono = telefono;
		this.nacimientoUsuario = nacimiento;
		this.contraseniaUsuario = contrasenia;
		this.correoUsuario = correoUsuario;
		this.tipoUsuario = tipoUsuario;
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

	public String getNacimientoUsuario() {
		return nacimientoUsuario;
	}

	public void setNacimientoUsuario(String nacimientoUsuario) {
		this.nacimientoUsuario = nacimientoUsuario;
	}

	public String getContraseniaUsuario() {
		return contraseniaUsuario;
	}

	public void setContraseniaUsuario(String contraseniaUsuario) {
		this.contraseniaUsuario = contraseniaUsuario;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getCorreoUsuario() {
		return correoUsuario;
	}

	public void setCorreoUsuario(String correoUsuario) {
		this.correoUsuario = correoUsuario;
	}

	public String getDocumento() { return documento; }

	public void setDocumento(String documento) { this.documento = documento; }
	
			
	public String getNombre() { return nombre; }

	public void setNombre(String nombre) {	this.nombre = nombre;}

	public String getApellido() {	return Apellido;	}

	public void setApellido(String apellido) {	Apellido = apellido;	}


	
}
