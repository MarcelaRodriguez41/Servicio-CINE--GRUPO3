package model;

import Sucursales.Sucursales;
import personal.Empleado;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TablaSucursal extends AbstractTableModel {
    public List<Sucursales> Datos;
    public String [] columnas = {"Id", "Telefono", "Correo", "Direccion", "Cantidad de Empleados", "Cantidad de Salas"};
    public TablaSucursal (List<Sucursales> _Datos){
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
        Sucursales fila = Datos.get(rowIndex);
        switch (columnIndex)
        {
            case 0: return fila.getid();
            case 1: return fila.gettelefono();
            case 2: return fila.getcorreo();
            case 3: return fila.getdireccion();
            case 4: return fila.getcantidadEmpleados();
            default: return fila.getcantidadSalas();


        }
    }
    public String getColumnName (int col)
    {
        return columnas [col];
    }
}
