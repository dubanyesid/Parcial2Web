package co.edu.ufps.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.ufps.util.*;
import co.edu.ufps.dao.CandidatoDao;

/**
 * Servlet implementation class Votante
 */
@WebServlet({"/Votante","/"})
public class Votante extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CandidatoDao candidatoDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Votante() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
    	candidatoDao= ConexionFactory.getUserDao(getServletContext().getInitParameter("base"));
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String path = request.getServletPath();
    			
    			switch (path) {
    			case "/nuevo":
    				mostrarFormulario(request, response);
    				break;
    			case "/insertar":
    				insertar(request, response);
    				break;
    			case "/borrar":
    				eliminar(request,response);
    				break;
    			case "/edicion":
    				mostrarFormularioEdicion(request, response);
    				break;
    			case "/editar":
    				editar(request,response);
    				break;
    			case "/lista":
    				listar(request, response);
    				break;

    			default:
    				listar(request, response);
    				break;
    			}
    		}
    protected void mostrarFormulario(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("usuario.jsp").forward(request, response);
		}
	
	protected void mostrarFormularioEdicion(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
		Usuario usuarioDTO = new Usuario(Integer.parseInt(request.getParameter("id")));
		Usuario usuarioActual = usuarioDAO.usuarioActual(usuarioDTO);
		
		request.setAttribute("user", usuarioActual);
		request.getRequestDispatcher("usuario.jsp").forward(request, response);
		}
	
	protected void insertar(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String pais = request.getParameter("pais");
		Usuario usuarioDTO = new Usuario(nombre, email, pais);
		usuarioDAO.insert(usuarioDTO);
		String mensaje = "Hola "+nombre+" eres de "+pais+" bienvenido";
		mail.enviarEmail(email, "Bienvenida", mensaje);
		response.sendRedirect("listar");
		}
	
	protected void editar(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String pais = request.getParameter("pais");
		Integer id = Integer.parseInt(request.getParameter("id"));
		Usuario usuarioDTO = new Usuario(id,nombre, email, pais);
		usuarioDAO.edit(usuarioDTO);
		response.sendRedirect("listar");
		}
	protected void eliminar(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Usuario usuarioDTO = new Usuario(id);
		usuarioDAO.delete(usuarioDTO);
		response.sendRedirect("listar");
		}
	
	protected void listar(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
				List<Usuario>users= usuarioDAO.listarTodo();
				request.setAttribute("listaUsuarios", users);
		request.getRequestDispatcher("listarUsuario.jsp").forward(request, response);
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
