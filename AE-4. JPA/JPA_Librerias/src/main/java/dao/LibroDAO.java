package dao;

import database.HibernateUtil;
import model.Autor;
import model.Editorial;
import model.Libro;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class LibroDAO {
    AutorDAO autorDAO = new AutorDAO();
    EditorialDAO editorialDAO = new EditorialDAO();

    private Session session;
    public void agregarLibro(Libro libro, int idAutor, int idEditorial) {
        Autor autorResult = autorDAO.devolverAutor(idAutor);
        libro.setAutor(autorResult);
        Editorial editorialResult = editorialDAO.devolverEditorial(idEditorial);
        libro.setEditorial(editorialResult);
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.merge(libro);
        session.getTransaction().commit();
        session.close();
    }

    public List<Libro> obtenerLibros() {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query<Libro> query = session.createNamedQuery("Libro.findAll",Libro.class);
        List<Libro> listaLibros = query.list();
        session.getTransaction().commit();
        session.close();
        return listaLibros;
    }


}
