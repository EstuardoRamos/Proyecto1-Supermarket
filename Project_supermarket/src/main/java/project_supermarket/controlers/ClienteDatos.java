/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_supermarket.controlers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import project_supermarket.Vistas.entidades.Cliente;
import project_supermarket.Vistas.entidades.Sucursal;
import project_supermarket.conection.Conexion;

/**
 *
 * @author Estuardo Ramos
 */
public class ClienteDatos {
    //buscamos un cliente por nit
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

    //insertamo un cliente en la tabla cliente
    public boolean insertarCliente(Cliente cliente) {
        boolean resultado = true;
        PreparedStatement pr = null;
        String query = "INSERT INTO control_clientes.cliente  VALUES (?, ?, ?, ?,  ?);";
        try {
            pr = Conexion.connection.prepareStatement(query);
            pr.setString(1, cliente.getNit());
            pr.setString(2, cliente.getNombre());
            pr.setString(3, cliente.getTelefono());
            pr.setFloat(4, cliente.getDinero_gastado());//poner cero
            pr.setFloat(5, cliente.getDinero_membresia());
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

    //actualizamos cliente 
    public boolean actualizarCliente(Cliente cliente) {
        boolean resultado = true;
        PreparedStatement pr = null;
        String query = "UPDATE control_clientes.cliente SET nombre = ?, telefono = ?, dinero_gastado= ?, dinero_membresia= ? WHERE nit = ?";
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

    public ArrayList<Cliente> listarTopClientes() {
        ArrayList<Cliente> topClientes = new ArrayList<>();
        PreparedStatement pr = null;
        ResultSet rs = null;
        String query = "SELECT\n"
                + "    C.nit AS nit_cliente,\n"
                + "    C.nombre AS nombre_cliente,\n"
                + "    SUM(V.total_con_descuento) AS dinero_gastado_total\n"
                + "FROM\n"
                + "    control_clientes.cliente AS C\n"
                + "INNER JOIN\n"
                + "    control_ventas.venta AS V ON C.nit = V.nit\n"
                + "GROUP BY\n"
                + "    C.nit, C.nombre\n"
                + "ORDER BY\n"
                + "    dinero_gastado_total DESC\n"
                + "LIMIT\n"
                + "    10;";
        try {
            pr = Conexion.connection.prepareStatement(query);
            rs = pr.executeQuery();
            while (rs.next()) {
                Cliente clienteTop=new Cliente();
                clienteTop.setNit(rs.getString(1));
                clienteTop.setNombre(rs.getString(2));
                clienteTop.setDinero_gastado(rs.getFloat(3));
                topClientes.add(clienteTop);

            }
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al hacer busqueda en base de datos: " + e.getMessage());
        } finally {
            try {
                pr.close();
                rs.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar conexiones: " + e.getMessage());
            }
        }
        return topClientes;
    }

}
