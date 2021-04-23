package peliculas;

public class Pelicula {
    private long id;
    private String nombrePelicula;
    private String sinopsis;
    private String genero;
    private String nacionalidad;
    private String duracion;
    private String director;

    public Pelicula(){}
    public Pelicula(long id, String nombrePelicula, String sinopsis, String genero,
                    String nacionalidad, String duracion, String director)
    {
        this.id           = id;
        this.nombrePelicula       = nombrePelicula;
        this.sinopsis     = sinopsis;
        this.genero       = genero;
        this.nacionalidad = nacionalidad;
        this.duracion     = duracion;
        this.director     = director;
    }

    public long getId ()
    {
        return id;
    }
    public void setId (long id)
    {
        this.id = id;
    }

    public String getNombrePelicula ()
    {
        return nombrePelicula;
    }
    public void setNombrePelicula (String nombrePelicula)
    {
        this.nombrePelicula= nombrePelicula;
    }

    public String getSinopsis ()
    {
        return sinopsis;
    }
    public void setSinopsis (String sinopsis)
    {
        this.sinopsis = this.sinopsis;
    }

    public String getGenero ()
    {
        return genero;
    }
    public void setGenero (String genero)
    {
        this.genero = genero;
    }


    public String getNacionalidad ()
    {
        return nacionalidad;
    }
    public void setNacionalidad (String nacionalidad)
    {
        this.nacionalidad = nacionalidad;
    }

    public String getDuracion ()
    {
        return duracion;
    }
    public void setDuracion (String duracion)
    {
        this.duracion = duracion;
    }

    public String getDirector ()
    {
        return director;
    }
    public void setDirector (String director)
    {
        this.director = director;
    }

    public String getDataPeliculas(){
        return "Pelicula: " + getNombrePelicula() + '\n' +
                "Sinopsis: " + getSinopsis() + '\n' +
                "Nacionalidad :"+ getNacionalidad() + '\n' +
                "Genero : "+getGenero() +'\n'+
                "Duracion: "+ getDuracion() +'\n'+
                "Director: " + getDirector();
    }
}
