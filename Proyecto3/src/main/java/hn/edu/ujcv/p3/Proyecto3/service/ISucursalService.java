package hn.edu.ujcv.p3.Proyecto3.service;

import hn.edu.ujcv.p3.Proyecto3.entity.Actor;
import hn.edu.ujcv.p3.Proyecto3.entity.Sucursal;
import hn.edu.ujcv.p3.Proyecto3.exceptions.BusinessException;
import javassist.NotFoundException;

import java.util.List;

public interface ISucursalService {
    Sucursal         saveSucursal (Sucursal sucursales)throws BusinessException;
    List<Sucursal>   saveSucursales (List<Sucursal> sucursales) throws BusinessException; //Guardar lista
    List<Sucursal>   getSucursal() throws BusinessException;
    Sucursal         getSucursalById(long id) throws BusinessException, NotFoundException;
   Sucursal          getSucursalesByDireccion (String direccion)throws BusinessException,NotFoundException;
    void             deleteSucursal(long id)throws BusinessException,NotFoundException;
    Sucursal         updateSucursal (Sucursal sucursales ) throws BusinessException,NotFoundException;
}
