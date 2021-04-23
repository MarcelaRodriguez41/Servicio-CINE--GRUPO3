package model;

import Actores.actores;
import horario.Horarios;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TablaHorarios extends AbstractTableModel {

    public List<Horarios> Datos;
    public String [] columnas = {"Id", " Hora de Inicio", "Hora Final", "Nombre de Pelicula", "Fecha"};
    public TablaHorarios (List<Horarios> _Datos){
        Datos = _Datos;
    }
    @Override
    public int getRowCount() {
        return Datos.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Horarios fila = Datos.get(rowIndex);
        switch (columnIndex)
        {
            case 0: return fila.getId();
            case 1: return fila.getHoraInicio();
            case 2: return fila.getHoraFinal();
            case 3: return fila.getNombrePelicula();
            default: return fila.getFecha();

        }
    }
    public String getColumnName (int col)
    {
        return columnas [col];
    }
}
