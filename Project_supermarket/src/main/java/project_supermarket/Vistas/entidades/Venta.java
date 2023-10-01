/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project_supermarket.Vistas.entidades;

import java.sql.Date;

/**
 * 
 * @author Estuardo Ramos
 */
public class Venta {
    private int id_venta;
    private Date fecha;
    private  String nit;
    private int id_cajero;
    private int sucursal;
    private float total_con_descuento;
    private float total_sin_descuento;

    public Venta() {
    }

    public int getId_cajero() {
        return id_cajero;
    }

    public void setId_cajero(int id_cajero) {
        this.id_cajero = id_cajero;
    }

    public Venta(int id_venta, Date fecha, String nit, int id_cajero, int sucursal, float total_con_descuento, float total_sin_descuento) {
        this.id_venta = id_venta;
        this.fecha = fecha;
        this.nit = nit;
        this.id_cajero = id_cajero;
        this.sucursal = sucursal;
        this.total_con_descuento = total_con_descuento;
        this.total_sin_descuento = total_sin_descuento;
    }
    
    
    
    

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public int getSucursal() {
        return sucursal;
    }

    public void setSucursal(int sucursal) {
        this.sucursal = sucursal;
    }

    public float getTotal_con_descuento() {
        return total_con_descuento;
    }

    public void setTotal_con_descuento(float total_con_descuento) {
        this.total_con_descuento = total_con_descuento;
    }

    public float getTotal_sin_descuento() {
        return total_sin_descuento;
    }

    public void setTotal_sin_descuento(float total_sin_descuento) {
        this.total_sin_descuento = total_sin_descuento;
    }

    @Override
    public String toString() {
        return "Venta{" + "id_venta=" + id_venta + ", fecha=" + fecha + ", nit=" + nit + ", id_cajero=" + id_cajero + ", sucursal=" + sucursal + ", total_con_descuento=" + total_con_descuento + ", total_sin_descuento=" + total_sin_descuento + '}';
    }
    
    
    
    
    
    

}
