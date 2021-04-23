package hn.edu.ujcv.p3.Proyecto3.service;

import hn.edu.ujcv.p3.Proyecto3.entity.Actor;
import hn.edu.ujcv.p3.Proyecto3.entity.Sucursal;
import hn.edu.ujcv.p3.Proyecto3.exceptions.BusinessException;
import hn.edu.ujcv.p3.Proyecto3.repository.ActorRepository;
import hn.edu.ujcv.p3.Proyecto3.repository.SucursalRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SucursalService implements ISucursalService {
    @Autowired
    private SucursalRepository repository;


    public Sucursal saveSucursal (Sucursal sucursales) throws BusinessException {
        try {
            return repository.save(sucursales);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }


    public List<Sucursal> saveSucursales (List<Sucursal> sucursales) throws BusinessException {
        try {
            return repository.saveAll(sucursales);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    public List<Sucursal> getSucursal() throws BusinessException {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    public Sucursal getSucursalById (long id) throws BusinessException, NotFoundException {
        Optional<Sucursal> opt = null;
        try {
            opt = repository.findById( id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }

        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró la sucursal " + id);
        }
        return opt.get();
    }

    public Sucursal getSucursalesByDireccion (String direccion) throws BusinessException, NotFoundException {
        Optional<Sucursal> opt = null;
        try {
            opt = repository.findBydireccion(direccion);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró la direccion " + direccion);
        }
        return opt.get();
    }

    public void deleteSucursal (long id) throws BusinessException, NotFoundException {
        Optional<Sucursal> opt = null;
        try {
            opt = repository.findById(id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró la Sucursal " + id);
        } else {
            try {
                repository.deleteById(id);
            } catch (Exception e1) {
                throw new BusinessException(e1.getMessage());
            }
        }
    }

    public Sucursal updateSucursal (Sucursal sucursales) throws BusinessException, NotFoundException {
        Optional<Sucursal> opt;
        try {
            opt = repository.findById(sucursales.getId());
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró la sucursal " + sucursales.getId());
        } else {
            try {
                Sucursal existingSucursal = new Sucursal();
                existingSucursal.setId(sucursales.getId());
                existingSucursal.setTelefono(sucursales.getTelefono());
                existingSucursal.setCorreo(sucursales.getCorreo());
                existingSucursal.setDireccion(sucursales.getDireccion());
                existingSucursal.setCantidadEmpleados(sucursales.getCantidadEmpleados());
                existingSucursal.setCantidadSalas(sucursales.getCantidadSalas());

                return repository.save(existingSucursal);

            } catch (Exception e1) {
                throw new BusinessException(e1.getMessage());
            }
        }
    }

}
