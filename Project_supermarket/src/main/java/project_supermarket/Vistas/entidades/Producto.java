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
public class Producto {
    private String codigo_producto;
    private String nombre;
    private String descripcion;
    private int cantidad;
    private double precio;
    private String id_sucursal;
    

    public Producto() {
    }

    public String getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(String id_sucursal) {
        this.id_sucursal = id_sucursal;
    }
    

    public String getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(String codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
    

}
