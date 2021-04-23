package Generos;

public class Generos {
    private long   id;
    private String categoria;

    public Generos (){}
    public Generos (long id, String categoria)
    {
        this.id        = id;
        this.categoria = categoria;
    }
    public long getId ()
    {
        return id;
    }
    public void setId (long id)
    {
        this.id = id;
    }

    public String getCategoria ()
    {
        return categoria;
    }
    public void setCategoria (String categoria)
    {
        this.categoria = categoria;
    }

    public String getDataGenero(){
        return "Categoria: " + getCategoria() ;


    }
}