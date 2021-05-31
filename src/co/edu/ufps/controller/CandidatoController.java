package co.edu.ufps.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import co.edu.ufps.dao.CandidatoDao;
import co.edu.ufps.model.Candidato;

/**
 * Servlet implementation class CandidatoController
 */
@WebServlet({ "/CandidatoController", "/Candidato" })
public class CandidatoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CandidatoDao candidatoDao;
       
    /**
     * @throws SQLException 
     * @see HttpServlet#HttpServlet()
     */
    public CandidatoController() throws SQLException {
        super();
        candidatoDao = new CandidatoDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Servlet Candidato");
		System.out.println(request);
		System.out.println(response);
		String action = request.getParameter("action");
		System.out.println("action");
		try {
			switch (action) {
			case "index":
				index(request, response);
				break;
			case "nuevo":
				nuevo(request, response);
				break;
			case "register":
				registrar(request, response);
				break;
			case "mostrar":
				mostrar(request, response);
				break;
			case "showedit":
				showEditor(request, response);
				break;
			case "editar":
				editar(request, response);
				break;
			case "eliminar":
				eliminar(request, response);
				break;
			default:
				break;
			}
		} catch (SQLException e) {
			e.getStackTrace();
		}

	}

	private void index(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// mostrar(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher("indexCandidatos.jsp");
		dispatcher.forward(request, response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		Candidato c = new Candidato(Integer.parseInt(request.getParameter("id")), request.getParameter("documento"), request.getParameter("nombre"),
				request.getParameter("apellido"),Integer.parseInt(request.getParameter("eleccion")),Integer.parseInt(request.getParameter("numero")));
		candidatoDao.insertar(c);
		RequestDispatcher dispatcher = request.getRequestDispatcher("indexCandidatos.jsp");
		dispatcher.forward(request, response);
	}

	private void nuevo(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("vistaCandidato/registro.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrar(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("vistaCandidato/mostrar.jsp");
		List<Candidato> list = candidatoDao.list();
		request.setAttribute("lista", list);
		dispatcher.forward(request, response);
	}

	private void showEditor(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		Candidato c = candidatoDao.buscar(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("candidato", c);

		RequestDispatcher dispatcher = request.getRequestDispatcher("vistaCandidato/editar.jsp");
		dispatcher.forward(request, response);
	}

	private void editar(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		Candidato c = new Candidato(Integer.parseInt(request.getParameter("id")), request.getParameter("documento"), request.getParameter("nombre"),
				request.getParameter("apellido"),Integer.parseInt(request.getParameter("eleccion")),Integer.parseInt(request.getParameter("numero")));
		candidatoDao.actualizar(c);
		index(request, response);
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		Candidato c = candidatoDao.buscar(Integer.parseInt(request.getParameter("id")));
		candidatoDao.eliminar(c.getId());
		RequestDispatcher dispatcher = request.getRequestDispatcher("indexCandidato.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
