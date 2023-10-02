package main;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import project_supermarket.Vistas.Login;

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
       Login login = new Login();
       login.setVisible(true);

    }

}
