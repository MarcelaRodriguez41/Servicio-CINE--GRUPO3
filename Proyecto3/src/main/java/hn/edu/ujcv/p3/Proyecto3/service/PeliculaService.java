package hn.edu.ujcv.p3.Proyecto3.service;

import hn.edu.ujcv.p3.Proyecto3.entity.Actor;
import hn.edu.ujcv.p3.Proyecto3.entity.Pelicula;
import hn.edu.ujcv.p3.Proyecto3.exceptions.BusinessException;
import hn.edu.ujcv.p3.Proyecto3.repository.ActorRepository;
import hn.edu.ujcv.p3.Proyecto3.repository.PeliculaRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService implements IPeliculaService{

    @Autowired
    private PeliculaRepository repository;

    public Pelicula savePelicula (Pelicula peliculas) throws BusinessException {
        try {
            return repository.save(peliculas);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    public List<Pelicula> savePeliculas (List<Pelicula> peliculas) throws BusinessException {
        try {
            return repository.saveAll(peliculas);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    public List<Pelicula> getPelicula() throws BusinessException {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }

    }

    public Pelicula getPeliculaById (long id) throws BusinessException, NotFoundException {
        Optional<Pelicula> opt = null;
        try {
            opt = repository.findById( id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }

        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró la Pelicula " + id);
        }
        return opt.get();
    }

    public Pelicula getPeliculasByName (String nombrePelicula) throws BusinessException, NotFoundException {
        Optional<Pelicula> opt = null;
        try {
            opt = repository.findBynombrePelicula(nombrePelicula);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró la Pelicula " + nombrePelicula);
        }
        return opt.get();
    }

    public void deletePelicula (long id) throws BusinessException, NotFoundException {
        Optional<Pelicula> opt = null;
        try {
            opt = repository.findById(id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró la Pelicula " + id);
        } else {
            try {
                repository.deleteById(id);
            } catch (Exception e1) {
                throw new BusinessException(e1.getMessage());
            }
        }
    }

    public Pelicula updatePelicula(Pelicula peliculas) throws BusinessException, NotFoundException {
        Optional<Pelicula> opt;
        try {
            opt = repository.findById(peliculas.getId());
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró la Pelicula " + peliculas.getId());
        } else {
            try {
                Pelicula existingPelicula = new Pelicula();
                existingPelicula.setId(peliculas.getId());
                existingPelicula.setNombrePelicula(peliculas.getNombrePelicula());
                existingPelicula.setSinopsis(peliculas.getSinopsis());
                existingPelicula.setGenero(peliculas.getGenero());
                existingPelicula.setNacionalidad(peliculas.getNacionalidad());
                existingPelicula.setDuracion(peliculas.getDuracion());
                existingPelicula.setDirector(peliculas.getDirector());
                return repository.save(existingPelicula);

            } catch (Exception e1) {
                throw new BusinessException(e1.getMessage());
            }
        }
    }
}
