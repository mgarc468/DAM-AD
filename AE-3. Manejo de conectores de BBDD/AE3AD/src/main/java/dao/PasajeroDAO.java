package dao;

import database.DBConnection;
import database.SchemaDB;
import model.Pasajero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PasajeroDAO {
    private Connection connection;
    private PreparedStatement preparedStatement; // INSERT UPDATE DELETE
    private ResultSet resultSet; // SELECT

    // registrar
    public void registrarPasajero(Pasajero pasajero) throws SQLException {
        String query =  String.format("INSERT INTO %s (%s, %s, %s, %s) VALUES (?,?,?)",
                SchemaDB.TAB_PASAJEROS,
                SchemaDB.COL_PASAJEROS_NOMBRE, SchemaDB.COL_PASAJEROS_EDAD, SchemaDB.COL_PASAJEROS_PESO
        );
        connection = new DBConnection().getConnection();
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,pasajero.getNombre());
        preparedStatement.setInt(2,pasajero.getEdad());
        preparedStatement.setInt(3,pasajero.getPeso());


        preparedStatement.execute();
        new DBConnection().closeConnection();

    }
    // listar
    public ArrayList<Pasajero> listarPasajeros(int modo) throws SQLException {
        String query = String.format("SELECT * FROM %s", SchemaDB.TAB_PASAJEROS);
        connection = new DBConnection().getConnection();
        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();
        ArrayList<Pasajero> listaPasajeros = new ArrayList<>();
        while (resultSet.next()){
            int id = resultSet.getInt(SchemaDB.COL_ID);
            String nombre = resultSet.getString(SchemaDB.COL_PASAJEROS_NOMBRE);
            int edad = resultSet.getInt(SchemaDB.COL_PASAJEROS_EDAD);;
            int peso = resultSet.getInt(SchemaDB.COL_PASAJEROS_PESO);
            Pasajero pasajero = new Pasajero(id,nombre,edad,peso);
            listaPasajeros.add(pasajero);
            if (modo==1){
                System.out.println(pasajero);
            }
        }
        new DBConnection().closeConnection();

        return listaPasajeros;

    }

    // comprobar
    public boolean comprobarPasajero(int id) throws SQLException {
        String query = String.format("SELECT %s FROM %s WHERE %s=?",
                SchemaDB.COL_ID,
                SchemaDB.TAB_PASAJEROS,
                SchemaDB.COL_ID);
        connection = new DBConnection().getConnection();
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,id);
        resultSet = preparedStatement.executeQuery();
        return resultSet.next();

    }

    // eliminar
    public void eliminarPasajero(int id) throws SQLException {
        String query =  String.format("DELETE FROM %s WHERE %s=?",
                SchemaDB.TAB_PASAJEROS,
                SchemaDB.COL_ID);
        connection = new DBConnection().getConnection();
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,id);

        int filasAfectadas = preparedStatement.executeUpdate();
        if (filasAfectadas == 0){
            System.out.println("No se encontró ningún coche con el ID especificado.");
        } else {
            System.out.println("El coche ha sido eliminado correctamente.");
        }
        new DBConnection().closeConnection();
    }

    // modificar
    public void modificarPasajero(int id) throws SQLException {
        String query = String.format("UPDATE %s SET %s=? WHERE %s=?",
                SchemaDB.TAB_PASAJEROS,
                SchemaDB.COL_PASAJEROS_NOMBRE,
                SchemaDB.COL_ID);
        connection = new DBConnection().getConnection();
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);

        int filasAfectadas = preparedStatement.executeUpdate();
        if (filasAfectadas == 0) {
            System.out.println("No se encontró ningún pasajero con el ID especificado.");
        } else {
            System.out.println("El pasajero ha sido modificado correctamente.");
        }
        new DBConnection().closeConnection();

    }
}
