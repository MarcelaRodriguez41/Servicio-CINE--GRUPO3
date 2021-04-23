package hn.edu.ujcv.p3.Proyecto3.service;


import hn.edu.ujcv.p3.Proyecto3.entity.Sala;
import hn.edu.ujcv.p3.Proyecto3.exceptions.BusinessException;
import javassist.NotFoundException;

import java.util.List;

public interface ISalaService {

    Sala           saveSala (Sala salas)throws BusinessException;
    List<Sala>    saveSalas (List<Sala> salas) throws BusinessException; //Guardar lista
    List<Sala>    getSala() throws BusinessException;
    Sala          getSalaById(long id) throws BusinessException, NotFoundException;
    Sala          getSalasByName (String nombreSala)throws BusinessException,NotFoundException;
    void           deleteSala(long id)throws BusinessException,NotFoundException;
    Sala           updateSala (Sala salas ) throws BusinessException,NotFoundException;
}
