package dao;

import database.HibernateUtil;
import model.Departamento;
import org.hibernate.Session;

import java.util.List;

public class DepartamentoDAO {

    private Session session;

    public void agregarDepartamento(Departamento departamento){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(departamento);
        session.getTransaction().commit();
        session.close();
    }

    public List<Departamento> obtenerDepartamentos() {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Departamento> departamentos = session.createQuery("FROM Departamento", Departamento.class).list();
        session.getTransaction().commit();
        session.close();
        return departamentos;
    }
}
