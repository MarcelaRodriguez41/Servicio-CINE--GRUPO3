package hn.edu.ujcv.p3.Proyecto3.service;

import hn.edu.ujcv.p3.Proyecto3.entity.Actor;
import hn.edu.ujcv.p3.Proyecto3.entity.VentaBoleto;
import hn.edu.ujcv.p3.Proyecto3.exceptions.BusinessException;
import hn.edu.ujcv.p3.Proyecto3.repository.ActorRepository;
import hn.edu.ujcv.p3.Proyecto3.repository.VentaBoletoRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaBoletoService implements IVentaBoletoService {
    @Autowired
    private VentaBoletoRepository repository;

    public VentaBoleto saveVentaBoleto (VentaBoleto ventaboletos) throws BusinessException {
        try {
            return repository.save(ventaboletos);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    public List<VentaBoleto> saveVentaBoletos (List<VentaBoleto> ventaboletos) throws BusinessException {
        try {
            return repository.saveAll(ventaboletos);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    public List<VentaBoleto> getVentaBoleto() throws BusinessException {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }

    }

    public VentaBoleto getVentaBoletoById (long id) throws BusinessException, NotFoundException {
        Optional<VentaBoleto> opt = null;
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

    public VentaBoleto getVentaBoletosByName (String nombreCliente) throws BusinessException, NotFoundException {
        Optional<VentaBoleto> opt = null;
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

    public void deleteVentaBoleto (long id) throws BusinessException, NotFoundException {
        Optional<VentaBoleto> opt = null;
        try {
            opt = repository.findById(id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró la Venta " + id);
        } else {
            try {
                repository.deleteById(id);
            } catch (Exception e1) {
                throw new BusinessException(e1.getMessage());
            }
        }
    }

    public VentaBoleto updateVentaBoleto (VentaBoleto ventaboletos) throws BusinessException, NotFoundException {
        Optional<VentaBoleto> opt;
        try {
            opt = repository.findById(ventaboletos.getId());
        } catch (Exception e) {
            throw new BusinessException("Error al optener el id " + e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró la venta" + ventaboletos.getId());
        } else {
            try {
                VentaBoleto existingBoleto = new VentaBoleto();
                existingBoleto.setId(ventaboletos.getId());
                existingBoleto.setNombreCliente(ventaboletos.getNombreCliente());
                existingBoleto.setNombreEmpleado(ventaboletos.getNombreEmpleado());
                existingBoleto.setNombrePelicula(ventaboletos.getNombrePelicula());
                existingBoleto.setCantidadBoletos(ventaboletos.getCantidadBoletos());
                existingBoleto.setPrecioBoleto(ventaboletos.getPrecioBoleto());
                existingBoleto.setFecha(ventaboletos.getFecha());
                return repository.save(existingBoleto);
            } catch (Exception e1) {
                throw new BusinessException("Error al procesar consulta: " + e1.getMessage());
            }
        }
    }
}
