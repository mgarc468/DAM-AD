package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "librerias")
public class Libreria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nombre;

    @Column
    private String nombre_dueno;

    @Column
    private String direccion;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "librerias_libros", joinColumns = @JoinColumn(name = "id_libreria")
            , inverseJoinColumns = @JoinColumn(name = "id_libro"))
    private List<Libro> libros;

    public Libreria(String nombre, String nombre_dueno, String direccion) {
        this.nombre = nombre;
        this.nombre_dueno = nombre_dueno;
        this.direccion = direccion;
    }


}
