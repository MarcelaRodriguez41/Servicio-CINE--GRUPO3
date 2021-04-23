package model;

import peliculas.Pelicula;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TablaPeliculas extends AbstractTableModel {
    public List<Pelicula> Datos;
    public String [] columnas = {"Id", "Nombre de Pelicula", " Sinopsis", "Genero", "Nacionalidad", "Duracion", "Director"};
    public TablaPeliculas (List<Pelicula> _Datos){
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
     Pelicula fila = Datos.get(rowIndex);
        switch (columnIndex)
        {
            case 0: return fila.getId();
            case 1: return fila.getNombrePelicula();
            case 2: return fila.getSinopsis();
            case 3: return fila.getGenero();
            case 4: return fila.getNacionalidad();
            case 5: return fila.getDuracion();
            default: return fila.getDirector();


        }
    }
    public String getColumnName (int col)
    {
        return columnas [col];
    }

}
