package hn.edu.ujcv.p3.Proyecto3.service;

import hn.edu.ujcv.p3.Proyecto3.entity.Actor;
import hn.edu.ujcv.p3.Proyecto3.entity.Genero;
import hn.edu.ujcv.p3.Proyecto3.exceptions.BusinessException;
import javassist.NotFoundException;

import java.util.List;

public interface IGeneroService {

    Genero        saveGenero (Genero generos)throws BusinessException;
    List<Genero>  saveGeneros (List<Genero> generos) throws BusinessException; //Guardar lista
    List<Genero>  getGenero() throws BusinessException;
    Genero        getGeneroById(long id) throws BusinessException, NotFoundException;
    Genero         getGenerosByCategoria (String categoria)throws BusinessException,NotFoundException;
    void          deleteGenero(long id)throws BusinessException,NotFoundException;
    Genero        updateGenero (Genero generos ) throws BusinessException,NotFoundException;
}
