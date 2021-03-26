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
import utilita.DataConversion;
import utilita.UtilPath;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/" + utilita.UtilPath.LOGIN_SERVLET)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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

		String username = request.getParameter("Username");
		String password = request.getParameter("Password");
		
//	Utente admin = new Utente("Luca", "Ladu", "admin", "admin", DataConversion.conversione("14/03/1995"));
//
//	DataBase.getInstance().addUtente(admin);
//		//Fine test

		if (utilita.VerificaStringe.areNotNull(username, password)) {

			Utente utente = DaoFactory.getDaoFactory().getUtenteDao().isRegistrato(username, password);

			if (username.equals("admin") && password.equals("admin")) {
				List<Noleggio> prenotazioni = DaoFactory.getDaoFactory().getNoleggioDao().getPrenotazioni();
				request.setAttribute("Noleggi", prenotazioni);
				request.getSession().setAttribute("Utente", utente);
				request.getRequestDispatcher(utilita.UtilPath.HOME_PAGE_ADMIN_JSP).forward(request, response);

			}

			else if (utente != null) {
				request.getSession().setAttribute("Utente", utente);
				request.getRequestDispatcher(utilita.UtilPath.HOME_PAGE_SERVLET).forward(request, response);
			} else {
				//Utente non esiste
				request.setAttribute("errore", "L'utente non esiste");
				request.getRequestDispatcher(UtilPath.LOGIN_PAGE_JSP).forward(request, response);

			}

		}

	}

}
