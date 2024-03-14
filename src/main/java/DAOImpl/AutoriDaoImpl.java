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
import pojo.autori;
import DAO.AutoriDao;

public class AutoriDaoImpl implements AutoriDao{

	public void adaugaAutori(autori autori) {
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        Transaction transaction = session.beginTransaction();
	        session.save(autori);
	        transaction.commit();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	public List<autori> afiseazaAutori() {
        List<autori> listaAutori = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Query query = session.createQuery("From autori");
        listaAutori = query.list();
        return listaAutori;
    }

    public void modificaAutori(Long idautor, String nume, String prenume,Float varsta, String gen) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        autori detaliiautori = session.load(autori.class, idautor);
        detaliiautori.setNume(nume);
        detaliiautori.setPrenume(prenume);
        detaliiautori.setVarsta(varsta);
        detaliiautori.setGen(gen);
        session.update(detaliiautori);
        transaction.commit();
        session.close();
    }

    public void stergeAutori(autori autori) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(autori);
        transaction.commit();
        session.close();
    }
}
