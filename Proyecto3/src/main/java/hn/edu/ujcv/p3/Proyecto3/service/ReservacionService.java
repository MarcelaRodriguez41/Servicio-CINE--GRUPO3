package hn.edu.ujcv.p3.Proyecto3.service;

import hn.edu.ujcv.p3.Proyecto3.entity.Actor;
import hn.edu.ujcv.p3.Proyecto3.entity.Reservacion;
import hn.edu.ujcv.p3.Proyecto3.exceptions.BusinessException;
import hn.edu.ujcv.p3.Proyecto3.repository.ActorRepository;
import hn.edu.ujcv.p3.Proyecto3.repository.ReservacionRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservacionService implements IReservacionService {
    @Autowired
    private ReservacionRepository repository;


    public Reservacion saveReservacion (Reservacion reservaciones) throws BusinessException {
        try {
            return repository.save(reservaciones);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    public List<Reservacion> saveReservaciones (List<Reservacion> reservaciones) throws BusinessException {
        try {
            return repository.saveAll(reservaciones);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    public List<Reservacion> getReservacion() throws BusinessException {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    public Reservacion getReservacionById (long id) throws BusinessException, NotFoundException {
        Optional<Reservacion> opt = null;
        try {
            opt = repository.findById( id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }

        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró la reservacion " + id);
        }
        return opt.get();
    }

    public Reservacion getReservacionesByName (String nombreCliente) throws BusinessException, NotFoundException {
        Optional<Reservacion> opt = null;
        try {
            opt = repository.findBynombreCliente(nombreCliente);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró la reservacion " + nombreCliente);
        }
        return opt.get();
    }

    public void deleteReservacion (long id) throws BusinessException, NotFoundException {
        Optional<Reservacion> opt = null;
        try {
            opt = repository.findById(id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró la reservacion " + id);
        } else {
            try {
                repository.deleteById(id);
            } catch (Exception e1) {
                throw new BusinessException(e1.getMessage());
            }
        }
    }

    public Reservacion updateReservacion(Reservacion reservaciones) throws BusinessException, NotFoundException {
        Optional<Reservacion> opt;
        try {
            opt = repository.findById(reservaciones.getId());
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró la reservacion " + reservaciones.getId());
        } else {
            try {
                Reservacion existingReservacion = new Reservacion();
                existingReservacion.setId(reservaciones.getId());
               existingReservacion.setNombreCliente(reservaciones.getNombreCliente());
               existingReservacion.setNombreEmpleado(reservaciones.getNombreEmpleado());
               existingReservacion.setNombrePelicula(reservaciones.getNombrePelicula());
               existingReservacion.setFecha(reservaciones.getFecha());
               existingReservacion.setHora(reservaciones.getHora());
                return repository.save(existingReservacion);

            } catch (Exception e1) {
                throw new BusinessException(e1.getMessage());
            }
        }
    }
}
