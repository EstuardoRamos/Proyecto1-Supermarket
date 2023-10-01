/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project_supermarket.controlers;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import project_supermarket.Vistas.entidades.Venta;
import project_supermarket.conection.Conexion;

/**
 * 
 * @author Estuardo Ramos
 */
public class VentaDatos {
    public boolean insertarVenta(Venta venta) {
        boolean resultado = true;
        PreparedStatement pr = null;
        String query = "INSERT INTO control_ventas.venta (id_venta, fecha, nit, id_empleado, id_sucursal, total_con_descuento, total_sin_descuento) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            pr = Conexion.connection.prepareStatement(query);
            pr.setInt(1, venta.getId_venta());
            pr.setDate(2, venta.getFecha());
            pr.setString(3, venta.getNit());
            pr.setInt(4, venta.getId_cajero());
            pr.setDouble(5, venta.getSucursal());
            pr.setFloat(6, venta.getTotal_con_descuento());
            pr.setFloat(7, venta.getTotal_sin_descuento());
            pr.executeUpdate();
        } catch (SQLException e) {
            resultado = false;
            JOptionPane.showMessageDialog(null, "Error al ingresar venta: " + e.getMessage());
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
