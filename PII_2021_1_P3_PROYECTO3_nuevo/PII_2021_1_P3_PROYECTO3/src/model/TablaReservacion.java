package model;

import personal.Empleado;
import reservas.Reservaciones;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TablaReservacion extends AbstractTableModel {

    public List<Reservaciones> Datos;
    public String[] columnas = {"Id", "Nombre de Cliente", "Nombre de Empleado", "Nombre de Pelicula",
            "Fecha", "Hora"};

    public TablaReservacion(List<Reservaciones> _Datos) {
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
        Reservaciones fila = Datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return fila.getId();
            case 1:
                return fila.getnombreCliente();
            case 2:
                return fila.getnombreEmpleado();
            case 3:
                return fila.getnombrePelicula();
            case 4:
                return fila.getfecha();
            default:
                return fila.gethora();

        }
    }
}