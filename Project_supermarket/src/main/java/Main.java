
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Estuardo Ramos
 */
public class Main {

    public static void main(String[] args) {
        String USER = "postgres";
        String PASSWORD = "12345";
        String PATH = "jdbc:postgresql://localhost:5432/supermarket";
        Connection connection = null;

        /**
         * Crea la conexion con la base de Datos
         *
         */
        String query = "SELECT * FROM control_super.empleado;";
        Connection conexion = null;

        try {
            conexion = DriverManager.getConnection(PATH, USER, PASSWORD);
            if (conexion != null) {
                System.out.println("Conexión exitosa a la base de datos PostgreSQL");
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos PostgreSQL: " + e.getMessage());
        } finally {
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }

    }

}
