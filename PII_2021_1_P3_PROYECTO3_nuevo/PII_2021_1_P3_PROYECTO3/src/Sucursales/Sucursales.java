package Sucursales;

public class Sucursales {
    private long    id;
    private long   telefono;
    private String   correo;
    private String direccion;
    private int    cantidadEmpleados;
    private int    cantidadSalas;

    public Sucursales(){
    }
    public Sucursales(long id, long telefono, String correo, String direccion, int cantidadEmpleados, int cantidadSalas)
    {
        this.id = id;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.cantidadEmpleados = cantidadEmpleados;
        this.cantidadSalas = cantidadSalas;
    }

    public long getid() {
        return id;
    }

    public void setid(long id) {
        this.id = id;
    }

    public String getdireccion() {
        return direccion;
    }

    public void setdireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getcantidadEmpleados() {
        return cantidadEmpleados;
    }

    public void setcantidadEmpleados(int cantidadEmpleados) {
        this.cantidadEmpleados = cantidadEmpleados;
    }

    public String getcorreo() {
        return correo;
    }

    public void setcorreo(String correo) {
        this.correo = correo;
    }

    public int getcantidadSalas() {
        return cantidadSalas;
    }

    public void setcantidadSalas(int cantidadSalas) {
        this.cantidadSalas = cantidadSalas;
    }

    public long gettelefono() {
        return telefono;
    }

    public void settelefono(long telefono) {
        this.telefono = telefono;
    }
    public String getDataSucursal(){
        return "Telefono : "   + gettelefono() + '\n' +
                "Correo : "    + getcorreo() + '\n' +
                "Direccion: " + getdireccion() + '\n' +
                "Cantidad de Empleados  : "   +getcantidadEmpleados() +'\n'+
                "Cantidad de Salas : " + getcantidadSalas();

    }
}
