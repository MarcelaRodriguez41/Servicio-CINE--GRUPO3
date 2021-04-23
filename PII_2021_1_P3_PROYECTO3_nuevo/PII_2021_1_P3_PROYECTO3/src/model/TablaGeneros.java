package model;

import Actores.actores;
import Generos.Generos;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TablaGeneros extends AbstractTableModel {

    public List<Generos> Datos;
    public String [] columnas = {"Id", "Categoria"};
    public TablaGeneros (List<Generos> _Datos){
        Datos = _Datos;
    }
    @Override
    public int getRowCount() {
        return Datos.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Generos fila = Datos.get(rowIndex);
        switch (columnIndex)
        {
            case 0: return fila.getId();
            default: return fila.getCategoria();
        }
    }
    public String getColumnName (int col)
    {
        return columnas [col];
    }
}
