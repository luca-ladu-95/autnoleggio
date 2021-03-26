package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import model.Automobile;
import model.DataBase;
import model.Utente;

/**
 * Servlet implementation class FilterServlet
 */
@WebServlet("/FilterServlet")
public class FilterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FilterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
		String valoreFiltro = request.getParameter("filtro").trim();
		String filtro = request.getParameter("Ricerca");

		Utente utente =(Utente) request.getSession().getAttribute("Utente");

		List<Automobile> automobili = DaoFactory.getDaoFactory().getAutoDao().getAutomobili();
		List<Automobile> ritorno = null;

		if (filtro != null) {
			switch (valoreFiltro.toUpperCase()) {
			case "MARCA":
				ritorno = DaoFactory.getDaoFactory().getAutoDao().getAutoMarca(filtro);
				break;
			case "MODELLO":
				ritorno = DaoFactory.getDaoFactory().getAutoDao().getAutoModello(filtro);
				break;
			case "COLORE":
				ritorno = DaoFactory.getDaoFactory().getAutoDao().getAutoColore(filtro);
				break;
			case "CATEGORIA":
				ritorno = DaoFactory.getDaoFactory().getAutoDao().getAutoCategoria(filtro);
				break;
			default:
				ritorno = automobili;

			}

		} else {

			ritorno = automobili;
		}

		request.setAttribute("Automobili", ritorno);
	
		if (utente.getUsername().equals("admin") && utente.getPassword().equals("admin")) {

			request.getRequestDispatcher(utilita.UtilPath.GARAGE_PAGE_JSP).forward(request, response);
		} else {
			request.getRequestDispatcher(utilita.UtilPath.HOME_PAGE_JSP).forward(request, response);
		}

	}

}
