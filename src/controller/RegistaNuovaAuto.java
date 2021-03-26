package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import model.Automobile;
import model.Categoria;
import model.DataBase;
import utilita.TargaGenerator;

/**
 * Servlet implementation class RegistaNuovaAuto
 */
@WebServlet("/RegistraNuovaAuto")
public class RegistaNuovaAuto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistaNuovaAuto() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idCategoria = Integer.valueOf(request.getParameter("Categoria"));
		String modello = request.getParameter("Modello");
		String marca = request.getParameter("Marca");
		String colore = request.getParameter("Colore");
		
		if(utilita.VerificaStringe.areNotNull(modello,marca,colore)) {
			
			Categoria cat =DaoFactory.getDaoFactory().getCategoriaDao().getGategoria(idCategoria);
			
			if(cat != null) {
			
			//new Automobile("Bentley", "Continental", TargaGenerator.getSaltString(), luxury, "BLU")
			Automobile auto = new Automobile(marca,modello,utilita.TargaGenerator.getSaltString(),cat,colore.toUpperCase());
			
			
			DaoFactory.getDaoFactory().getAutoDao().addAutomobile(auto);
			
			//TODO riportalo al garage
			
			List<Categoria> categorie = DaoFactory.getDaoFactory().getCategoriaDao().getCategorie();	
			request.setAttribute("Categorie", categorie);
			request.setAttribute("successo", "Auto inserita correttamente!");
			request.getRequestDispatcher(utilita.UtilPath.NUOVA_AUTO_PAGE_JSP).forward(request, response);
			
			
			
			}
			
		}
		
	}

}
