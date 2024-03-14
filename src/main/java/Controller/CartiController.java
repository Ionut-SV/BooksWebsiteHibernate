package Controller;

import DAO.CartiDao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojo.carti;
import DAOImpl.CartiDaoImpl;


public class CartiController extends HttpServlet {

	carti carte = new carti();
	CartiDaoImpl cartiDaoImpl = new CartiDaoImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("adaugaCarti") != null) {
			
			String titlu = request.getParameter("titlu");
			String categorie = request.getParameter("categorie");
			float rating = Float.parseFloat(request.getParameter("rating"));
			
			carte.setTitlu(titlu);
			carte.setCategorie(categorie);
			carte.setRating(rating);
			
			cartiDaoImpl.adaugaCarti(carte);
			RequestDispatcher rd = request.getRequestDispatcher("adauga_Carte.jsp");
			rd.forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("afiseazaCarti") != null) {
			List<carti> listaCarti = new ArrayList();
			listaCarti = cartiDaoImpl.afiseazaCarti();
			request.setAttribute("listaCarti", listaCarti);
			RequestDispatcher rd = request.getRequestDispatcher("tabela_Carti.jsp");
			rd.forward(request, response);
		}

		if (request.getParameter("modificaCarti") != null) {
			Long id1 = Long.parseLong(request.getParameter("idcarte"));
			String titlu = request.getParameter("titlu");
			String categorie = request.getParameter("categorie");
			Float rating = Float.parseFloat(request.getParameter("rating"));
		
			cartiDaoImpl.modificaCarti(id1, titlu, categorie, rating);
			RequestDispatcher rd = request.getRequestDispatcher("adauga_Carte.jsp");
			rd.forward(request, response);

		}

		if (request.getParameter("stergeCarti") != null) {
			Long id2 = Long.parseLong(request.getParameter("idcarte"));
			carte.setIdcarte(id2);
			cartiDaoImpl.stergeCarti(carte);
			RequestDispatcher rd = request.getRequestDispatcher("adauga_Carte.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}


