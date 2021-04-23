package hn.edu.ujcv.p3.Proyecto3.service;

import hn.edu.ujcv.p3.Proyecto3.entity.VentaComida;
import hn.edu.ujcv.p3.Proyecto3.exceptions.BusinessException;
import javassist.NotFoundException;

import java.util.List;

public interface IVentaComidaService {
    VentaComida       saveVentaComida (VentaComida ventacomidas)throws BusinessException;
    List<VentaComida> saveVentaComidas (List<VentaComida> ventacomidas) throws BusinessException; //Guardar lista
    List<VentaComida>  getVentaComida() throws BusinessException;
    VentaComida      getVentaComidaById(long id) throws BusinessException, NotFoundException;
    VentaComida         getVentaComidasByName (String nombreCliente)throws BusinessException,NotFoundException;
    void           deleteVentaComida(long id)throws BusinessException,NotFoundException;
    VentaComida updateVentaComida (VentaComida ventacomidas ) throws BusinessException,NotFoundException;
}
