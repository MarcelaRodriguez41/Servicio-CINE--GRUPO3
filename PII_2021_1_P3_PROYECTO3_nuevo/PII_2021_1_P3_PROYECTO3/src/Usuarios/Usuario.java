package Usuarios;

public class Usuario {
    private long    id;
    private String nombreUsuario;
    private long   contraseña;
    private int    edad;
    private String estado;
    private String descripcion;

    public Usuario(){
    }
    public Usuario(long id, String nombreUsuario, long contraseña, int edad, String estado, String descripcion)
    {
        this.id            = id;
        this.nombreUsuario = nombreUsuario;
        this.contraseña    = contraseña;
        this.edad          = edad;
        this.estado        = estado;
        this.descripcion   = descripcion;
    }

    public long getid() {
        return id;
    }

    public void setid(long id) {
        this.id = id;
    }

    public String getnombreUsuario() {
        return nombreUsuario;
    }

    public void setnombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public long getcontraseña() {
        return contraseña;
    }

    public void setcontraseña(long contraseña) {
        this.contraseña = contraseña;
    }

    public int getedad() {
        return edad;
    }

    public void setedad(int edad) {
        this.edad = edad;
    }

    public String getestado() {
        return estado;
    }

    public void setestado(String estado) {
        this.estado = estado;
    }

    public String getdescripcion() {
        return descripcion;
    }

    public void setdescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getDataUsuario(){
        return "Nombre de Usuario: "   + getnombreUsuario() + '\n' +
                "Contraseña: "    + getcontraseña() + '\n' +
                "Edad :"   + getedad() + '\n' +
                "Estado : "   +getestado() +'\n'+
                "Descripcion: " + getdescripcion();

    }
}
