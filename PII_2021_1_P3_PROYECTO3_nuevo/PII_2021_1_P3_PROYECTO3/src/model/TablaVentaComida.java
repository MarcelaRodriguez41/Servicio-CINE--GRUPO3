package model;

import personal.Empleado;
import ventas.VentaComida;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TablaVentaComida extends AbstractTableModel {
    public List<VentaComida> Datos;
    public String [] columnas = {"Id", "Nombre de Cliente", "Nombre de Empleado", "Nombre de Producto", "Cantidad de Producto", "Precio de Producto"};
    public TablaVentaComida (List<VentaComida> _Datos){
        Datos = _Datos;
    }
    @Override
    public int getRowCount() {
        return Datos.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       VentaComida fila = Datos.get(rowIndex);
        switch (columnIndex)
        {
            case 0: return fila.getid();
            case 1: return fila.getnombreCliente();
            case 2: return fila.getnombreEmpleado();
            case 3: return fila.getnombreProducto();
            case 4: return fila.getcantidadProducto();
            default: return fila.getprecioProducto();


        }
    }
    public String getColumnName (int col)
    {
        return columnas [col];
    }
}
