package dao;

import database.HibernateUtil;
import model.Profesor;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ProfesorDAO {

    private Session session;

    public void agregarProfesor(Profesor profesor){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(profesor);
        session.getTransaction().commit();
        session.close();
    }

    public Profesor devolverProfesor(int idProfesor){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Profesor profesor = session.get(Profesor.class, idProfesor);
        session.getTransaction().commit();
        session.close();
        return profesor;
    }

    public List<Profesor> obtenerProfesores() {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query<Profesor> query = session.createQuery("FROM Profesor", Profesor.class);
        List<Profesor> listaProfesores = query.list();
        session.getTransaction().commit();
        session.close();
        return listaProfesores;
    }
}
