package database;

public interface SchemaDB {

    String HOST = "localhost";
    String PORT = ":3306";
    String DB_NAME = "aplicacion";
    String DB_USER = "root";
    String DB_PASS = "";
    String COL_ID= "id";

    String TAB_COCHES= "coches";
    String COL_COCHES_MATRICULA= "matricula";
    String COL_COCHES_MARCA= "marca";
    String COL_COCHES_MODELO= "modelo";
    String COL_COCHES_COLOR= "color";
    String COL_COCHES_ID_PASAJEROS= "id_pasajeros";

    String TAB_PASAJEROS= "pasajeros";
    String COL_PASAJEROS_NOMBRE= "nombre";
    String COL_PASAJEROS_EDAD= "edad";
    String COL_PASAJEROS_PESO= "peso";

}
