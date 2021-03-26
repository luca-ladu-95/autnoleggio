package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import model.DataBase;
import model.Utente;
import utilita.UtilPath;
import java.sql.Date;

/**
 * Servlet implementation class RegistrazioneServlet
 */
@WebServlet("/" + UtilPath.REGISTRAZIONE_SERVLET)
public class RegistrazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrazioneServlet() {
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

		String nome = request.getParameter("Nome");
		String cognome = request.getParameter("Cognome");
		String username = request.getParameter("Username");
		String password = request.getParameter("Password");
		String data = request.getParameter("DataDiNascita");
	

		if (utilita.VerificaStringe.areNotNull(nome, cognome, username, password, data)) {

			// convert String to LocalDate
			Date localDate = Date.valueOf(data);

			Utente utente = new Utente(nome, cognome, username, password, localDate);

			if (DaoFactory.getDaoFactory().getUtenteDao().addUtente(utente)) {
				// L'inserimento è andato a buon fine
				//TODO portalo alla homePage
				
				request.setAttribute("successo", "L'utente è stato registrato con successo effettua la login");
				request.getRequestDispatcher(UtilPath.LOGIN_PAGE_JSP).forward(request, response);
				

			}else {
				
				//Utente non esiste
				request.setAttribute("errore", "L'utente è già registrato effettua la login");
				request.getRequestDispatcher(UtilPath.LOGIN_PAGE_JSP).forward(request, response);

			}

		}

	}

}
