/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project_supermarket.controlers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import project_supermarket.Vistas.entidades.Cliente;
import project_supermarket.conection.Conexion;

/**
 * 
 * @author Estuardo Ramos
 */
public class ClienteDatos {
    
    public Cliente listarClientePorNit(String nit_cliente) {
        Cliente cliente = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        String query = "SELECT * FROM control_clientes.cliente WHERE nit = ?;";
        try {
            pr = Conexion.connection.prepareStatement(query);
            pr.setString(1, nit_cliente);
            rs = pr.executeQuery();
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setNit(rs.getString(1));
                cliente.setNombre(rs.getString(2));
                cliente.setTelefono(rs.getString(3));
                //cliente.setTarjeta(rs.getInt(4));
                cliente.setDinero_gastado(rs.getFloat(4));
                cliente.setDinero_membresia(rs.getFloat(5));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al hacer busqueda en base de datos: " + e.getMessage());
        } finally {
            try {
                pr.close();
                rs.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar conexiones: " + e.getMessage());
            }
        }
        return cliente;
    }

    /**
     * Inserta un cliente en la base de datos
     * @param cliente El cliente que se insertará
     * @return Un booleano que indica si la operacion fue exitosa.
     */
    public boolean insertarCliente(Cliente cliente) {
        boolean resultado = true;
        PreparedStatement pr = null;
        String query = "INSERT INTO control_clientes.cliente  VALUES (?, ?, ?, ?,  ?);";
        try {
            pr = Conexion.connection.prepareStatement(query);
            pr.setString(1, cliente.getNit());
            pr.setString(2, cliente.getNombre());
            pr.setString(3, cliente.getTelefono());
            //pr.setInt(4, cliente.getTarjeta());
            pr.setFloat(4, cliente.getDinero_gastado());//poner cero
            pr.setFloat(5, cliente.getDinero_membresia());
            //pr.setInt(6, 0);
            pr.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente registrado correctamente");
        } catch (SQLException e) {
            resultado = false;
            JOptionPane.showMessageDialog(null, "Error al ingresar cliente: " + e.getMessage());
        } finally {
            try {
                pr.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar conexiones: " + e.getMessage());
            }
        }
        return resultado;
    }
    
    /**
     * Actualiza los datos de nombre, correo, telefono y dpi de un cliente.
     * @param cliente El cliente con los datos nuevos
     * @return Un booleano que indica si la operacion fue exitosa
     */
    public boolean actualizarCliente(Cliente cliente) {
        boolean resultado = true;
        PreparedStatement pr = null;
        String query = "UPDATE control_clientes.cliente SET nombre = ?, telefono = ?, dinero_gastado= ?, dinero_mebresia= ? WHERE nit = ?";
        try {
            pr = Conexion.connection.prepareStatement(query);
            pr.setString(1, cliente.getNombre());
            pr.setString(2, cliente.getTelefono());
           // pr.setInt(3, cliente.getTarjeta());
            pr.setFloat(3, cliente.getDinero_gastado());
            pr.setFloat(4, cliente.getDinero_membresia());
            pr.setString(5, cliente.getNit());
            pr.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente actualizado correctamente");
        } catch (SQLException e) {
            resultado = false;
            JOptionPane.showMessageDialog(null, "Error al actualizar cliente: " + e.getMessage());
        } finally {
            try {
                pr.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar conexiones: " + e.getMessage());
            }
        }
        return resultado;
    }

  

}
