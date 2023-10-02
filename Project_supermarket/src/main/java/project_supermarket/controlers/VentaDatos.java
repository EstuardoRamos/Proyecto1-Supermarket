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
import project_supermarket.Vistas.entidades.Estanteria;
import project_supermarket.Vistas.entidades.Producto;
import project_supermarket.Vistas.entidades.Sucursal;
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

    public ArrayList<Venta> listarTopventas() {
        ArrayList<Venta> ventas = new ArrayList<>();
        PreparedStatement pr = null;
        ResultSet rs = null;
        String query = "SELECT\n"
                + "    id_venta,\n"
                + "    fecha,\n"
                + "    nit,\n"
                + "    id_empleado,\n"
                + "    id_sucursal,\n"
                + "    total_con_descuento\n"
                + "FROM\n"
                + "    control_ventas.venta\n"
                + "WHERE\n"
                + "    fecha BETWEEN '2023-01-01' AND '2023-12-31'\n"
                + "ORDER BY\n"
                + "    total_con_descuento DESC\n"
                + "LIMIT\n"
                + "    10;";
        try {
            pr = Conexion.connection.prepareStatement(query);
            //pr.setInt(1, id_tienda);
            rs = pr.executeQuery();
            while (rs.next()) {

                Venta venta = new Venta();
                venta.setId_venta(rs.getInt(1));
                venta.setFecha(rs.getDate(2));
                venta.setNit(rs.getString(3));
                venta.setId_cajero(rs.getInt(4));
                venta.setSucursal(rs.getInt(5));
                venta.setTotal_con_descuento(rs.getFloat(6));
                ventas.add(venta);
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
        return ventas;
    }

    public ArrayList<Sucursal> listarTopSucursales() {
        ArrayList<Sucursal> sucursales = new ArrayList<>();
        PreparedStatement pr = null;
        ResultSet rs = null;
        String query = "SELECT\n"
                + "    S.nombre AS nombre_sucursal,\n"
                + "    SUM(V.total_con_descuento) AS dinero_ingresado\n"
                + "FROM\n"
                + "    control_ventas.venta AS V\n"
                + "INNER JOIN\n"
                + "    control_super.sucursal AS S ON V.id_sucursal = S.id_sucursal\n"
                + "GROUP BY\n"
                + "    S.nombre\n"
                + "ORDER BY\n"
                + "    dinero_ingresado DESC\n"
                + "LIMIT\n"
                + "    3;";
        try {
            pr = Conexion.connection.prepareStatement(query);
           // pr.setInt(1, id_tienda);
            rs = pr.executeQuery();
            while (rs.next()) {
                Sucursal sucursal = new Sucursal();
                sucursal.setNombre(rs.getString(1));
                sucursal.setDineroObtenido(rs.getFloat(2));
                sucursales.add(sucursal);
                
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
        return sucursales;
    }

}
