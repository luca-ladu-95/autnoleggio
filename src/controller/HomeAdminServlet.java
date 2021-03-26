package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import model.DataBase;
import model.Noleggio;
import model.Utente;
import utilita.UtilPath;

/**
 * Servlet implementation class HomeAdminServlet
 */
@WebServlet("/HomeAdminServlet")
public class HomeAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeAdminServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Utente utente = (Utente) request.getSession().getAttribute("Utente");

		if (utente != null && utente.getUsername().equals("admin")) {
			
			List<Noleggio> prenotazioni = DaoFactory.getDaoFactory().getNoleggioDao().getPrenotazioni();
			request.setAttribute("Noleggi", prenotazioni);
			request.getRequestDispatcher(utilita.UtilPath.HOME_PAGE_ADMIN_JSP).forward(request, response);

		} else {
			request.setAttribute("errore", "L'utente non esiste");
			request.getRequestDispatcher(UtilPath.LOGIN_PAGE_JSP).forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Utente utente = (Utente) request.getSession().getAttribute("Utente");

		if (utente != null && utente.getUsername().equals("admin")) {
			
			List<Noleggio> prenotazioni = DaoFactory.getDaoFactory().getNoleggioDao().getPrenotazioni();
			request.setAttribute("Noleggi", prenotazioni);
			request.getRequestDispatcher(utilita.UtilPath.HOME_PAGE_ADMIN_JSP).forward(request, response);

		} else {
			request.setAttribute("errore", "L'utente non esiste");
			request.getRequestDispatcher(UtilPath.LOGIN_PAGE_JSP).forward(request, response);
		}
	}

}
