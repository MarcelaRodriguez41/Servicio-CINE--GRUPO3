package hn.edu.ujcv.p3.Proyecto3.service;


import hn.edu.ujcv.p3.Proyecto3.entity.Actor;
import hn.edu.ujcv.p3.Proyecto3.entity.Genero;
import hn.edu.ujcv.p3.Proyecto3.exceptions.BusinessException;
import hn.edu.ujcv.p3.Proyecto3.repository.GeneroRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneroService implements IGeneroService {
    @Autowired
    private GeneroRepository repository;


    public Genero saveGenero (Genero generos) throws BusinessException {
        try {
            return repository.save(generos);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }
    public List<Genero> saveGeneros (List<Genero> generos) throws BusinessException {
        try {
            return repository.saveAll(generos);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }
    public List<Genero> getGenero() throws BusinessException {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }

    }

    public Genero getGeneroById (long id) throws BusinessException, NotFoundException {
        Optional<Genero> opt = null;
        try {
            opt = repository.findById( id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }

        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró el genero " + id);
        }
        return opt.get();
    }

    public Genero getGenerosByCategoria (String categoria) throws BusinessException, NotFoundException {
        Optional<Genero> opt = null;
        try {
            opt = repository.findBycategoria(categoria);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró el genero" + categoria);
        }
        return opt.get();
    }

    public void deleteGenero (long id) throws BusinessException, NotFoundException {
        Optional<Genero> opt = null;
        try {
            opt = repository.findById(id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró el Genero " + id);
        } else {
            try {
                repository.deleteById(id);
            } catch (Exception e1) {
                throw new BusinessException(e1.getMessage());
            }
        }
    }

    public Genero updateGenero (Genero generos) throws BusinessException, NotFoundException {
        Optional<Genero> opt;
        try {
            opt = repository.findById(generos.getId());
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró el Genero " + generos.getId());
        } else {
            try {
                Genero existingGenero = new Genero();
                existingGenero.setId(generos.getId());
                existingGenero.setCategoria(generos.getCategoria());

                return repository.save(existingGenero);

            } catch (Exception e1) {
                throw new BusinessException(e1.getMessage());
            }
        }
    }

}
