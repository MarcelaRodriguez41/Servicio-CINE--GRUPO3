package ventas;


public class VentaBoletos {
    private long    id;
    private String nombreCliente;
    private String nombreEmpleado;
    private String nombrePelicula;
    private int    cantidadBoletos;
    private int    precioBoleto;
    private String   fecha;

    public VentaBoletos() {
    }
    public VentaBoletos(long id, String nombreCliente, String nombreEmpleado, String nombrePelicula, int cantidadBoletos, int precioBoleto, String fecha)
    {
        this.id              = id;
        this.nombreCliente   = nombreCliente;
        this.nombreEmpleado  = nombreEmpleado;
        this.nombrePelicula  = nombrePelicula;
        this.cantidadBoletos = cantidadBoletos;
        this.precioBoleto    = precioBoleto;
        this.fecha           = fecha;
    }

    public long getid() {
        return id;
    }

    public void setid(long id) {
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

    public void setnombreEmpleado(String NombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getnombrePelicula() {
        return nombrePelicula;
    }

    public void setnombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public int getcantidadBoletos() {
        return cantidadBoletos;
    }

    public void setcantidadBoletos(int cantidadBoletos) {
        this.cantidadBoletos = cantidadBoletos;
    }

    public int getprecioBoleto() {
        return precioBoleto;
    }

    public void setprecioBoleto(int precioBoleto) {
        this.precioBoleto = precioBoleto;
    }

    public String getfecha() {
        return fecha;
    }

    public void setfecha(String fecha) {
        this.fecha = fecha;
    }
    public String getDataVentaBoleto(){
        return "Cliente : "   + getnombreCliente() + '\n' +
                "Empleado : "    + getnombreEmpleado() + '\n' +
                "Pelicula :"   + getnombrePelicula() + '\n' +
                "Cantidad de Boletos  : "   +getcantidadBoletos() +'\n'+
                "Fecha :" + getfecha() + '\n' +
                "Precio de Boleto : " + getprecioBoleto();

    }
}
