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
import model.Categoria;
import model.DataBase;
import model.Utente;

/**
 * Servlet implementation class NuovaAutoServlet
 */
@WebServlet("/NuovaAutoServlet")
public class NuovaAutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuovaAutoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Utente utente = (Utente)request.getSession().getAttribute("Utente");
		
		if(utente!=null && utente.getUsername().equals("admin")) {
		List<Categoria> categorie = DaoFactory.getDaoFactory().getCategoriaDao().getCategorie();	
		request.setAttribute("Categorie", categorie);
		request.getRequestDispatcher(utilita.UtilPath.NUOVA_AUTO_PAGE_JSP).forward(request, response);
		}else {
			
			request.setAttribute("errore", "L'utente non è abilitato");
			request.getRequestDispatcher(UtilPath.LOGIN_PAGE_JSP).forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
