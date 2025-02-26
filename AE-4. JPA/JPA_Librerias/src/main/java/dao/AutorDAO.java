package dao;

import database.HibernateUtil;
import model.Autor;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AutorDAO {

    private Session session;

    public void agregarAutor(Autor autor){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(autor);
        session.getTransaction().commit();
        session.close();
    }

    public Autor devolverAutor(int idAutor){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Autor autor = session.get(Autor.class, idAutor);
        session.getTransaction().commit();
        session.close();
        return autor;
    }

    public List<Autor> obtenerAutores() {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query<Autor> query = session.createNamedQuery("Libro.findAll",Autor.class);
        List<Autor> listaAutores = query.list();
        session.getTransaction().commit();
        session.close();
        return listaAutores;
    }
}
