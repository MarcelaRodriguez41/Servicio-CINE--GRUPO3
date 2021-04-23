package hn.edu.ujcv.p3.Proyecto3.service;

import hn.edu.ujcv.p3.Proyecto3.entity.Actor;
import hn.edu.ujcv.p3.Proyecto3.entity.Director;
import hn.edu.ujcv.p3.Proyecto3.exceptions.BusinessException;
import hn.edu.ujcv.p3.Proyecto3.repository.DirectorRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorService implements IDirectorService {
    @Autowired
    private DirectorRepository repository;

    public Director saveDirector (Director directores) throws BusinessException {
        try {
            return repository.save(directores);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    public List<Director> saveDirectores (List<Director> directores) throws BusinessException {
        try {
            return repository.saveAll(directores);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    public List<Director> getDirector() throws BusinessException {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }

    }

    public Director getDirectorById (long id) throws BusinessException, NotFoundException {
        Optional<Director> opt = null;
        try {
            opt = repository.findById(id);

        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }

        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró el director " + id);
        }
        return opt.get();
    }

    public Director getDirectoresByName (String nombreDirector) throws BusinessException, NotFoundException {
        Optional<Director> opt = null;
        try {
            opt = repository.findBynombreDirector(nombreDirector);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró el director " + nombreDirector);
        }
        return opt.get();
    }

    public void deleteDirector (long id) throws BusinessException, NotFoundException {
        Optional<Director> opt = null;
        try {
            opt = repository.findById(id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró el Director " + id);
        } else {
            try {
                repository.deleteById(id);
            } catch (Exception e1) {
                throw new BusinessException(e1.getMessage());
            }
        }
    }

    public Director updateDirector (Director directores) throws BusinessException, NotFoundException {
        Optional<Director> opt;
        try {
            opt = repository.findById(directores.getId());
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró el director " + directores.getId());
        } else {
            try {
                Director existingDirector = new Director();
                existingDirector.setId(directores.getId());
                existingDirector.setNombreDirector(directores.getNombreDirector());
                existingDirector.setFechaNacimiento(directores.getFechaNacimiento());
                existingDirector.setCantidadPeliculasDirigidas(directores.getCantidadPeliculasDirigidas());
                existingDirector.setNacionalidad(directores.getNacionalidad());
                existingDirector.setGenerosDirigidos(directores.getGenerosDirigidos());
                return repository.save(existingDirector);

            } catch (Exception e1) {
                throw new BusinessException(e1.getMessage());
            }
        }
    }
}
