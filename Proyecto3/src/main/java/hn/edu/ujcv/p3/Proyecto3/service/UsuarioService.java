package hn.edu.ujcv.p3.Proyecto3.service;

import hn.edu.ujcv.p3.Proyecto3.entity.Actor;
import hn.edu.ujcv.p3.Proyecto3.entity.Usuario;
import hn.edu.ujcv.p3.Proyecto3.exceptions.BusinessException;

import hn.edu.ujcv.p3.Proyecto3.repository.UsuarioRepository;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    private UsuarioRepository repository;

    public Usuario saveUsuario (Usuario usuarios) throws BusinessException {
        try {
            return repository.save(usuarios);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }


    public List<Usuario> saveUsuarios (List<Usuario> usuarios) throws BusinessException {
        try {
            return repository.saveAll(usuarios);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }


    public List<Usuario> getUsuario() throws BusinessException {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    public Usuario getUsuarioById (long id) throws BusinessException, NotFoundException {
        Optional<Usuario> opt = null;
        try {
            opt = repository.findById( id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }

        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró el usuario " + id);
        }
        return opt.get();
    }

    public Usuario getUsuariosByName (String nombreUsuario) throws BusinessException, NotFoundException {
        Optional<Usuario> opt = null;
        try {
            opt = repository.findBynombreUsuario(nombreUsuario);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró el usuario " + nombreUsuario);
        }
        return opt.get();
    }

    public void deleteUsuario (long id) throws BusinessException, NotFoundException {
        Optional<Usuario> opt = null;
        try {
            opt = repository.findById(id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró el usuario" + id);
        } else {
            try {
                repository.deleteById(id);
            } catch (Exception e1) {
                throw new BusinessException(e1.getMessage());
            }
        }
    }

    public Usuario updateUsuario (Usuario usuarios) throws BusinessException, NotFoundException {
        Optional<Usuario> opt;
        try {
            opt = repository.findById(usuarios.getId());
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        if (!opt.isPresent()) {
            throw new NotFoundException("No se encontró el Usuario" + usuarios.getId());
        } else {
            try {
                Usuario existingUsuario = new Usuario();
               existingUsuario.setId(usuarios.getId());
               existingUsuario.setNombreUsuario(usuarios.getNombreUsuario());
               existingUsuario.setContraseña(usuarios.getContraseña());
               existingUsuario.setEdad(usuarios.getEdad());
               existingUsuario.setEstado(usuarios.getEstado());
               existingUsuario.setDescripcion(usuarios.getDescripcion());

                return repository.save(existingUsuario);

            } catch (Exception e1) {
                throw new BusinessException(e1.getMessage());
            }
        }
    }
}
