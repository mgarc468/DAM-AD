import dao.CocheDAO;
import dao.PasajeroDAO;
import model.Coche;
import model.Pasajero;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        CocheDAO cocheDAO = new CocheDAO();
        PasajeroDAO pasajeroDAO = new PasajeroDAO();

        System.out.println("Bienvenido al programa de gestion de usuarios");
        int opcion;
        do {
            System.out.println("1. Añadir nuevo coche");
            System.out.println("2. Borrar coche");
            System.out.println("3. Consultar coche");
            System.out.println("4. Modificar coche");
            System.out.println("5. Listar coches");
            System.out.println("6. Gestinar pasajeros");
            System.out.println("7. Salir");
            System.out.println("Introduce la opcion a desarrollar");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Ingresa la matricula");
                    String matricula = scanner.nextLine();
                    System.out.println("Ingresa la marca ");
                    String marca = scanner.nextLine();
                    System.out.println("Ingresa el modelo ");
                    String modelo = scanner.nextLine();
                    System.out.println("Ingresa el color ");
                    String color = scanner.nextLine();

                    try {
                        cocheDAO.registrarCoche(new Coche(matricula, marca, modelo, color));
                        System.out.println("El coche se ha registrado correctamente");
                    } catch (SQLException e) {
                        System.out.println("Error, coche duplicado");
                    }
                    break;
                case 2:
                    System.out.println("Ingresa el id del coche a eliminar");
                    int id = scanner.nextInt();

                    try {
                        cocheDAO.eliminarCoche(id);
                    } catch (SQLException e) {
                        System.out.println("Error, el coche no existe");
                    }
                    break;
                case 3:
                    System.out.println("Ingresa el id del coche a buscar");
                    id = scanner.nextInt();
                    try {
                        cocheDAO.comprobarCoche(id);
                    } catch (SQLException e) {
                        System.out.println("Error, el coche no existe");
                    }
                    break;
                case 4:
                    System.out.println("Ingresa el id del coche a modificar");
                    id = scanner.nextInt();
                    try {
                        cocheDAO.modificarCoche(id);
                    } catch (SQLException e) {
                        System.out.println("Error, el coche no existe");
                    }
                case 5:
                        cocheDAO.listarCoches(1);
                    break;
                case 6:
                    do {
                        System.out.println("1. Añadir nuevo pasajero");
                        System.out.println("2. Borrar pasajero");
                        System.out.println("3. Consultar pasajero");
                        System.out.println("4. Listar coches");
                        System.out.println("5. Añadir pasajero a coche");
                        System.out.println("6. Eliminar pasajero de un coche");
                        System.out.println("7. Listar pasajeros de un coche");
                        System.out.println("8. Salir");

                        System.out.println("Introduce la opcion a desarrollar");
                        opcion = scanner.nextInt();
                        switch (opcion) {
                            case 1:
                                System.out.println("Ingresa su nombre");
                                String nombre = scanner.nextLine();
                                System.out.println("Ingresa su edad ");
                                int edad = scanner.nextInt();
                                System.out.println("Ingresa su peso");
                                int peso = scanner.nextInt();

                                try {
                                    pasajeroDAO.registrarPasajero(new Pasajero(nombre, edad, peso));
                                    System.out.println("El pasajero se ha registrado correctamente");
                                } catch (SQLException e) {
                                    System.out.println("Error, pasajero duplicado");
                                }
                                break;
                            case 2:
                                System.out.println("Ingresa el id del pasajero a eliminar");
                                id = scanner.nextInt();

                                try {
                                    pasajeroDAO.eliminarPasajero(id);
                                } catch (SQLException e) {
                                    System.out.println("Error, el pasajero no existe");
                                }
                                break;
                            case 3:
                                System.out.println("Ingresa el id del pasajero a buscar");
                                id = scanner.nextInt();
                                try {
                                    pasajeroDAO.comprobarPasajero(id);
                                } catch (SQLException e) {
                                    System.out.println("Error, el pasajero no existe");
                                }
                                break;
                            case 4:
                                pasajeroDAO.listarPasajeros(1);
                                break;
                            case 5:
                                break;
                            case 6:
                                break;
                            case 7:
                                break;
                            case 8:
                                System.out.println("Saliendo del apartado pasajeros");
                                break;
                        }
                        System.out.println("Saliendo");
                        break;
                    } while (opcion != 8);
                case 7:
                    System.out.println("Saliendo");
                    break;
            }

        } while (opcion != 7) ;
    }
}