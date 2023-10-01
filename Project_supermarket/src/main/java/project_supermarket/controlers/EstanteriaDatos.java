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
import project_supermarket.conection.Conexion;

/**
 *
 * @author Estuardo Ramos
 */
public class EstanteriaDatos {

    public boolean insertarProductoEstanteria(Estanteria estanteria) {
        boolean resultado = true;
        PreparedStatement pr = null;
        String query = "INSERT INTO control_inventario.producto (id_producto, id_sucursal, numero_pasillo,  cantidad) VALUES (?, ?, ?, ?);";
        try {
            pr = Conexion.connection.prepareStatement(query);
            pr.setString(1, estanteria.getId_producto());
            pr.setInt(2, estanteria.getId_sucursal());
            pr.setInt(3, estanteria.getNumero_pasillo());
            pr.setDouble(4, estanteria.getCantidad());
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

    public ArrayList<Producto> listarProductosDeEstanteria(int id_tienda) {
        ArrayList<Producto> estanterias = new ArrayList<>();
        PreparedStatement pr = null;
        ResultSet rs = null;
        String query = "SELECT\n"
                + "    E.id_producto,\n"
                + "    E.id_sucursal,\n"
                + "    E.numero_pasillo,\n"
                + "    E.cantidad,\n"
                + "    P.nombre AS nombre_producto, \n"
                + "    P.precio AS precio_producto, \n"
                +"     P.descripcion AS descripcion_producto\n"
                + "FROM\n"
                + "    control_inventario.estanteria AS E\n"
                + "INNER JOIN\n"
                + "    control_inventario.producto AS P ON E.id_producto = P.id_producto\n"
                + "WHERE\n"
                + "    E.cantidad > 0 AND E.id_sucursal = ?"
                + "	ORDER BY p.id_producto ASC;";
        try {
            pr = Conexion.connection.prepareStatement(query);
            pr.setInt(1, id_tienda);
            rs = pr.executeQuery();
            while (rs.next()) {
                Producto nuevo = new Producto();
                
                Producto estanteria= new Producto();
                estanteria.setCodigo_producto(rs.getString(1));
                estanteria.setId_sucursal(rs.getString(2));
                //estanteria.setNumero_pasillo(rs.getInt(3));
                estanteria.setCantidad(rs.getInt(4));
                estanteria.setNombre(rs.getString(5));
                estanteria.setPrecio(rs.getDouble(6));
                estanteria.setDescripcion(rs.getString(7));
                estanterias.add(estanteria);
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
        return estanterias;
    }
    public ArrayList<Estanteria> listarProductosDeEstanteria1(int id_tienda) {
        ArrayList<Estanteria> estanterias = new ArrayList<>();
        PreparedStatement pr = null;
        ResultSet rs = null;
        String query = "SELECT\n"
                + "    E.id_producto,\n"
                + "    E.id_sucursal,\n"
                + "    E.numero_pasillo,\n"
                + "    E.cantidad,\n"
                + "    P.nombre AS nombre_producto, \n"
                + "    P.precio AS precio_producto, \n"
                +"     P.descripcion AS descripcion_producto\n"
                + "FROM\n"
                + "    control_inventario.estanteria AS E\n"
                + "INNER JOIN\n"
                + "    control_inventario.producto AS P ON E.id_producto = P.id_producto\n"
                + "WHERE\n"
                + "    E.cantidad > 0 AND E.id_sucursal = ?"
                + "	ORDER BY p.id_producto ASC;";
        try {
            pr = Conexion.connection.prepareStatement(query);
            pr.setInt(1, id_tienda);
            rs = pr.executeQuery();
            while (rs.next()) {
                Producto nuevo = new Producto();
                
                Estanteria estanteria= new Estanteria();
                estanteria.setId_producto(rs.getString(1));
                //estanteria.setId_sucursal(rs.getString(2));
                estanteria.setNumero_pasillo(rs.getInt(3));
                estanteria.setCantidad(rs.getInt(4));
                estanteria.setName_producto(rs.getString(5));
                //estanteria.setPrecio(rs.getDouble(6));
                //estanteria.setDescripcion(rs.getString(7));
                estanterias.add(estanteria);
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
        return estanterias;
    }

    public boolean actualizarExistenciasEstanteriaResta(ListaProductos producto) {
        boolean resultado = true;
        System.out.println("Restando de db "+producto.getCantidad()+" id "+producto.getId_producto());
        PreparedStatement pr = null;
        String query = "UPDATE control_inventario.estanteria SET cantidad = cantidad - ? WHERE id_producto = ?";
        try {
            pr = Conexion.connection.prepareStatement(query);
            pr.setInt(1, producto.getCantidad());
            pr.setString(2, producto.getId_producto());
            pr.executeUpdate();
        } catch (SQLException e) {
            resultado = false;
            JOptionPane.showMessageDialog(null, "Error al actualizar producto: " + e.getMessage());
        } finally {
            try {
                pr.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar conexiones: " + e.getMessage());
            }
        }
        return resultado;
    }
    public boolean actualizarExistenciasEstanteriaSuma(ListaProductos producto) {
        boolean resultado = true;
        System.out.println("Restando de db "+producto.getCantidad()+" id "+producto.getId_producto());
        PreparedStatement pr = null;
        String query = "UPDATE control_inventario.estanteria SET cantidad = cantidad + ? WHERE id_producto = ?";
        try {
            pr = Conexion.connection.prepareStatement(query);
            pr.setInt(1, producto.getCantidad());
            pr.setString(2, producto.getId_producto());
            pr.executeUpdate();
        } catch (SQLException e) {
            resultado = false;
            JOptionPane.showMessageDialog(null, "Error al actualizar producto: " + e.getMessage());
        } finally {
            try {
                pr.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar conexiones: " + e.getMessage());
            }
        }
        return resultado;
    }
    
    public Producto listarProductosPorCodigo(String codigo, int id_tienda) {
        Producto producto = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        String query = "SELECT * FROM control_inventario.estanteria WHERE id_producto = ? AND id_sucursal= ?;";
        try {
            pr = Conexion.connection.prepareStatement(query);
            pr.setString(1, codigo);
            pr.setInt(2, id_tienda);
            rs = pr.executeQuery();
            while (rs.next()) {
                producto = new Producto();
                producto.setCodigo_producto(rs.getString(1));
                producto.setNombre(rs.getString(2));
                producto.setDescripcion(rs.getString(3));
                producto.setCantidad(rs.getInt(4));
                producto.setPrecio(rs.getDouble(5));
                producto.setId_sucursal(rs.getString(6));
                //producto.setId_tienda(rs.getInt(7));
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
        return producto;
    }

}


