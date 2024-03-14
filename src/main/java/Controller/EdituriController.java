package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojo.autori;
import pojo.carti;
import pojo.edituri;
import DAOImpl.EdituriDaoImpl;
import DAOImpl.HibernateUtil;
import java.text.ParseException;
import org.hibernate.Session;


public class EdituriController extends HttpServlet {

	edituri edituri = new edituri();
	EdituriDaoImpl edituraDaoImpl = new EdituriDaoImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("adaugaEdituri") != null) {
			// preluarea parametrilor de interes
			Long idautor = java.lang.Long.parseLong(request.getParameter("idautor"));
			Long idcarte = java.lang.Long.parseLong(request.getParameter("idcarte"));
			Session session = HibernateUtil.getSessionFactory().openSession();
			autori autori = (autori) session.get(autori.class, idautor);
			carti carti = (carti) session.get(carti.class, idcarte);

			String nume_editura = request.getParameter("nume_editura");
			String data_publicarii = request.getParameter("data_publicarii");
			int copii_vandute = Integer.parseInt(request.getParameter("copii_vandute"));
			String tara = request.getParameter("tara");

			edituri.setAutori(autori);
			edituri.setCarti(carti);
			edituri.setNume_editura(nume_editura);
			edituri.setData_publicarii(data_publicarii);
			edituri.setCopii_vandute(copii_vandute);
			edituri.setTara(tara);

			edituraDaoImpl.adaugaEdituri(edituri);
			RequestDispatcher rd = request.getRequestDispatcher("adauga_Editura.jsp");
			rd.forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("afiseazaEdituri") != null) {
			List<edituri> listaEdituri = new ArrayList();
			listaEdituri = edituraDaoImpl.afiseazaEdituri();
			request.setAttribute("listaEdituri", listaEdituri);
			RequestDispatcher rd = request.getRequestDispatcher("tabela_Edituri.jsp");
			rd.forward(request, response);
		}

		if (request.getParameter("modificaEdituri") != null) {
			Long id1 = java.lang.Long.parseLong(request.getParameter("ideditura"));
			// preluarea parametrilor de interes
			Long idautor = java.lang.Long.parseLong(request.getParameter("idautor"));
			Long idcarte = java.lang.Long.parseLong(request.getParameter("idcarte"));
			Session session = HibernateUtil.getSessionFactory().openSession();
			autori autori = (autori) session.get(autori.class, idautor);
			carti carti = (carti) session.get(carti.class, idcarte);

			String nume_editura = request.getParameter("nume_editura");
			String data_publicarii = request.getParameter("data_publicarii");
			int copii_vandute = Integer.parseInt(request.getParameter("copii_vandute"));
			String tara = request.getParameter("tara");

			edituraDaoImpl.modificaEdituri(id1, autori, carti, nume_editura, data_publicarii, copii_vandute,tara);
			RequestDispatcher rd = request.getRequestDispatcher("adauga_Editura.jsp");
			rd.forward(request, response);

		}

		if (request.getParameter("stergeEdituri") != null) {
			Long id2 = Long.parseLong(request.getParameter("ideditura"));
			edituri.setIdeditura(id2);
			edituraDaoImpl.stergeEdituri(edituri);
			RequestDispatcher rd = request.getRequestDispatcher("adauga_Editura.jsp");
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


