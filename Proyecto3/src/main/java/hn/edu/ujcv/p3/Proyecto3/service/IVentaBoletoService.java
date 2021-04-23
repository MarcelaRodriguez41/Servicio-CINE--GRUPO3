package hn.edu.ujcv.p3.Proyecto3.service;

import hn.edu.ujcv.p3.Proyecto3.entity.VentaBoleto;
import hn.edu.ujcv.p3.Proyecto3.exceptions.BusinessException;
import javassist.NotFoundException;

import java.util.List;

public interface IVentaBoletoService {
    VentaBoleto        saveVentaBoleto (VentaBoleto ventaboletos)throws BusinessException;
    List<VentaBoleto>  saveVentaBoletos (List<VentaBoleto> ventaboletos) throws BusinessException; //Guardar lista
    List<VentaBoleto>  getVentaBoleto() throws BusinessException;
    VentaBoleto         getVentaBoletoById(long id) throws BusinessException, NotFoundException;
    VentaBoleto         getVentaBoletosByName (String nombreCliente)throws BusinessException,NotFoundException;
    void                deleteVentaBoleto(long id)throws BusinessException,NotFoundException;
    VentaBoleto    updateVentaBoleto (VentaBoleto ventaboletos ) throws BusinessException,NotFoundException;
}
