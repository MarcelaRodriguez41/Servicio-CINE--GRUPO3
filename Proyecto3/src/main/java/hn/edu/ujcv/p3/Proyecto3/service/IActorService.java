package hn.edu.ujcv.p3.Proyecto3.service;

import hn.edu.ujcv.p3.Proyecto3.entity.Actor;
import hn.edu.ujcv.p3.Proyecto3.exceptions.BusinessException;
import  javassist.NotFoundException;


import java.util.List;

public interface IActorService {

    Actor saveActor (Actor actores)throws BusinessException;
    List<Actor>  saveActores (List<Actor> actores) throws BusinessException; //Guardar lista
    List<Actor>  getActor() throws BusinessException;
    Actor      getActorById(long id) throws BusinessException,NotFoundException;
   Actor         getActoresByName (String nombreActor)throws BusinessException,NotFoundException;
    void           deleteActor(long id)throws BusinessException,NotFoundException;
    Actor updateActor (Actor actores ) throws BusinessException,NotFoundException;

}
