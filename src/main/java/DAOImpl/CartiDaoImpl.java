/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImpl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.carti;
import DAO.CartiDao;


public class CartiDaoImpl implements CartiDao{

	public void adaugaCarti(carti carti) {
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        Transaction transaction = session.beginTransaction();
	        session.save(carti);
	        transaction.commit();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

    public List<carti> afiseazaCarti() {
        List<carti> listaCarti = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Query query = session.createQuery("From carti");
        listaCarti = query.list();
        return listaCarti;
    }

    public void modificaCarti(Long idcarte, String titlu, String categorie, Float rating) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        carti detaliicarti = (carti) session.load(carti.class, idcarte);
        detaliicarti.setTitlu(titlu);
        detaliicarti.setCategorie(categorie);
        detaliicarti.setRating(rating);
        session.update(detaliicarti);
        transaction.commit();
        session.close();
    }

    public void stergeCarti(carti carti) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(carti);
        transaction.commit();
        session.close();
    }
}
