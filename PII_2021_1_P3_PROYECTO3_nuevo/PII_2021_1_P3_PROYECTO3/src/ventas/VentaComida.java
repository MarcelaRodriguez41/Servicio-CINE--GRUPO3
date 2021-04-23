package ventas;

public class VentaComida {
    private long  id;
    private String nombreCliente;
    private String nombreEmpleado;
    private String nombreProducto;
    private int    precioProducto;
    private int    cantidadProducto;


    public VentaComida() {
    }
    public VentaComida(long id, String nombreCliente, String nombreEmpleado, String nombreProducto, int precioProducto, int cantidadProducto)
    {
        this.id               = id;
        this.nombreCliente    = nombreCliente;
        this.nombreEmpleado   = nombreEmpleado;
        this.nombreProducto   = nombreProducto;
        this.precioProducto   = precioProducto;
        this.cantidadProducto = cantidadProducto;
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

    public void setnombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getnombreProducto() {
        return nombreProducto;
    }

    public void setnombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getprecioProducto() {
        return precioProducto;
    }

    public void setprecioProducto(int precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getcantidadProducto() {
        return cantidadProducto;
    }

    public void setcantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }
    public String getDataVentaComida(){
        return "Nombre de Cliente: "   + getnombreCliente() + '\n' +
                "Nombre de Empleado : "    + getnombreEmpleado() + '\n' +
                "Nombre de Producto  :"   + getnombreProducto() + '\n' +
                "Cantidad de Producto : "   +getcantidadProducto() +'\n'+
                "Precio de Producto: " + getprecioProducto();

    }
}