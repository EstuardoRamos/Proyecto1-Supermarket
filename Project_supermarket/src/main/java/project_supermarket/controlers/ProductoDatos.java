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
import project_supermarket.Vistas.entidades.Producto;
import project_supermarket.conection.Conexion;

/**
 *
 * @author Estuardo Ramos
 */
public class ProductoDatos {

    public Producto listarProductosPorId(int id_producto) {
        Producto producto = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        String query = "SELECT * FROM ControlEmpresa.Producto WHERE id_producto = ?;";
        try {
            pr = Conexion.connection.prepareStatement(query);
            pr.setInt(1, id_producto);
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

    public boolean eliminarProducto(Producto producto) {
        boolean resultado = true;
        PreparedStatement pr = null;
        String query = "DELETE FROM ControlEmpresa.Producto WHERE id_producto = ?";
        try {
            pr = Conexion.connection.prepareStatement(query);
            pr.setString(1, producto.getCodigo_producto());
            pr.executeUpdate();
        } catch (SQLException e) {
            resultado = false;
            JOptionPane.showMessageDialog(null, "Error al borrar producto: " + e.getMessage());
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
     * Actualiza la informacion del producto de una base de datos
     *
     * @param producto El producto que se actualizará
     * @return Un booleano que indica si la operacion fue exitosa
     */
    public boolean actualizarProducto(Producto producto) {
        boolean resultado = true;
        PreparedStatement pr = null;
        String query = "UPDATE ControlEmpresa.Producto SET nombre = ?, fabricante = ?, codigo = ?, precio = ?, cantidad = ? WHERE id_producto = ?";
        try {
            pr = Conexion.connection.prepareStatement(query);
            pr.setString(1, producto.getNombre());
            pr.setString(2, producto.getDescripcion());
            pr.setInt(3, producto.getCantidad());
            pr.setDouble(4, producto.getPrecio());
            pr.setInt(5, producto.getCantidad());
            pr.setString(6, producto.getCodigo_producto());
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

    /**
     * Inserta un producto en la base de datos
     *
     * @param producto El producto que se insertará en la base de datos
     * @return Un booleano que indica si la operacion fue exitosa
     */
    public boolean insertarProducto(Producto producto) {
        boolean resultado = true;
        PreparedStatement pr = null;
        String query = "INSERT INTO control_inventario.producto (nombre, fabricante, codigo, precio, cantidad, id_tienda) VALUES (?, ?, ?, ?, ?, ?);";
        try {
            pr = Conexion.connection.prepareStatement(query);
            pr.setString(1, producto.getNombre());
            pr.setString(2, producto.getDescripcion());
            pr.setInt(3, producto.getCantidad());
            pr.setDouble(4, producto.getPrecio());
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

    /**
     * Lista a los productos por codigo y el id de la tienda
     *
     * @param codigo El codigo del producto
     * @param id_tienda El id de la tienda
     * @return La informacion del producto
     */
    public Producto listarProductosPorCodigo(String codigo, int id_tienda) {
        Producto producto = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        String query = "SELECT * FROM control_inventario.producto WHERE id_producto = ? AND id_sucursal= ?;";
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

    /**
     * Lista a los productos que se encuentran en una tienda diferente a la
     * indicada
     *
     * @param id_tienda El identificador de la tienda actual
     * @return La lista de productos
     */
    public ArrayList<Producto> listarProductosDeTienda(int id_tienda) {
        System.out.println("entrando");
        ArrayList<Producto> productos = new ArrayList<>();
        PreparedStatement pr = null;
        ResultSet rs = null;
        String query = "SELECT p.id_producto, p.nombre, p.descripcion, p.cantidad, p.precio, t.nombre as sucursal\n"
                + "	FROM control_inventario.producto p\n"
                + "	JOIN control_super.sucursal t ON p.id_sucursal = t.id_sucursal\n"
                + "	WHERE p.id_sucursal = ? AND p.cantidad > 0\n"
                + "	ORDER BY p.id_producto ASC;";
        try {
            pr = Conexion.connection.prepareStatement(query);
            pr.setInt(1, id_tienda);
            rs = pr.executeQuery();
            while (rs.next()) {
                Producto nuevo = new Producto();
                nuevo.setCodigo_producto(rs.getString(1));
                nuevo.setNombre(rs.getString(2));
                nuevo.setDescripcion(rs.getString(3));
                nuevo.setCantidad(rs.getInt(4));
                nuevo.setPrecio(rs.getDouble(5));
                nuevo.setId_sucursal(rs.getString(6));
                //nuevo.setNombreTienda(rs.getString(7));
                productos.add(nuevo);
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
        return productos;
    }

    /**
     * Actualiza las existencias de un producto en la base de datos
     * posteriormente a la realizacion de una venta
     *
     * @param producto El producto al que se le actualizaran las existencias
     * @return Un boolean que indica si la operacion fue exitosa.
     */
    public boolean actualizarExistencias(Producto producto) {
        boolean resultado = true;
        PreparedStatement pr = null;
        String query = "UPDATE control_inventario.producto SET cantidad = ? WHERE id_producto = ?";
        try {
            pr = Conexion.connection.prepareStatement(query);
            pr.setInt(1, producto.getCantidad());
            pr.setString(2, producto.getCodigo_producto());
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

    public ArrayList<Producto> listarTopProductosVendidos() {
        System.out.println("entrando");
        ArrayList<Producto> productos = new ArrayList<>();
        PreparedStatement pr = null;
        ResultSet rs = null;
        String query = "SELECT\n"
                + "    P.nombre AS nombre_producto,\n"
                + "    SUM(LP.cantidad) AS cantidad_vendida\n"
                + "FROM\n"
                + "    control_ventas.lista_de_priductos AS LP\n"
                + "INNER JOIN\n"
                + "    control_inventario.producto AS P ON LP.id_producto = P.id_producto\n"
                + "GROUP BY\n"
                + "    P.nombre\n"
                + "ORDER BY\n"
                + "    cantidad_vendida DESC\n"
                + "LIMIT\n"
                + "    10;";
        try {
            pr = Conexion.connection.prepareStatement(query);
            //pr.setInt(1, id_tienda);
            rs = pr.executeQuery();
            while (rs.next()) {
                Producto productoTop = new Producto();
                productoTop.setNombre(rs.getString(1));
                productoTop.setCantidad(rs.getInt(2));
                
                //nuevo.setNombreTienda(rs.getString(7));
                productos.add(productoTop);
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
        return productos;
    }

}
