package hn.edu.ujcv.p3.Proyecto3.service;

import hn.edu.ujcv.p3.Proyecto3.entity.Usuario;
import hn.edu.ujcv.p3.Proyecto3.exceptions.BusinessException;
import javassist.NotFoundException;

import java.util.List;

public interface IUsuarioService {
    
    Usuario         saveUsuario (Usuario Usuarios)throws BusinessException;
    List<Usuario>   saveUsuarios (List<Usuario> Usuarios) throws BusinessException; //Guardar lista
    List<Usuario>   getUsuario() throws BusinessException;
    Usuario         getUsuarioById(long id) throws BusinessException, NotFoundException;
    Usuario         getUsuariosByName (String nombreUsuario)throws BusinessException,NotFoundException;
    void           deleteUsuario(long id)throws BusinessException,NotFoundException;
    Usuario        updateUsuario (Usuario Usuarios ) throws BusinessException,NotFoundException;
}
