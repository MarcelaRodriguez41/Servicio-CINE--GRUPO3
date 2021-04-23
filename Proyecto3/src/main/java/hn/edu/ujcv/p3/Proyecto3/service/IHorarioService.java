package hn.edu.ujcv.p3.Proyecto3.service;

import hn.edu.ujcv.p3.Proyecto3.entity.Actor;
import hn.edu.ujcv.p3.Proyecto3.entity.Horario;
import hn.edu.ujcv.p3.Proyecto3.exceptions.BusinessException;
import javassist.NotFoundException;

import java.util.List;

public interface IHorarioService {

    Horario        saveHorario (Horario horarios)throws BusinessException;
    List<Horario>  saveHorarios (List<Horario> horarios) throws BusinessException; //Guardar lista
    List<Horario>  getHorario() throws BusinessException;
    Horario        getHorarioById(long id) throws BusinessException, NotFoundException;
   Horario         getHorariosByName (String nombrePelicula)throws BusinessException,NotFoundException;
    void           deleteHorario(long id)throws BusinessException,NotFoundException;
    Horario        updateHorario (Horario horarios ) throws BusinessException,NotFoundException;
}
