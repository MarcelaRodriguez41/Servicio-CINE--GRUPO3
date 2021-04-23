package hn.edu.ujcv.p3.Proyecto3.service;

import hn.edu.ujcv.p3.Proyecto3.entity.Actor;
import hn.edu.ujcv.p3.Proyecto3.exceptions.BusinessException;
import hn.edu.ujcv.p3.Proyecto3.repository.ActorRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService implements IActorService {

    @Autowired
    private ActorRepository repository;

    public Actor saveActor (Actor actores) throws BusinessException {
        try {
            return repository.save(actores);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    public List<Actor> saveActores (List<Actor> actores) throws BusinessException {
        try {
            return repository.saveAll(actores);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    public List<Actor> getActor() throws BusinessException {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }

    }
    public Actor getActorById (long id) throws BusinessException, NotFoundException {
        Optional<Actor> opt = null;
        try {
            opt = repository.findById( id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }

        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró el actor " + id);
        }
        return opt.get();
    }
    public Actor getActoresByName (String nombreActor) throws BusinessException, NotFoundException {
        Optional<Actor> opt = null;
        try {
            opt = repository.findBynombreActor(nombreActor);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró el actor " + nombreActor);
        }
        return opt.get();
    }
    public void deleteActor (long id) throws BusinessException, NotFoundException {
        Optional<Actor> opt = null;
        try {
            opt = repository.findById(id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró el Actor " + id);
        } else {
            try {
                repository.deleteById(id);
            } catch (Exception e1) {
                throw new BusinessException(e1.getMessage());
            }
        }
    }

    public Actor updateActor(Actor actores) throws BusinessException, NotFoundException {
        Optional<Actor> opt;
        try {
            opt = repository.findById(actores.getId());
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró el Actor " + actores.getId());
        } else {
            try {
               Actor existingActor = new Actor();
                existingActor  .setId(actores.getId());
                existingActor  .setNombreActor(actores.getNombreActor());
                existingActor   .setAlias(actores.getAlias());
                existingActor .setGenerosInterpretados(actores.getGenerosInterpretados());
                existingActor .setNacionalidad(actores.getNacionalidad());
                existingActor .setSexo(actores.getSexo());
                existingActor .setFechaNacimiento(actores.getFechaNacimiento());
                existingActor .setCantidadPeliculasGrabadas(actores.getCantidadPeliculasGrabadas());
                return repository.save(existingActor);

            } catch (Exception e1) {
                throw new BusinessException(e1.getMessage());
            }
        }
    }

}
