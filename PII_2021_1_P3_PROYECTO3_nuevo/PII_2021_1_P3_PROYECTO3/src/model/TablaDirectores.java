package model;

import Actores.actores;
import Directores.Directores;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TablaDirectores extends AbstractTableModel {
    public List<Directores> Datos;
    public String [] columnas = {"Id", "Nombre de Director", " Fecha de Nacimiento", "Cantidad de Peliculas Dirigidas",
            "Nacionalidad", "Generos Dirigidos"};
    public TablaDirectores (List<Directores> _Datos){
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
        Directores fila = Datos.get(rowIndex);
        switch (columnIndex)
        {
            case 0: return fila.getId();
            case 1: return fila.getNombreDirector();
            case 2: return fila.getFechaNacimiento();
            case 3: return fila.getCantidadPeliculasDirigidas();
            case 4: return fila.getNacionalidad();
            default: return fila.getGenerosDirigidos();


        }
    }
    public String getColumnName (int col)
    {
        return columnas [col];
    }
}
