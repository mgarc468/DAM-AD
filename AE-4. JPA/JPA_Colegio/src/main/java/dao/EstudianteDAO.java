package dao;

import database.HibernateUtil;
import model.Estudiante;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class EstudianteDAO {

    private Session session;

    public void agregarEstudiante(Estudiante estudiante){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(estudiante);
        session.getTransaction().commit();
        session.close();
    }

    public Estudiante devolverEstudiante(int idEstudiante){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Estudiante estudiante = session.get(Estudiante.class, idEstudiante);
        session.getTransaction().commit();
        session.close();
        return estudiante;
    }

    public List<Estudiante> obtenerEstudiantes() {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query<Estudiante> query = session.createQuery("FROM Estudiante", Estudiante.class);
        List<Estudiante> listaEstudiantes = query.list();
        session.getTransaction().commit();
        session.close();
        return listaEstudiantes;
    }
}
