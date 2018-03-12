package vo;

public class Libro {

	private int codigo;
	private String titulo;
	private String autor;
	private String editorial;
	private String estanteria;
	private int ejemplar;
	private int categoria;
	private String nombreCategoria = "None";
	boolean editar;
	
	public Libro(){
		
	}
	
	
	public Libro(int codigo, String titulo, String autor, String editorial, String estanteria, int ejemplar,
			int miCategoria, String nombreCategoria, boolean editar) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.estanteria = estanteria;
		this.ejemplar = ejemplar;
		this.categoria = miCategoria;
		this.nombreCategoria = nombreCategoria;
		this.editar = editar;
	}
	
	
	public String getNombreCategoria() {
		return nombreCategoria;
	}


	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}


	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public String getEstanteria() {
		return estanteria;
	}
	public void setEstanteria(String estanteria) {
		this.estanteria = estanteria;
	}
	public int getEjemplar() {
		return ejemplar;
	}
	public void setEjemplar(int ejemplar) {
		this.ejemplar = ejemplar;
	}
	public int getMiCategoria() {
		return categoria;
	}
	public void setMiCategoria(int miCategoria) {
		this.categoria = miCategoria;
	}


	public boolean isEditar() {
		return editar;
	}


	public void setEditar(boolean editar) {
		this.editar = editar;
	}
	


}
