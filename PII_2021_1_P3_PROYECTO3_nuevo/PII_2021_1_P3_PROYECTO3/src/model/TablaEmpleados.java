package model;

import Actores.actores;
import personal.Empleado;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TablaEmpleados extends AbstractTableModel {
    public List<Empleado> Datos;
    public String [] columnas = {"Id", "Codigo", "Celular", "Correo", "Nombre de Empleado", "Direccion"};
    public TablaEmpleados (List<Empleado> _Datos){
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
        Empleado fila = Datos.get(rowIndex);
        switch (columnIndex)
        {
            case 0: return fila.getId();
            case 1: return fila.getCodigo();
            case 2: return fila.getCelular();
            case 3: return fila.getCorreo();
            case 4: return fila.getNombreEmpleado();
            default: return fila.getDireccion();


        }
    }
    public String getColumnName (int col)
    {
        return columnas [col];
    }
}
