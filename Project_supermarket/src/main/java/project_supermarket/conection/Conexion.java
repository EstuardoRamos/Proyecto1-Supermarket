/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project_supermarket.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 * 
 * @author Estuardo Ramos
 */
public class Conexion {
    private static final String USER = "postgres";
    private static final String PASSWORD = "12345";
    private static final String PATH = "jdbc:postgresql://localhost:5432/supermarket";
    public static Connection connection = null;

    
     // Crea la conexion con la base de Datos
    public void iniciarConexion() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(PATH, USER, PASSWORD);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexion: " + e.toString());
        }
    }
}
