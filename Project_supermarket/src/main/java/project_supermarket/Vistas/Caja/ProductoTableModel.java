/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project_supermarket.Vistas.Caja;

/**
 * 
 * @author Estuardo Ramos
 */
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import project_supermarket.Vistas.entidades.Producto;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ProductoTableModel extends AbstractTableModel {
    private ArrayList<Producto> productos;
    private String[] columnNames = {"Código", "Nombre", "Descripción", "Cantidad", "Precio", "ID Sucursal"};

    public ProductoTableModel(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public int getRowCount() {
        return productos.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Producto producto = productos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return producto.getCodigo_producto();
            case 1:
                return producto.getNombre();
            case 2:
                return producto.getDescripcion();
            case 3:
                return producto.getCantidad();
            case 4:
                return producto.getPrecio();
            case 5:
                return producto.getId_sucursal();
            default:
                return null;
        }
    }
}
