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
import model.Noleggio;
import model.Utente;
import utilita.UtilPath;

/**
 * Servlet implementation class LeTuePrenotazioniServlet
 */
@WebServlet("/LeTuePrenotazioniServlet")
public class LeTuePrenotazioniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LeTuePrenotazioniServlet() {
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

			List<Noleggio> noleggi = DaoFactory.getDaoFactory().getNoleggioDao().getPrenotazioniUtente(utente.getPERSONAL_ID());
					

			request.setAttribute("Noleggi", noleggi);
			request.getRequestDispatcher(utilita.UtilPath.LE_TUE_PRENOTAZIONI_PAGE_JSP).forward(request, response);

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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
