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
import project_supermarket.Vistas.entidades.Empleado;
import project_supermarket.conection.Conexion;

/**
 *
 * @author Estuardo Ramos
 */
public class EmpleadoDao {

    public Empleado obtenerEmpleadoLogin(String username, String password) {
        Empleado empleado = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        Conexion conexion = new Conexion();

        try {
            conexion.iniciarConexion();
            System.out.println("user" + username + password);

            String query = "SELECT * FROM control_super.empleado WHERE usuario = ? AND contrasenia = ?;";
            pr = Conexion.connection.prepareStatement(query);
            pr.setString(1, username);
            pr.setString(2, password);
            rs = pr.executeQuery();

            while (rs.next()) {
                empleado = new Empleado();
                empleado.setId_empleado(rs.getInt(1));
                empleado.setUser(rs.getString(2));
                empleado.setPassword(rs.getString(3));
                empleado.setNombre(rs.getString(4));
                empleado.setSucursal(rs.getInt(5));
                empleado.setTipo(rs.getString(6));
            }

            pr.close();
            rs.close();
        } catch (SQLException e) {
            // Manejo de excepciones
            e.printStackTrace();
        } finally {
            // Cierre de recursos si es necesario
            try {
                if (pr != null) {
                    pr.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return empleado;
    }
    
    
      public boolean borrarEmpleado(Empleado empleado) {
        boolean resultado = true;
        PreparedStatement pr = null;
        String query = "DELETE FROM ControlPersonal.Empleado WHERE id_empleado = ?";
        try {
            pr = Conexion.connection.prepareStatement(query);
            pr.setInt(1, empleado.getId_empleado());
            pr.executeUpdate();
        } catch (SQLException e) {
            resultado = false;
            JOptionPane.showMessageDialog(null, "Error al borrar empleado: " + e.getMessage());
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
     * Actualiza la informacion de un empleado
     * @param empleado El empleado que se actualizara
     * @return Un booleano que indica si la operacion fue exitosa
     */
    public boolean actualizarEmpleado(Empleado empleado) {
        boolean resultado = true;
        PreparedStatement pr = null;
        String query = "UPDATE ControlPersonal.Empleado SET nombre = ?, telefono = ?, rol = ?, dpi = ?, id_tienda = ?, username = ? WHERE id_empleado = ?";
        try {
            pr = Conexion.connection.prepareStatement(query);
            pr.setString(1, empleado.getUser());
            pr.setString(2, empleado.getPassword());
            pr.setString(3, empleado.getNombre());
            pr.setInt(4, empleado.getSucursal());
            pr.setString(5, empleado.getTipo());
            pr.executeUpdate();
        } catch (SQLException e) {
            resultado = false;
            JOptionPane.showMessageDialog(null, "Error al actualizar empleado: " + e.getMessage());
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
     * Inserta un empleado en la base de datos
     * @param empleado El empleado que se va a insertar
     * @return Un booleano que indica si la operacio fue exitosa
     */
    public boolean insertarEmpleado(Empleado empleado) {
        boolean resultado = true;
        PreparedStatement pr = null;
        String query = "INSERT INTO control_super.empleado (usuario, contrasenia, nombre, sucursal, tipo) VALUES (?, ?, ?, ?, ?);";
        try {
            pr = Conexion.connection.prepareStatement(query);
            pr.setString(1, empleado.getUser());
            pr.setString(2, empleado.getPassword());
            pr.setString(3, empleado.getNombre());
            pr.setInt(4, empleado.getSucursal());
            pr.setString(5, empleado.getTipo());
            pr.executeUpdate();
            JOptionPane.showMessageDialog(null, "Empleado registrado correctamente");
        } catch (SQLException e) {
            resultado = false;
            JOptionPane.showMessageDialog(null, "Error al ingresar empleado: " + e.getMessage());
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
     * Obtiene un empleado de la base de datos por el identificador
     * @param id_empleado El identificador del empleado
     * @return La informacion del empleado
     */
    public Empleado obtenerEmpleadoPorId(int id_empleado) {
        Empleado empleado = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        String query = "SELECT * FROM ControlPersonal.Empleado WHERE Id_empleado = ?";
        try {
            pr = Conexion.connection.prepareStatement(query);
            pr.setInt(1, id_empleado);
            rs = pr.executeQuery();
            while (rs.next()) {
                empleado = new Empleado();
                empleado.setId_empleado(rs.getInt(1));
                empleado.setUser(rs.getString(2));
                empleado.setPassword(rs.getString(3));
                empleado.setNombre(rs.getString(4));
                empleado.setSucursal(rs.getInt(5));
                empleado.setTipo(rs.getString(6));
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
        return empleado;
    }

    /**
     * Lista a los empleados segun un parametro de busqueda
     * @param nombre El nombre del empleado
     * @return La lista de empleados
     */
    public ArrayList<Empleado> listarEmpleadosPorNombre(String nombre) {
        ArrayList<Empleado> empleados = new ArrayList<>();
        PreparedStatement pr = null;
        ResultSet rs = null;
        String query = "SELECT e.Id_empleado, e.Nombre, e.Telefono, e.Rol, e.Dpi, t.Nombre\n"
                + "	FROM ControlPersonal.Empleado e JOIN ControlEmpresa.Tienda t\n"
                + "	ON e.Id_tienda = t.Id_tienda WHERE e.Nombre ILIKE '%" + nombre + "%' ORDER BY e.Id_empleado ASC;";
        try {
            pr = Conexion.connection.prepareStatement(query);
            rs = pr.executeQuery();
            while (rs.next()) {
                Empleado nuevo = new Empleado();
                nuevo.setId_empleado(rs.getInt(1));
                nuevo.setUser(rs.getString(2));
                nuevo.setPassword(rs.getString(3));
                nuevo.setNombre(rs.getString(4));
                nuevo.setSucursal(rs.getInt(5));
                nuevo.setTipo(rs.getString(6));
                empleados.add(nuevo);
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
        return empleados;
    }

    /**
     * Lista a los empleados de la base de datos
     * @param orden El tipo de orden que ordenará la lista
     * @return La lista de empleados
     */
    public ArrayList<Empleado> listarEmpleados(int orden) {
        ArrayList<Empleado> empleados = new ArrayList<>();
        PreparedStatement pr = null;
        ResultSet rs = null;
        String query = "SELECT e.Id_empleado, e.Nombre, e.Telefono, e.Rol, e.Dpi, t.Nombre\n"
                + "	FROM ControlPersonal.Empleado e JOIN ControlEmpresa.Tienda t\n"
                + "	ON e.Id_tienda = t.Id_tienda ";
        switch (orden) {
            case 1:
                query += "ORDER BY e.Nombre ASC;";
                break;
            case 2:
                query += "ORDER BY e.Rol ASC;";
                break;
            case 3:
                query += "ORDER BY t.Nombre ASC;";
                break;
            default:
                query += "ORDER BY e.Id_empleado ASC;";
        }
        try {
            pr = Conexion.connection.prepareStatement(query);
            rs = pr.executeQuery();
            while (rs.next()) {
                Empleado nuevo = new Empleado();
                nuevo.setId_empleado(rs.getInt(1));
                nuevo.setUser(rs.getString(2));
                nuevo.setPassword(rs.getString(3));
                nuevo.setNombre(rs.getString(4));
                nuevo.setSucursal(rs.getInt(5));
                nuevo.setTipo(rs.getString(6));
                empleados.add(nuevo);
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
        return empleados;
    }

}
