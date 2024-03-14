
package Controller;

import DAO.AutoriDao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojo.autori;
import DAOImpl.AutoriDaoImpl;


public class AutoriController extends HttpServlet {

	autori autori = new autori();
	AutoriDaoImpl autorDaoImpl = new AutoriDaoImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("adaugaAutori") != null) {
			String nume = request.getParameter("nume");
			String prenume = request.getParameter("prenume");
			Float varsta = java.lang.Float.parseFloat(request.getParameter("varsta"));
			String gen = request.getParameter("gen");
			autori.setNume(nume); 
			autori.setPrenume(prenume);
			autori.setVarsta(varsta);
			autori.setGen(gen);
			autorDaoImpl.adaugaAutori(autori);
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("afiseazaAutori") != null) {
			List<autori> listaAutori = new ArrayList();
			listaAutori = autorDaoImpl.afiseazaAutori();
			request.setAttribute("listaAutori", listaAutori);
			RequestDispatcher rd = request.getRequestDispatcher("tabela_Autori.jsp");
			rd.forward(request, response);
		}

		if (request.getParameter("modificaAutori") != null) {
			long id1 = Long.parseLong(request.getParameter("idautor"));
			String nume = request.getParameter("nume");
			String prenume = request.getParameter("prenume");
			float varsta = java.lang.Float.parseFloat(request.getParameter("varsta"));
			String gen = request.getParameter("gen");
			autorDaoImpl.modificaAutori(id1, nume, prenume,varsta, gen);
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.forward(request, response);

		}

		if (request.getParameter("stergeAutori") != null) {
			long id2 = Long.parseLong(request.getParameter("idautor"));
			autori.setIdautor(id2);
			autorDaoImpl.stergeAutori(autori); 
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
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


