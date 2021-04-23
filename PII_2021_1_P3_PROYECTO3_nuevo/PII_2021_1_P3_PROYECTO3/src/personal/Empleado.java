package personal;

public class Empleado {
    private long   id;
    private int    codigo;
    private long   celular;
    private String  correo;
    private String nombreEmpleado;
    private String direccion;


    public Empleado(){}
    public Empleado(int codigo, long id, String nombreEmpleado, String correo, long celular,String direccion)
    {   this.codigo       = codigo;
        this.id           = id;
        this.nombreEmpleado      = nombreEmpleado;
        this.celular      = celular;
        this.correo       = correo;
        this.direccion    = direccion;
    }
    public int getCodigo ()
    {
        return codigo;
    }
    public void setCodigo (int codigo)
    {
        this.codigo = codigo;
    }

    public long getId ()
    {
        return id;
    }
    public void setId (long Id)
    {
        this.id = id;
    }


    public String getNombreEmpleado ()
    {
        return nombreEmpleado;
    }
    public void setNombreEmpleado (String nombreEmpleado)
    {
        this.nombreEmpleado = nombreEmpleado;
    }

   public String getCorreo ()
   {
       return correo;
   }
   public void setCorreo (String correo)
   {
       this.correo = correo;
   }

    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDataEmpleado(){
        return "Empleado: "   + getNombreEmpleado() + '\n' +
                "Codigo: "    + getCodigo() + '\n' +
                "Celular :"   + getCelular() + '\n' +
                "Correo : "   +getCorreo() +'\n'+
                "Direccion: " + getDireccion();

    }
}
