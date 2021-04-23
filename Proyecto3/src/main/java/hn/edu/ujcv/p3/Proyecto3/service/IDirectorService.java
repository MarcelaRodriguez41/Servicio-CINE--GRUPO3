package hn.edu.ujcv.p3.Proyecto3.service;

import hn.edu.ujcv.p3.Proyecto3.entity.Director;
import hn.edu.ujcv.p3.Proyecto3.exceptions.BusinessException;
import javassist.NotFoundException;

import java.util.List;

public interface IDirectorService {
    Director        saveDirector (Director director)throws BusinessException;
    List<Director>  saveDirectores (List<Director> directores) throws BusinessException; //Guardar lista
    List<Director>  getDirector() throws BusinessException;
    Director        getDirectorById(long id) throws BusinessException, NotFoundException;
    Director        getDirectoresByName (String nombreDirector)throws BusinessException,NotFoundException;
    void            deleteDirector(long id)throws BusinessException,NotFoundException;
    Director        updateDirector (Director directores ) throws BusinessException,NotFoundException;

}
