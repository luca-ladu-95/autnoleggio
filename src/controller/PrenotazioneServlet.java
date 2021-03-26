package controller;

import java.io.IOException;
import java.util.Optional;

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
 * Servlet implementation class PrenotazioneServlet
 */
@WebServlet("/PrenotazioneServlet")
public class PrenotazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrenotazioneServlet() {
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
	
		int idAuto = Integer.valueOf(request.getParameter("IdAuto"));
		
		
		
		
		
		
		Utente utente = (Utente) request.getSession().getAttribute("Utente");
		Automobile auto = DaoFactory.getDaoFactory().getAutoDao().getAuto(idAuto);
		
		if(utente!= null) {
			
			request.setAttribute("Auto",auto);
			request.getRequestDispatcher(UtilPath.PRENOTAZIONE_PAGE_JSP).forward(request, response);;
			
			
		}else {
			
			response.sendRedirect(utilita.UtilPath.LOGIN_PAGE_JSP);
		}
		
	}

}
