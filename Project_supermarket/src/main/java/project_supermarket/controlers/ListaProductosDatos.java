/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project_supermarket.controlers;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import project_supermarket.Vistas.entidades.Producto;
import project_supermarket.conection.Conexion;

/**
 * 
 * @author Estuardo Ramos
 */
public class ListaProductosDatos {
    
    
    public boolean insertarListaProductos(ListaProductos producto) {
        boolean resultado = true;
        PreparedStatement pr = null;
        String query = "INSERT INTO control_ventas.lista_de_priductos (id_venta, id_producto, cantidad) VALUES (?, ?, ?);";
        try {
            pr = Conexion.connection.prepareStatement(query);
            pr.setString(1, producto.getId_venta());
            pr.setString(2, producto.getId_producto());
            pr.setInt(3, producto.getCantidad());
            //pr.setDouble(4, producto.getPrecio());
            //pr.setInt(5, producto.getCantidad());
           // pr.setInt(6, producto.getId_tienda());
            pr.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto registrado correctamente");
        } catch (SQLException e) {
            resultado = false;
            JOptionPane.showMessageDialog(null, "Error al ingresar producto: " + e.getMessage());
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
