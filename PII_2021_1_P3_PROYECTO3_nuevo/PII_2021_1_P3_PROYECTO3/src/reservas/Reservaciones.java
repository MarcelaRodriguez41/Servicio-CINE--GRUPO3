package reservas;



public class Reservaciones {
    private long id;
    private String nombreCliente;
    private String nombreEmpleado;
    private String nombrePelicula;
    private String fecha;
    private String hora;

    public Reservaciones(){
    }
    public Reservaciones(long id, String nombreCliente, String nombreEmpleado, String nombrePelicula,String fecha, String hora)
    {
        this.id             = id;
        this.nombreCliente  = nombreCliente;
        this.nombreEmpleado = nombreEmpleado;
        this.nombrePelicula = nombrePelicula;
        this.fecha          = fecha;
        this.hora           = hora;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getnombreCliente() {
        return nombreCliente;
    }

    public void setnombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getnombreEmpleado() {
        return nombreEmpleado;
    }

    public void setnombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getnombrePelicula() {
        return nombrePelicula;
    }

    public void setnombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public String getfecha() {
        return fecha;
    }

    public void setfecha(String fecha) {
        this.fecha = fecha;
    }

    public String gethora() {
        return hora;
    }

    public void sethora(String hora) {
        this.hora = hora;
    }
    public String getDataReservacion (){
        return "Nombre de Cliente : "   + getnombreCliente() + '\n' +
                "Nombre de Empleado : "    + getnombreEmpleado() + '\n' +
                "Nombre de Pelicula :"   + getnombrePelicula() + '\n' +
                "Fecha : "   +getfecha() +'\n'+
                "Hora: " + gethora();

    }
}