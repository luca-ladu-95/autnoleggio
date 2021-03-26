package controller;
import utilita.UtilPath;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import model.Automobile;
import model.DataBase;
import model.Utente;
import utilita.UtilPath;

/**
 * Servlet implementation class HomePageServlet
 */
@WebServlet("/HomePageServlet")
public class HomePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomePageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		

		Utente utente =(Utente) request.getSession().getAttribute("Utente");

		if (utente != null) {

			List<Automobile> automobiliDisponibili = DaoFactory.getDaoFactory().getAutoDao().getAutomobili();

			request.setAttribute("Automobili", automobiliDisponibili);
			request.getRequestDispatcher(utilita.UtilPath.HOME_PAGE_JSP).forward(request, response);
			

		} else {

			response.sendRedirect(UtilPath.LOGIN_PAGE_JSP);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Utente utente =(Utente) request.getSession().getAttribute("Utente");

		if (utente != null) {

			List<Automobile> automobiliDisponibili = DaoFactory.getDaoFactory().getAutoDao().getAutomobili();

			request.setAttribute("Automobili", automobiliDisponibili);
			request.getRequestDispatcher(utilita.UtilPath.HOME_PAGE_JSP).forward(request, response);

		} else {

			response.sendRedirect(UtilPath.LOGIN_PAGE_JSP);
		}

	}

}
