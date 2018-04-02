package vo;

public class Reporte {
	
	
	String idUsuario;
	String nombreUsuario;
	String fechaPrestamo;
	String fechaRegreso;
	boolean sancionPrestamo;
	
	String tituloLibro;
	
	
	
	public String getTituloLibro() {
		return tituloLibro;
	}
	public void setTituloLibro(String tituloLibro) {
		this.tituloLibro = tituloLibro;
	}
	
	
	public boolean isSancionPrestamo() {
		return sancionPrestamo;
	}
	public void setSancionPrestamo(boolean sancionPrestamo) {
		this.sancionPrestamo = sancionPrestamo;
	}
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
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
	
	
	
	
	
}
