package establecimiento;

public class Salas {
    private long   id;
    private String nombreSala;
    private int    cantidadFilas;
    private int    cantidadColumnas;
    private int    cantidadAsientosPreferencial;
    private String estadoDisponibilidad;

    public Salas() {
    }
    public Salas(long id, String nombreSala, int cantidadFilas, int cantidadColumnas, int cantidadAsientosPreferencial, String estadoDisponibilidad)
    {
        this.id                           = id;
        this.nombreSala                   = nombreSala;
        this.cantidadFilas                = cantidadFilas;
        this.cantidadColumnas             = cantidadColumnas;
        this.cantidadAsientosPreferencial = cantidadAsientosPreferencial;
        this.estadoDisponibilidad         = estadoDisponibilidad;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
       this.id = id;
    }

    public String getNombreSala() {
        return nombreSala;
    }

    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
    }

    public int getCantidadFilas() {
        return cantidadFilas;
    }

    public void setCantidadFilas(int cantidadFilas) {
        this.cantidadFilas = cantidadFilas;
    }

    public int getCantidadColumnas() {
        return cantidadColumnas;
    }

    public void setCantidadColumnas(int cantidadColumnas) {
        this.cantidadColumnas = cantidadColumnas;
    }

    public int getCantidadAsientosPreferencial() {
        return cantidadAsientosPreferencial;
    }

    public void setCantidadAsientosPreferencial(int cantidadAsientosPreferencial) {
        this.cantidadAsientosPreferencial = cantidadAsientosPreferencial;
    }

    public String getEstadoDisponibilidad() {
        return estadoDisponibilidad;
    }

    public void setEstadoDisponibilidad(String estadoDisponibilidad) {
        this.estadoDisponibilidad = estadoDisponibilidad;
    }
    public String getDataSala(){
        return "Nombre de Sala : "   + getNombreSala() + '\n' +
                "Cantidad de Filas : "    + getCantidadFilas() + '\n' +
                "Cantidad de Columnas  :"   + getCantidadColumnas() + '\n' +
                "Estado : " + getEstadoDisponibilidad();

    }
}