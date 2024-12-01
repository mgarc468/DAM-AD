import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionCoches {
    private static final String FICHERO_DAT = "coches.dat";
    private static final String FICHERO_CSV = "coches.csv";
    private static ArrayList<Coche> coches = new ArrayList<>();

    public static void main(String[] args) {
        cargarCoches();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (opcion) {
                case 1 -> añadirCoche(scanner);
                case 2 -> borrarCoche(scanner);
                case 3 -> consultarCoche(scanner);
                case 4 -> listarCoches();
                case 5 -> terminarPrograma();
                case 6 -> exportarCochesCSV();
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }

    private static void mostrarMenu() {
        System.out.println("\nMenú de gestión de coches:");
        System.out.println("1. Añadir nuevo coche");
        System.out.println("2. Borrar coche por ID");
        System.out.println("3. Consultar coche por ID");
        System.out.println("4. Listar todos los coches");
        System.out.println("5. Terminar el programa");
        System.out.println("6. Exportar coches a archivo CSV");
        System.out.print("Seleccione una opción: ");
    }

    private static void cargarCoches() {
        File fichero = new File(FICHERO_DAT);
        if (fichero.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
                coches = (ArrayList<Coche>) ois.readObject();
                System.out.println("Coches cargados correctamente desde " + FICHERO_DAT);
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error al cargar el fichero: " + e.getMessage());
            }
        }
    }

    private static void añadirCoche(Scanner scanner) {
        System.out.print("Ingrese el ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir nueva línea
        System.out.print("Ingrese la matrícula: ");
        String matricula = scanner.nextLine();
        System.out.print("Ingrese la marca: ");
        String marca = scanner.nextLine();
        System.out.print("Ingrese el modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Ingrese el color: ");
        String color = scanner.nextLine();

        if (coches.stream().anyMatch(c -> c.getId() == id || c.getMatricula().equalsIgnoreCase(matricula))) {
            System.out.println("Error: Ya existe un coche con ese ID o matrícula.");
        } else {
            coches.add(new Coche(id, matricula, marca, modelo, color));
            System.out.println("Coche añadido correctamente.");
        }
    }

    private static void borrarCoche(Scanner scanner) {
        System.out.print("Ingrese el ID del coche a borrar: ");
        int id = scanner.nextInt();
        if (coches.removeIf(c -> c.getId() == id)) {
            System.out.println("Coche eliminado correctamente.");
        } else {
            System.out.println("No se encontró un coche con el ID especificado.");
        }
    }

    private static void consultarCoche(Scanner scanner) {
        System.out.print("Ingrese el ID del coche a consultar: ");
        int id = scanner.nextInt();
        coches.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .ifPresentOrElse(
                        coche -> System.out.println("Detalles del coche: " + coche),
                        () -> System.out.println("No se encontró un coche con el ID especificado.")
                );
    }

    private static void listarCoches() {
        if (coches.isEmpty()) {
            System.out.println("No hay coches registrados.");
        } else {
            coches.forEach(System.out::println);
        }
    }

    private static void terminarPrograma() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHERO_DAT))) {
            oos.writeObject(coches);
            System.out.println("Coches guardados en " + FICHERO_DAT);
        } catch (IOException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
        System.out.println("Programa terminado.");
    }

    private static void exportarCochesCSV() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FICHERO_CSV))) {
            writer.println("ID;Matrícula;Marca;Modelo;Color");
            for (Coche coche : coches) {
                writer.println(coche.getId() + ";" + coche.getMatricula() + ";" + coche.getMarca() + ";" +
                        coche.getModelo() + ";" + coche.getColor());
            }
            System.out.println("Coches exportados a " + FICHERO_CSV);
        } catch (IOException e) {
            System.out.println("Error al exportar los datos: " + e.getMessage());
        }
    }
}
