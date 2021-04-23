package Actores;

import java.time.LocalDate;
import java.util.Date;

public class actores {
    private long   id;
    private String nombreActor;
    private String alias;
    private String generosInterpretados;
    private String nacionalidad;
    private String sexo;
    private String fechaNacimiento;
    private int    cantidadPeliculasGrabadas;

    public actores(){
        super();
    }
    public actores(long id, String nombreActor, String alias, String generosInterpretados, String nacionalidad, String sexo, String fechaNacimiento, int cantidadPeliculasGrabadas)
    {
        this.id                        = id;
        this.nombreActor               = nombreActor;
        this.alias                     = alias;
        this.generosInterpretados      = generosInterpretados;
        this.nacionalidad              = nacionalidad;
        this.sexo                      = sexo;
        this.fechaNacimiento           = fechaNacimiento;
        this.cantidadPeliculasGrabadas = cantidadPeliculasGrabadas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getNombreActor() {
        return nombreActor;
    }

    public void setNombreActor(String nombreActor) {
        this.nombreActor = nombreActor;
    }

    public String getfechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
       this.nacionalidad = nacionalidad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getGenerosInterpretados() {
        return generosInterpretados;
    }

    public void setGenerosInterpretados(String generosInterpretados) {
        this.generosInterpretados = generosInterpretados;
    }

    public int getCantidadPeliculasGrabadas() {
        return cantidadPeliculasGrabadas;
    }

    public void setCantidadPeliculasGrabadas(int cantidadPeliculasGrabadas) {
        this.cantidadPeliculasGrabadas = cantidadPeliculasGrabadas;
    }

    public String getDataActores(){
        return "Actor: " + getNombreActor() + '\n' +
                "Alias: " + getAlias() + '\n' +
                "Nacionalidad :"+ getNacionalidad() + '\n' +
                "Generos Interpretados : "+getGenerosInterpretados() +'\n'+
                "Sexo: "+ getSexo() +'\n'+
                "Fecha de Nacimiento: " + getfechaNacimiento() + '\n' +
                "Cantidad de Peliculas Grabadas: " + getCantidadPeliculasGrabadas();
    }
}

