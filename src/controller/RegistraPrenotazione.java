package controller;

import java.io.IOException;
import java.time.LocalDate;


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
import java.sql.Date;

/**
 * Servlet implementation class RegistraPrenotazione
 */
@WebServlet("/RegistraPrenotazione")
public class RegistraPrenotazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistraPrenotazione() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int idAuto = Integer.valueOf(request.getParameter("idAuto"));
		
		String dataInizio = request.getParameter("DataDiInzio");
		String dataFine = request.getParameter("DataDiFine");
		
		Utente utente =(Utente) request.getSession().getAttribute("Utente");
		Automobile auto = DaoFactory.getDaoFactory().getAutoDao().getAuto(idAuto);
		
		Date inizio = Date.valueOf(dataInizio);
		Date fine = Date.valueOf(dataFine);
		
		if(utente!= null && auto != null) {
			
			Noleggio nuovo = new Noleggio(utente,auto,inizio,fine);
			
			if(DaoFactory.getDaoFactory().getNoleggioDao().addPrenotazione(nuovo)) {
				
				//TODO recap con prezzo
				
				request.setAttribute("Noleggio", nuovo);
				request.getRequestDispatcher(utilita.UtilPath.RECAP_PRENOTAZIONE_PAGE_JSP).forward(request, response);
				
			}else {
				
				request.setAttribute("Auto", auto);
				request.setAttribute("errore", "L'auto non è disponibile per quella data");
				
				
				request.getRequestDispatcher(UtilPath.PRENOTAZIONE_PAGE_JSP).forward(request, response);
				
				
			}
			
			
		}
	
		
		
	}

}
