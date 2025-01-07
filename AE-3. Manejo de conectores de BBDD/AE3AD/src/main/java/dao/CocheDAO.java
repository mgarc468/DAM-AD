package dao;

import database.DBConnection;
import database.SchemaDB;
import model.Coche;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CocheDAO {
    private Connection connection;
    private PreparedStatement preparedStatement; // INSERT UPDATE DELETE
    private ResultSet resultSet; // SELECT

    // registrar
    public void registrarCoche(Coche coche) throws SQLException {
        String query =  String.format("INSERT INTO %s (%s, %s, %s, %s) VALUES (?,?,?,?)",
                SchemaDB.TAB_COCHES,
                SchemaDB.COL_COCHES_MATRICULA, SchemaDB.COL_COCHES_MARCA, SchemaDB.COL_COCHES_MODELO, SchemaDB.COL_COCHES_COLOR
        );
        connection = new DBConnection().getConnection();
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,coche.getMatricula());
        preparedStatement.setString(2,coche.getMarca());
        preparedStatement.setString(3,coche.getModelo());
        preparedStatement.setString(4,coche.getColor());

        preparedStatement.execute();
        new DBConnection().closeConnection();

    }
    // listar
    public ArrayList<Coche> listarCoches(int modo) throws SQLException {
        String query = String.format("SELECT * FROM %s", SchemaDB.TAB_COCHES);
        connection = new DBConnection().getConnection();
        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();
        ArrayList<Coche> listaCoches = new ArrayList<>();
        while (resultSet.next()){
            int id = resultSet.getInt(SchemaDB.COL_ID);
            String matricula = resultSet.getString(SchemaDB.COL_COCHES_MATRICULA);
            String marca = resultSet.getString(SchemaDB.COL_COCHES_MARCA);;
            String modelo = resultSet.getString(SchemaDB.COL_COCHES_MODELO);
            String color = resultSet.getString(SchemaDB.COL_COCHES_COLOR);
            Coche coche = new Coche(id,matricula,marca,modelo,color);
            listaCoches.add(coche);
            if (modo==1){
                System.out.println(coche);
            }
        }
        new DBConnection().closeConnection();

        return listaCoches;

    }

    // comprobar
    public boolean comprobarCoche(int id) throws SQLException {
        String query = String.format("SELECT %s FROM %s WHERE %s=?",
                SchemaDB.COL_ID,
                SchemaDB.TAB_COCHES,
                SchemaDB.COL_ID);
        connection = new DBConnection().getConnection();
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,id);
        resultSet = preparedStatement.executeQuery();
        return resultSet.next();

    }

    // eliminar
    public void eliminarCoche(int id) throws SQLException {
        String query =  String.format("DELETE FROM %s WHERE %s=?",
                SchemaDB.TAB_COCHES,
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
    public void modificarCoche(int id) throws SQLException {
        String query =  String.format("UPDATE %s SET %s=? WHERE %s=?",
                SchemaDB.TAB_COCHES,
                SchemaDB.COL_COCHES_MODELO,
                SchemaDB.COL_ID);
        connection = new DBConnection().getConnection();
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,id);

        int filasAfectadas = preparedStatement.executeUpdate();
        if (filasAfectadas == 0){
            System.out.println("No se encontró ningún coche con el ID especificado.");
        } else {
            System.out.println("El coche ha sido modificado correctamente.");
        }
        new DBConnection().closeConnection();
    }

}
