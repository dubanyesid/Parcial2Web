package co.edu.ufps.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.ufps.model.*;
import co.edu.ufps.dao.*;
/**
 * Servlet implementation class Votante
 */
@WebServlet({"/Votante","/"})
public class VotanteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GenericDao nVotante;
	private GenericDao nEstamento;
	private GenericDao nTipo;
	private GenericDao nEleccion;
	

    public VotanteController() {
        super();      
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

		System.out.println(action);

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insert(request, response);
				break;
			case "/delete":
				delete(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				update(request, response);
				break;
			default:
				list(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("votante.jsp");

		List<Estamento> e = nEstamento.list();
		request.setAttribute("e", e);
		
		List<TipoDocumento> tipo = nTipo.list();
		request.setAttribute("tipo", tipo);
		
		List<Eleccion> elec = nEleccion.list();
		request.setAttribute("elec", elec);
		
		dispatcher.forward(request, response);
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {

		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String documento = request.getParameter("documento");
		int tipodocumento = Integer.parseInt(request.getParameter("tipodocumento"));
		int eleccion = Integer.parseInt(request.getParameter("eleccion"));

		Votante votante = new Votante(nombre, email, documento, tipodocumento, eleccion);

		nVotante.insertar(votante);
		response.sendRedirect("list");
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)	throws SQLException, ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		Votante votante =  (Votante) nVotante.buscar(id);
		
		//*****
		List<Estamento> e = nEstamento.list();
		request.setAttribute("estamento", e);
		
		List<TipoDocumento> tipo = nTipo.list();
		request.setAttribute("tipoDocumento", tipo);
		
		List<Eleccion> elec = nEleccion.list();
		request.setAttribute("eleccion", elec);
		
		request.setAttribute("Votante", votante);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("votante.jsp");		
		dispatcher.forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String documento = request.getParameter("documento");
		int tipodocumento = Integer.parseInt(request.getParameter("tipodocumento"));
		int eleccion = Integer.parseInt(request.getParameter("eleccion"));

		Votante votante = new Votante(nombre, email, documento, tipodocumento, eleccion);

		nVotante.actualizar(votante);
		response.sendRedirect("list");
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		nVotante.eliminar(id);
		response.sendRedirect("list");
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
		
		List<Votante> listV = nVotante.list();

		request.setAttribute("listV", listV);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("listVotante.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
}
