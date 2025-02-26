package dao;

import database.HibernateUtil;
import model.Curso;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CursoDAO {

    private Session session;

    public void agregarCurso(Curso curso){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(curso);
        session.getTransaction().commit();
        session.close();
    }

    public Curso devolverCurso(int idCurso){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Curso curso = session.get(Curso.class, idCurso);
        session.getTransaction().commit();
        session.close();
        return curso;
    }

    public List<Curso> obtenerCursos() {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query<Curso> query = session.createQuery("FROM Curso", Curso.class);
        List<Curso> listaCursos = query.list();
        session.getTransaction().commit();
        session.close();
        return listaCursos;
    }
}
