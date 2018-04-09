package vo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped

public class PrestamoLibroVo {

	private int codigoLibro;
	private String documento;
	private String fechaPrestamo;
	private String fechaRegreso;
	private String nombreUsuario;
	private String nombreLibro;
	private String tipo_sancion;
	private String infoObservaciones;
	private String fecha_inicioSancion;
	private String fecha_finSancion;
	private String estadoPrestamo = "activo";
	
	public PrestamoLibroVo(){
		
	}
	
	public PrestamoLibroVo(int codigoLibro,String documento,String fechaPrestamo,String fechaRegreso, 
			String nombreUsuario, String nombreLibro, String tipo_sancion, String infoObservaciones, String fecha_inicioSancion, String fecha_finSancion, 
			String estadoPrestamo){
		super();
		
		this.codigoLibro=codigoLibro;
		this.documento=documento;
		this.fechaPrestamo=fechaPrestamo;
		this.fechaRegreso=fechaRegreso;
		this.nombreUsuario=nombreUsuario;
		this.nombreLibro=nombreLibro;
		this.tipo_sancion=tipo_sancion;
		this.infoObservaciones=infoObservaciones;
		this.fecha_inicioSancion=fecha_inicioSancion;
		this.fecha_finSancion=fecha_finSancion;
		this.estadoPrestamo=estadoPrestamo;
		
	}
	

	
	
	
	public String getEstadoPrestamo() {
		return estadoPrestamo;
	}

	public void setEstadoPrestamo(String estadoPrestamo) {
		this.estadoPrestamo = estadoPrestamo;
	}

	public String getFecha_inicioSancion() {
		return fecha_inicioSancion;
	}

	public void setFecha_inicioSancion(String fecha_inicioSancion) {
		this.fecha_inicioSancion = fecha_inicioSancion;
	}

	public String getFecha_finSancion() {
		return fecha_finSancion;
	}

	public void setFecha_finSancion(String fecha_finSancion) {
		this.fecha_finSancion = fecha_finSancion;
	}

	public String getTipo_sancion() {
		return tipo_sancion;
	}

	public void setTipo_sancion(String tipo_sancion) {
		this.tipo_sancion = tipo_sancion;
	}

	public String getInfoObservaciones() {
		return infoObservaciones;
	}

	public void setInfoObservaciones(String infoObservaciones) {
		this.infoObservaciones = infoObservaciones;
	}

	public int getCodigoLibro() {
		return codigoLibro;
	}

	public void setCodigoLibro(int codigoLibro) {
		this.codigoLibro = codigoLibro;
	}

	
	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getFechaPrestamo() {
		return fechaPrestamo;
	}
	
	public void setFechaPrestamo(String fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public String getFechaRegreso() {
		return fechaRegreso;
	}

	public void setFechaRegreso(String fechaRegreso) {
		this.fechaRegreso = fechaRegreso;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombreLibro() {
		return nombreLibro;
	}

	public void setNombreLibro(String nombreLibro) {
		this.nombreLibro = nombreLibro;
	}	
	
}
