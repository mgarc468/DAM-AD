package controller;

import dao.CalificacionDAO;
import dao.CursoDAO;
import dao.DepartamentoDAO;
import dao.EstudianteDAO;
import dao.ProfesorDAO;
import model.Calificacion;
import model.Curso;
import model.Departamento;
import model.Estudiante;
import model.Profesor;

import java.util.List;

public class EscuelaController {
    private EstudianteDAO estudianteDAO;
    private CursoDAO cursoDAO;
    private ProfesorDAO profesorDAO;
    private DepartamentoDAO departamentoDAO;
    private CalificacionDAO calificacionDAO;

    public EscuelaController(){
        estudianteDAO = new EstudianteDAO();
        cursoDAO = new CursoDAO();
        profesorDAO = new ProfesorDAO();
        departamentoDAO = new DepartamentoDAO();
        calificacionDAO = new CalificacionDAO();
    }

    // Función para agregar estudiantes
    public void agregarEstudiante(Estudiante estudiante){
        estudianteDAO.agregarEstudiante(estudiante);
    }

    // Función para agregar cursos
    public void agregarCurso(Curso curso){
        cursoDAO.agregarCurso(curso);
    }

    // Función para agregar profesores
    public void agregarProfesor(Profesor profesor){
        profesorDAO.agregarProfesor(profesor);
    }

    // Función para agregar departamentos
    public void agregarDepartamento(Departamento departamento){
        departamentoDAO.agregarDepartamento(departamento);
    }

    // Función para agregar calificaciones
    public void agregarCalificacion(Calificacion calificacion){
        calificacionDAO.agregarCalificacion(calificacion);
    }

    // Mostrar todos los estudiantes
    public void mostrarEstudiantes(){
        List<Estudiante> estudiantes = estudianteDAO.obtenerEstudiantes();
        for (Estudiante estudiante : estudiantes){
            System.out.println(estudiante.getNombre() + " " + estudiante.getApellido());
        }
    }

    // Mostrar todos los cursos
    public void mostrarCursos(){
        List<Curso> cursos = cursoDAO.obtenerCursos();
        for (Curso curso : cursos){
            System.out.println(curso.getNombre());
        }
    }

    // Mostrar todos los profesores
    public void mostrarProfesores(){
        List<Profesor> profesores = profesorDAO.obtenerProfesores();
        for (Profesor profesor : profesores){
            System.out.println(profesor.getNombre() + " " + profesor.getApellido());
        }
    }

    // Mostrar todos los departamentos
    public void mostrarDepartamentos() {
        List<Departamento> departamentos = departamentoDAO.obtenerDepartamentos();
        for (Departamento departamento : departamentos) {
            System.out.println(departamento.getNombre());
        }
    }

    // Mostrar todas las calificaciones
    public void mostrarCalificaciones(){
        List<Calificacion> calificaciones = calificacionDAO.obtenerCalificaciones();
        for (Calificacion calificacion : calificaciones){
            System.out.println(calificacion.getNota());
        }
    }
}
