package horario;

public class Horarios {


    private long id;
    private String horaInicio;
    private String horaFinal;
    private String nombrePelicula;
    private String fecha;

    public Horarios() {
    }

    public Horarios(long id, String horaInicio, String horaFinal, String nombrePelicula, String fecha) {
        this.id = id;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.nombrePelicula = nombrePelicula;
        this.fecha = fecha;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDataHorario() {
        return "Hora de Inicio: " + getHoraInicio() + '\n' +
                "Hora Final: " + getHoraFinal() + '\n' +
                "Nombre Pelicula :" + getNombrePelicula() + '\n' +
                "Fecha : " + getFecha();

    }


}
