package hn.edu.ujcv.p3.Proyecto3.service;

import hn.edu.ujcv.p3.Proyecto3.entity.Actor;
import hn.edu.ujcv.p3.Proyecto3.entity.Empleado;
import hn.edu.ujcv.p3.Proyecto3.exceptions.BusinessException;
import javassist.NotFoundException;

import java.util.List;

public interface IEmpleadoService {
    Empleado        saveEmpleado (Empleado empleados)throws BusinessException;
    List<Empleado>  saveEmpleados (List<Empleado> empleados) throws BusinessException; //Guardar lista
    List<Empleado>  getEmpleado() throws BusinessException;
   Empleado         getEmpleadoById(long id) throws BusinessException, NotFoundException;
    Empleado        getEmpleadosByName (String nombreEmpleado)throws BusinessException,NotFoundException;
    void            deleteEmpleado(long id)throws BusinessException,NotFoundException;
    Empleado        updateEmpleado (Empleado empleados ) throws BusinessException,NotFoundException;
}
