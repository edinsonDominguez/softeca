package conexion;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class PruebaConexion
 */
@WebServlet("/PruebaConexion")
public class PruebaConexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PruebaConexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
															throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		java.sql.Connection connection=null;
		Conexion miConexion=new Conexion();
		PreparedStatement statement=null;
		java.sql.ResultSet result=null;
		
		try {
			connection=miConexion.getConexion();
		
			String consulta = "SELECT * FROM usuario;";
			if (connection!=null) {
				statement=(PreparedStatement) connection.prepareStatement(consulta);
				result=statement.executeQuery();
				
				while(result.next()){
					
					String datos=" "+result.getInt("idUsuario")+" - "+result.getString("nombreUsuario")+"<br/>";
					response.getWriter().append(datos);
					System.out.println(datos);
					System.out.println("Conexion exitosa");
				}		
				   miConexion.desconectar();
			}else{
				response.getWriter().append("Verifique que Mysql esté encendido...");
			}

		} catch (Exception exc) {
			exc.printStackTrace();
			response.getWriter().append(exc.getMessage());
		}
	}

}
