package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Utente;
import utilita.UtilPath;

/**
 * Servlet implementation class NuovaCategoriaServlet
 */
@WebServlet("/NuovaCategoriaServlet")
public class NuovaCategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NuovaCategoriaServlet() {
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
			request.getRequestDispatcher(utilita.UtilPath.NUOVA_CATEGORIA_JSP).forward(request, response);
		}else {
			
			request.setAttribute("errore", "L'utente non è abilitato");
			request.getRequestDispatcher(UtilPath.LOGIN_PAGE_JSP).forward(request, response);
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
