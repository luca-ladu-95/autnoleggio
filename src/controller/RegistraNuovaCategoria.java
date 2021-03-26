package controller;

import java.io.IOException;
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
 * Servlet implementation class RegistraNuovaCategoria
 */
@WebServlet("/RegistraNuovaCategoria")
public class RegistraNuovaCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistraNuovaCategoria() {
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
		
		
		Utente utente =(Utente) request.getSession().getAttribute("Utente");
		
		if(utente!=null) {
			
			String nome = request.getParameter("Nome");
			String prezzoGG = request.getParameter("PrezzoGG");
			String prezzoSS = request.getParameter("PrezzoSS");
			String prezzoMM = request.getParameter("PrezzoMM");
			double prezzoGiorno,prezzoSettimana,prezzoMensile;
			
			if(utilita.VerificaStringe.areNotNull(nome,prezzoGG,prezzoSS,prezzoMM)
					&& (prezzoGiorno = Double.valueOf(prezzoGG)) > 0
					&& (prezzoSettimana = Double.valueOf(prezzoSS))>0
					&& (prezzoMensile = Double.valueOf(prezzoMM))> 0) {
				
				
				Categoria categoria = new Categoria(nome,prezzoGiorno,prezzoSettimana,prezzoMensile);
				
				if(DaoFactory.getDaoFactory().getCategoriaDao().addCategoria(categoria)) {
					
					request.setAttribute("successo", "Cateogoria inserita con successo");
					request.getRequestDispatcher(utilita.UtilPath.NUOVA_CATEGORIA_JSP).forward(request, response);
					
				}else {
					request.setAttribute("errore", "Errore categoria già presente");
					request.getRequestDispatcher(utilita.UtilPath.NUOVA_CATEGORIA_JSP).forward(request, response);
					
				}
				
				
			}else {
				
				request.setAttribute("errore", "Errore nell'inserimento dei prezzi");
				request.getRequestDispatcher(utilita.UtilPath.NUOVA_CATEGORIA_JSP).forward(request, response);
			}
			
		}
	}

}
