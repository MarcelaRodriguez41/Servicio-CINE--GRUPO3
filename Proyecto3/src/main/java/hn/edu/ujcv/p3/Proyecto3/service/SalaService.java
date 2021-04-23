package hn.edu.ujcv.p3.Proyecto3.service;


import hn.edu.ujcv.p3.Proyecto3.entity.Actor;
import hn.edu.ujcv.p3.Proyecto3.entity.Sala;
import hn.edu.ujcv.p3.Proyecto3.exceptions.BusinessException;

import hn.edu.ujcv.p3.Proyecto3.repository.SalaRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaService implements ISalaService{

    @Autowired
    private SalaRepository repository;

    public Sala saveSala (Sala salas) throws BusinessException {
        try {
            return repository.save(salas);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    public List<Sala> saveSalas (List<Sala> salas) throws BusinessException {
        try {
            return repository.saveAll(salas);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    public List<Sala> getSala () throws BusinessException {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }

    }
    public Sala getSalaById (long id) throws BusinessException, NotFoundException {
        Optional<Sala> opt = null;
        try {
            opt = repository.findById( id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }

        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró la sala " + id);
        }
        return opt.get();
    }



    public Sala getSalasByName (String nombreSala) throws BusinessException, NotFoundException {
        Optional<Sala> opt = null;
        try {
            opt = repository.findBynombreSala(nombreSala);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró la sala " + nombreSala);
        }
        return opt.get();
    }
    public void deleteSala (long id) throws BusinessException, NotFoundException {
        Optional<Sala> opt = null;
        try {
            opt = repository.findById(id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró la sala" + id);
        } else {
            try {
                repository.deleteById(id);
            } catch (Exception e1) {
                throw new BusinessException(e1.getMessage());
            }
        }
    }

    public Sala updateSala (Sala salas) throws BusinessException, NotFoundException {
        Optional<Sala> opt;
        try {
            opt = repository.findById(salas.getId());
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró la sala " + salas.getId());
        } else {
            try {
                Sala existingSala = new Sala();
               existingSala.setId(salas.getId());
               existingSala.setNombreSala(salas.getNombreSala());
               existingSala.setCantidadFilas(salas.getCantidadFilas());
               existingSala.setCantidadColumnas(salas.getCantidadColumnas());
               existingSala.setEstadoDisponibilidad(salas.getEstadoDisponibilidad());
               existingSala.setCantidadAsientosPreferencial(salas.getCantidadAsientosPreferencial());

                return repository.save(existingSala);

            } catch (Exception e1) {
                throw new BusinessException(e1.getMessage());
            }
        }
    }
}
