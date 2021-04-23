package model;

import Actores.actores;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TablaActores extends AbstractTableModel {
 public List<actores> Datos;
 public String [] columnas = {"Id", "Nombre de Actor", " Alias", "Generos Interpretados", "Nacionalidad", "Sexo",
                              "Fecha de Nacimiento", "Cantidad de Peliculas Grabadas"};
 public TablaActores (List<actores> _Datos){
     Datos = _Datos;
 }
    @Override
    public int getRowCount() {
        return Datos.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        actores fila = Datos.get(rowIndex);
        switch (columnIndex)
        {
            case 0: return fila.getId();
            case 1: return fila.getNombreActor();
            case 2: return fila.getAlias();
            case 3: return fila.getGenerosInterpretados();
            case 4: return fila.getNacionalidad();
            case 5: return fila.getSexo();
            case 6: return fila.getfechaNacimiento();
            default: return fila.getCantidadPeliculasGrabadas();

        }
    }
    public String getColumnName (int col)
    {
           return columnas [col];
    }
}
