/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project_supermarket.controlers;

/**
 * 
 * @author Estuardo Ramos
 */
public class ListaProductos {
    private String id_venta;
    private String id_producto;
    private int cantidad;
    private Double precio_u;
    private Double total_prod;

    public ListaProductos() {
    }

    public String getId_venta() {
        return id_venta;
    }

    public void setId_venta(String id_venta) {
        this.id_venta = id_venta;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio_u() {
        return precio_u;
    }

    public void setPrecio_u(Double precio_u) {
        this.precio_u = precio_u;
    }

    public Double getTotal_prod() {
        return total_prod;
    }

    public void setTotal_prod(Double total_prod) {
        this.total_prod = total_prod;
    }

    @Override
    public String toString() {
        return "ListaProductos{" + "id_venta=" + id_venta + ", id_producto=" + id_producto + ", cantidad=" + cantidad + ", precio_u=" + precio_u + ", total_prod=" + total_prod + '}';
    }
    
    
    
    
    
    

}
