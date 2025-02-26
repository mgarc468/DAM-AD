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

@NamedQuery(name = "Autor.findAll",query = "FROM Autor")

@Entity
@Table (name = "autores")
public class Autor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nombre;

    @Column
    private String apellidos;

    @Column
    private String fecha_nacimiento;

    @OneToMany(mappedBy = "autor", fetch = FetchType.EAGER)
    private List<Libro> libros;

    public Autor(String nombre, String apellidos, String fecha) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_nacimiento = fecha;
    }

    public Autor(String fecha_nacimiento, String apellidos, String nombre, int id) {
        this.fecha_nacimiento = fecha_nacimiento;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.id = id;
    }

    public Autor(int id) {
        this.id = id;
    }
}



