package controller;

import dao.AutorDAO;
import dao.EditorialDAO;
import dao.LibreriaDAO;
import dao.LibroDAO;
import model.Autor;
import model.Editorial;
import model.Libreria;
import model.Libro;

import java.util.List;

public class LibreriaController {
    private AutorDAO autorDAO;
    private EditorialDAO editorialDAO;
    private LibreriaDAO libreriaDAO;
    private LibroDAO libroDAO;

    public LibreriaController(){
        autorDAO = new AutorDAO();
        editorialDAO = new EditorialDAO();
        libreriaDAO = new LibreriaDAO();
        libroDAO = new LibroDAO();
    }

    public void agregarAutor(Autor autor){
        autorDAO.agregarAutor(autor);
    }

    public void agregarEditorial(Editorial editorial){
        editorialDAO.agregarEditorial(editorial);
    }

    public void agregarLibros(Libro libro, int idAutor, int idEditorial){
        libroDAO.agregarLibro(libro,idAutor,idEditorial);
    }

    public void agregarLibreria(Libreria libreria) {
        libreriaDAO.agregarLibreria(libreria);
    }

    public void mostrarLibrosConEditorialYAutor() {
        List<Libro> listaLibros = libroDAO.obtenerLibros();
        for (Libro libro : listaLibros) {
            System.out.println("Título: " + libro.getTitulo() +
                    ", Autor: " + libro.getAutor().getNombre() +
                    " " + libro.getAutor().getApellidos() +
                    ", Editorial: " + libro.getEditorial().getNombre());
        }
    }

    public void mostrarAutoresConLibros() {
        List<Autor> listaAutores = autorDAO.obtenerAutores();
        for (Autor autor : listaAutores) {
            System.out.println("Autor: " + autor.getNombre() + " " + autor.getApellidos());
            for (Libro libro : autor.getLibros()) {
                System.out.println("\tLibro: " + libro.getTitulo());
            }
        }
    }

    public void mostrarLibreriasConLibros() {
        List<Libreria> listaLibrerias = libreriaDAO.obtenerLibrerias();  // Asegúrate de tener un método en LibreriaDAO para obtener todas las librerías
        for (Libreria libreria : listaLibrerias) {
            System.out.println("Librería: " + libreria.getNombre());
            for (Libro libro : libreria.getLibros()) {
                System.out.println("\tLibro: " + libro.getTitulo());
            }
        }
    }

    public void mostrarLibrosConLibreria() {
        List<Libro> listaLibros = libroDAO.obtenerLibros();
        for (Libro libro : listaLibros) {
            System.out.println("Título: " + libro.getTitulo());
            for (Libreria libreria : libro.getLibrerias()) {
                System.out.println("\tLibrería: " + libreria.getNombre());
            }
        }
    }

}
