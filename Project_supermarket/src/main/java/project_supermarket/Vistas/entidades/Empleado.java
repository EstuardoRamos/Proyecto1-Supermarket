/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project_supermarket.Vistas.entidades;

/**
 * 
 * @author Estuardo Ramos
 */
public class Empleado {
    private int id_empleado;
    private String user;
    private String nombre;
    private String password;
    private String tipo;
    private int sucursal;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    

    public Empleado(int id_empleado, String user, String nombre, String password, int sucursal) {
        this.id_empleado = id_empleado;
        this.user = user;
        this.nombre = nombre;
        this.password = password;
        this.sucursal = sucursal;
    }

    public Empleado() {
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSucursal() {
        return sucursal;
    }

    public void setSucursal(int sucursal) {
        this.sucursal = sucursal;
    }
    
    
    
}
