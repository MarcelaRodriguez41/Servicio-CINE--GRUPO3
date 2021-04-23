package hn.edu.ujcv.p3.Proyecto3.service;

import hn.edu.ujcv.p3.Proyecto3.entity.Actor;
import hn.edu.ujcv.p3.Proyecto3.entity.VentaComida;
import hn.edu.ujcv.p3.Proyecto3.exceptions.BusinessException;
import hn.edu.ujcv.p3.Proyecto3.repository.ActorRepository;
import hn.edu.ujcv.p3.Proyecto3.repository.VentaComidaRepository;
import javassist.NotFoundException;
import jdk.nashorn.internal.ir.VarNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaComidaService implements IVentaComidaService {

    @Autowired
    private VentaComidaRepository repository;


    public VentaComida saveVentaComida (VentaComida ventacomidas) throws BusinessException {
        try {
            return repository.save(ventacomidas);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    public List<VentaComida> saveVentaComidas (List<VentaComida> ventacomidas) throws BusinessException {
        try {
            return repository.saveAll(ventacomidas);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    public List<VentaComida> getVentaComida() throws BusinessException {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }

    }

    public VentaComida getVentaComidaById (long id) throws BusinessException, NotFoundException {
        Optional<VentaComida> opt = null;
        try {
            opt = repository.findById( id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }

        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró la venta " + id);
        }
        return opt.get();
    }

    public VentaComida getVentaComidasByName (String nombreCliente) throws BusinessException, NotFoundException {
        Optional<VentaComida> opt = null;
        try {
            opt = repository.findBynombreCliente(nombreCliente);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró la venta " + nombreCliente);
        }
        return opt.get();
    }

    public void deleteVentaComida (long id) throws BusinessException, NotFoundException {
        Optional<VentaComida> opt = null;
        try {
            opt = repository.findById(id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró la venta " + id);
        } else {
            try {
                repository.deleteById(id);
            } catch (Exception e1) {
                throw new BusinessException(e1.getMessage());
            }
        }
    }

    public VentaComida updateVentaComida (VentaComida ventacomidas) throws BusinessException, NotFoundException {
        Optional<VentaComida> opt;
        try {
            opt = repository.findById(ventacomidas.getId());
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró la venta" + ventacomidas.getId());
        } else {
            try {
                VentaComida existingComida = new VentaComida();
               existingComida.setId(ventacomidas.getId());
               existingComida.setNombreCliente(ventacomidas.getNombreCliente());
               existingComida.setNombreEmpleado(ventacomidas.getNombreEmpleado());
               existingComida.setNombreProducto(ventacomidas.getNombreProducto());
               existingComida.setPrecioProducto(ventacomidas.getPrecioProducto());
               existingComida.setCantidadProducto(ventacomidas.getCantidadProducto());
                return repository.save(existingComida);

            } catch (Exception e1) {
                throw new BusinessException(e1.getMessage());
            }
        }
    }
}
