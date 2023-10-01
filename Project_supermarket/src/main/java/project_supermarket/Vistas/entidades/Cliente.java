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
public class Cliente {
    private String nit;
    private String nombre;
    private String telefono;
    private int tarjeta;
    private float dinero_gastado;
    private float dinero_membresia;

    public Cliente() {
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(int tarjeta) {
        this.tarjeta = tarjeta;
    }

    public float getDinero_gastado() {
        return dinero_gastado;
    }

    public void setDinero_gastado(float dinero_gastado) {
        this.dinero_gastado = dinero_gastado;
    }

    public float getDinero_membresia() {
        return dinero_membresia;
    }

    public void setDinero_membresia(float dinero_membresia) {
        this.dinero_membresia = dinero_membresia;
    }
    
    
    

}
