import controller.LibreriaController;
import model.Autor;
import model.Editorial;
import model.Libreria;
import model.Libro;

public class Entrada {

    public static void main(String[] args) {

        LibreriaController libreriaController = new LibreriaController();

        //libreriaController.agregarAutor(new Autor("Pepe","Martinez","15/10/1990"));
        //libreriaController.agregarAutor(new Autor("Juan","Garcia","12/11/1994"));
        //libreriaController.agregarAutor(new Autor("Pedro","Miguelez","23/04/1960"));

        //libreriaController.agregarEditorial(new Editorial("Planeta","C/ Gran Vía, 47, 28013 Madrid, España"));
        //libreriaController.agregarEditorial(new Editorial("Penguin Random House","C/ Gran Vía, 29, 28013 Madrid, España"));

        //libreriaController.agregarLibros(new Libro("Harry Potter y la piedra filosofal",20.00),1,1);
        //libreriaController.agregarLibros(new Libro("Harry Potter y la cámara secreta",21.00),2,1);
        //libreriaController.agregarLibros(new Libro("Harry Potter y el prisionero de Azkaban",21.99),3,1);
        //libreriaController.agregarLibros(new Libro("Harry Potter y el cáliz de fuego",23.00),1,2);
        //libreriaController.agregarLibros(new Libro("Harry Potter y la orden del fénix",25.00),1,1);
        //libreriaController.agregarLibros(new Libro("Harry Potter y el misterio del príncipe",23.50),3,2);
        //libreriaController.agregarLibros(new Libro("Harry Potter y las Reliquias de la Muerte",24.00),3,1);
        //libreriaController.agregarLibros(new Libro("Los 7 enanitos",10.00),2,2);

        //libreriaController.agregarLibreria(new Libreria("El Buen Libro","Juan Pérez","Calle Mayor, 45, Madrid, España"));
        //libreriaController.agregarLibreria(new Libreria("Mundo de Papel","Laura Gómez","Avenida de la Libertad, 12, Barcelona, España"));

        //libreriaController.mostrarLibrosConEditorialYAutor();
        //libreriaController.mostrarAutoresConLibros();
        //libreriaController.mostrarLibreriasConLibros();
        libreriaController.mostrarLibrosConLibreria();

    }
}
