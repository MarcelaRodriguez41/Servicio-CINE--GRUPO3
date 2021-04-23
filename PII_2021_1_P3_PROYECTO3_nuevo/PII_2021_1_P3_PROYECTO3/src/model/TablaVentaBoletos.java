package model;

import personal.Empleado;
import ventas.VentaBoletos;
import ventas.VentaComida;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TablaVentaBoletos extends AbstractTableModel {

    public List<VentaBoletos> Datos;
    public String [] columnas = {"Id", " Nombre Cliente ", " Nombre Empleado", " Nombre `Pelicula", "Precio de Boleto", "Cantidad de Boletos","Fecha"};
    public TablaVentaBoletos (List<VentaBoletos> _Datos){
        Datos = _Datos;
    }
    @Override
    public int getRowCount() {
        return Datos.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VentaBoletos fila = Datos.get(rowIndex);
        switch (columnIndex)
        {
            case 0: return fila.getid();
            case 1: return fila.getnombreCliente();
            case 2: return fila.getnombreEmpleado();
            case 3: return fila.getnombrePelicula();
            case 4: return fila.getprecioBoleto();
            case 5: return fila.getfecha();
            default: return fila.getcantidadBoletos();


        }
    }
    public String getColumnName (int col)
    {
        return columnas [col];
    }
}
