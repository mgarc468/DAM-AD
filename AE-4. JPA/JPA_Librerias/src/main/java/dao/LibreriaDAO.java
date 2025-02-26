package dao;

import database.HibernateUtil;
import model.Libreria;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class LibreriaDAO {


    private Session session;
    public void agregarLibreria(Libreria libreria) {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.merge(libreria);
        session.getTransaction().commit();
        session.close();
    }

    public List<Libreria> obtenerLibrerias() {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query<Libreria> query = session.createQuery("FROM Libreria", Libreria.class);
        List<Libreria> listaLibrerias = query.list();
        session.getTransaction().commit();
        session.close();
        return listaLibrerias;
    }

}
