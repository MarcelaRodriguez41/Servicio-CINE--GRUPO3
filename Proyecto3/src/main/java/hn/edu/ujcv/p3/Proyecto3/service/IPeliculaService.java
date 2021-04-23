package hn.edu.ujcv.p3.Proyecto3.service;


import hn.edu.ujcv.p3.Proyecto3.entity.Pelicula;
import hn.edu.ujcv.p3.Proyecto3.exceptions.BusinessException;
import javassist.NotFoundException;

import java.util.List;

public interface IPeliculaService {
   Pelicula         savePelicula (Pelicula peliculas)throws BusinessException;
    List<Pelicula>  savePeliculas (List<Pelicula> peliculas) throws BusinessException; //Guardar lista
    List<Pelicula>  getPelicula() throws BusinessException;
   Pelicula         getPeliculaById(long id) throws BusinessException, NotFoundException;
   Pelicula         getPeliculasByName (String nombrePelicula)throws BusinessException,NotFoundException;
    void            deletePelicula(long id)throws BusinessException,NotFoundException;
    Pelicula        updatePelicula (Pelicula peliculas ) throws BusinessException,NotFoundException;

}
