package model;

import establecimiento.Salas;
import personal.Empleado;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TablaSalas extends AbstractTableModel {
    public List<Salas> Datos;
    public String [] columnas = {"Id", "Nombre de Sala", "Cantidad de Filas", "Cantidad de Columnas",
                                 "Cantidad de Asientos Preferencial", "Disponibilidad"};
    public TablaSalas (List<Salas> _Datos){
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
      Salas fila = Datos.get(rowIndex);
        switch (columnIndex)
        {
            case 0: return fila.getId();
            case 1: return fila.getNombreSala();
            case 2: return fila.getCantidadFilas();
            case 3: return fila.getCantidadColumnas();
            case 4: return fila.getCantidadAsientosPreferencial();
            default: return fila.getEstadoDisponibilidad();

        }
    }
    public String getColumnName (int col)
    {
        return columnas [col];
    }

}
