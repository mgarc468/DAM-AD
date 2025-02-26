package dao;

import database.HibernateUtil;
import model.Calificacion;
import org.hibernate.Session;

import java.util.List;

public class CalificacionDAO {

    private Session session;

    public void agregarCalificacion(Calificacion calificacion){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(calificacion);
        session.getTransaction().commit();
        session.close();
    }

    public List<Calificacion> obtenerCalificaciones() {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Calificacion> calificaciones = session.createQuery("FROM Calificacion", Calificacion.class).list();
        session.getTransaction().commit();
        session.close();
        return calificaciones;
    }
}
