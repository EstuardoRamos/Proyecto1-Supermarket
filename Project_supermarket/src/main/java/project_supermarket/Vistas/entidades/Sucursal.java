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
public class Sucursal {
    private int id_sucursal;
    private String nombre;
    private String direccion;
    private float dineroObtenido;

    public Sucursal() {
    }

    public int getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public float getDineroObtenido() {
        return dineroObtenido;
    }

    public void setDineroObtenido(float dineroObtenido) {
        this.dineroObtenido = dineroObtenido;
    }
    
    
    
            
}
