package hn.edu.ujcv.p3.Proyecto3.service;

import hn.edu.ujcv.p3.Proyecto3.entity.Actor;
import hn.edu.ujcv.p3.Proyecto3.entity.Empleado;
import hn.edu.ujcv.p3.Proyecto3.exceptions.BusinessException;
import hn.edu.ujcv.p3.Proyecto3.repository.ActorRepository;
import hn.edu.ujcv.p3.Proyecto3.repository.EmpleadoRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService implements IEmpleadoService{

    @Autowired
    private EmpleadoRepository repository;

    public Empleado saveEmpleado (Empleado empleados) throws BusinessException {
        try {
            return repository.save(empleados);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    public List<Empleado> saveEmpleados (List<Empleado> empleados) throws BusinessException {
        try {
            return repository.saveAll(empleados);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    public List<Empleado> getEmpleado() throws BusinessException {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }

    }

    public Empleado getEmpleadoById (long id) throws BusinessException, NotFoundException {
        Optional<Empleado> opt = null;
        try {
            opt = repository.findById( id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }

        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró el empleado" + id);
        }
        return opt.get();
    }

    public Empleado getEmpleadosByName (String nombreEmpleado) throws BusinessException, NotFoundException {
        Optional<Empleado> opt = null;
        try {
            opt = repository.findBynombreEmpleado(nombreEmpleado);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró el empleado" + nombreEmpleado);
        }
        return opt.get();
    }

    public void deleteEmpleado (long id) throws BusinessException, NotFoundException {
        Optional<Empleado> opt = null;
        try {
            opt = repository.findById(id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró el empleado " + id);
        } else {
            try {
                repository.deleteById(id);
            } catch (Exception e1) {
                throw new BusinessException(e1.getMessage());
            }
        }
    }

    public Empleado updateEmpleado (Empleado empleados) throws BusinessException, NotFoundException {
        Optional<Empleado> opt;
        try {
            opt = repository.findById(empleados.getId());
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró el empleado " + empleados.getId());
        } else {
            try {
                Empleado existingEmpleado = new Empleado();
                existingEmpleado.setId(empleados.getId());
               existingEmpleado.setCodigo(empleados.getCodigo());
               existingEmpleado.setCelular(empleados.getCelular());
               existingEmpleado.setCorreo(empleados.getCorreo());
               existingEmpleado.setNombreEmpleado(empleados.getNombreEmpleado());
               existingEmpleado.setDireccion(empleados.getDireccion());
                return repository.save(existingEmpleado);

            } catch (Exception e1) {
                throw new BusinessException(e1.getMessage());
            }
        }
    }
}
