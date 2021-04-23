package hn.edu.ujcv.p3.Proyecto3.service;

import hn.edu.ujcv.p3.Proyecto3.entity.Actor;
import hn.edu.ujcv.p3.Proyecto3.entity.Reservacion;
import hn.edu.ujcv.p3.Proyecto3.exceptions.BusinessException;
import javassist.NotFoundException;

import java.util.List;

public interface IReservacionService {
    Reservacion        saveReservacion (Reservacion reservaciones)throws BusinessException;
    List<Reservacion>  saveReservaciones (List<Reservacion> reservaciones) throws BusinessException; //Guardar lista
    List<Reservacion>  getReservacion() throws BusinessException;
    Reservacion        getReservacionById(long id) throws BusinessException, NotFoundException;
    Reservacion        getReservacionesByName (String nombreCliente)throws BusinessException,NotFoundException;
    void               deleteReservacion(long id)throws BusinessException,NotFoundException;
    Reservacion        updateReservacion (Reservacion reservaciones ) throws BusinessException,NotFoundException;
}
