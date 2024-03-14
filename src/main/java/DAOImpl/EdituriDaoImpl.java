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
import pojo.edituri;
import DAO.EdituriDao;
import java.util.Date;
import pojo.carti;
import pojo.autori;


public class EdituriDaoImpl implements EdituriDao{

    public void adaugaEdituri(edituri edituri) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(edituri);
        transaction.commit();
        session.close();
    }

    public List<edituri> afiseazaEdituri() {
        List<edituri> listaEdituri = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Query query = session.createQuery("From edituri");
        listaEdituri = query.list();
        return listaEdituri;
    }

    public void modificaEdituri(Long ideditura, autori autori, carti carti, String nume_editura, String data_publicarii,int copii_vandute, String tara) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        edituri detaliieditura;
        detaliieditura = (edituri) session.load(edituri.class, ideditura);
        detaliieditura.setAutori(autori);
        detaliieditura.setCarti(carti);
        detaliieditura.setNume_editura(nume_editura);
        detaliieditura.setData_publicarii(data_publicarii);
        detaliieditura.setCopii_vandute(copii_vandute);
        detaliieditura.setTara(tara);
        session.update(detaliieditura);
        transaction.commit();
        session.close();
    }

    public void stergeEdituri(edituri edituri) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(edituri);
        transaction.commit();
        session.close();
    }
}
