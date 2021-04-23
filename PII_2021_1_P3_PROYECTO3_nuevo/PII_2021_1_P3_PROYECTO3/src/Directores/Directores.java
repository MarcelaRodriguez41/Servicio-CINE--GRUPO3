package Directores;



public class Directores {
    private long    id;
    private String  nombreDirector;
    private String    fechaNacimiento;
    private int     cantidadPeliculasDirigidas;
    private String  nacionalidad;
    private String  generosDirigidos;

    public Directores(){
    }
    public Directores(long id, String nombreDirector, String fechaNacimiento, int cantidadPeliculasDirigidas,
                      String nacionalidad, String generosDirigidos)
    {
        this.id                         = id;
        this.nombreDirector             = nombreDirector;
        this.fechaNacimiento            = fechaNacimiento;
        this.cantidadPeliculasDirigidas = cantidadPeliculasDirigidas;
        this.nacionalidad               = nacionalidad;
        this.generosDirigidos           = generosDirigidos;
    }

    public long getId() {
        return id;
    }

    public void setId(long  id) {
        this.id = id;
    }

    public String getNombreDirector() {
        return nombreDirector;
    }

    public void setNombreDirector(String nombreDirector) {
        this.nombreDirector = nombreDirector;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getCantidadPeliculasDirigidas() {
        return cantidadPeliculasDirigidas;
    }

    public void setCantidadPeliculasDirigidas(int cantidadPeliculasDirigidas) {
        this.cantidadPeliculasDirigidas = cantidadPeliculasDirigidas;
    }

    public String getGenerosDirigidos() {
        return generosDirigidos;
    }

    public void setGenerosDirigidos(String generosDirigidos) {
        this.generosDirigidos = generosDirigidos;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getDataDirector(){
        return "Director: " + getNombreDirector() + '\n' +
                "Fecha de Nacimiento: " + getFechaNacimiento() + '\n' +
                "Cantidad de Peliculas Dirigidas: " + getCantidadPeliculasDirigidas() + '\n' +
                "Nacionalidad :"+ getNacionalidad() + '\n' +
                "Generos Dirigidos : " + getGenerosDirigidos();

    }
}

