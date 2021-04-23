package model;

import Usuarios.Usuario;
import personal.Empleado;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TablaUsuario extends AbstractTableModel {

    public List<Usuario> Datos;
    public String [] columnas = {"Id", "Nombre de Usuario", "Contraseña", "Edad", "Descripcion"};
    public TablaUsuario (List<Usuario> _Datos){
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
        Usuario fila = Datos.get(rowIndex);
        switch (columnIndex)
        {
            case 0: return fila.getid();
            case 1: return fila.getnombreUsuario();
            case 2: return fila.getcontraseña();
            case 3: return fila.getedad();
            default: return fila.getdescripcion();
        }
    }
    public String getColumnName (int col)
    {
        return columnas [col];
    }
}
