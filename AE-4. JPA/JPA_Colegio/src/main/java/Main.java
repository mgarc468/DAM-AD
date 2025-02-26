package main;

import controller.EscuelaController;
import model.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        EscuelaController escuelaController = new EscuelaController();

        // Crear y agregar departamentos
        Departamento departamento1 = new Departamento("Informatica");
        Departamento departamento2 = new Departamento("Matematica");
        escuelaController.agregarDepartamento(departamento1);
        escuelaController.agregarDepartamento(departamento2);

        // Crear y agregar profesores
        Profesor profesor1 = new Profesor("Gabriela", "Perez");
        Profesor profesor2 = new Profesor("Sebastian", "Lopez");
        escuelaController.agregarProfesor(profesor1);
        escuelaController.agregarProfesor(profesor2);

        // Crear y agregar cursos directamente en una línea
        escuelaController.agregarCurso(new Curso("Java Básico", profesor1));
        escuelaController.agregarCurso(new Curso("Algebra", profesor2));

        // Crear y agregar estudiantes
        Estudiante estudiante1 = new Estudiante("Miguel", "Lopez");
        Estudiante estudiante2 = new Estudiante("Marina", "Martinez");
        escuelaController.agregarEstudiante(estudiante1);
        escuelaController.agregarEstudiante(estudiante2);

        // Crear y agregar calificaciones
        Calificacion calificacion1 = new Calificacion(95, estudiante1,new Curso("Java Básico", profesor1));
        Calificacion calificacion2 = new Calificacion(88, estudiante2, new Curso("Algebra", profesor2));
        escuelaController.agregarCalificacion(calificacion1);
        escuelaController.agregarCalificacion(calificacion2);

        // Mostrar todos los estudiantes
        System.out.println("Todos los estudiantes:");
        escuelaController.mostrarEstudiantes();

        // Mostrar todos los cursos
        System.out.println("\nTodos los cursos:");
        escuelaController.mostrarCursos();

        // Mostrar todos los profesores
        System.out.println("\nTodos los profesores:");
        escuelaController.mostrarProfesores();

        // Mostrar todos los departamentos
        System.out.println("\nTodos los departamentos:");
        escuelaController.mostrarDepartamentos();

        // Mostrar todas las calificaciones
        System.out.println("\nTodas las calificaciones:");
        escuelaController.mostrarCalificaciones();
    }
}
