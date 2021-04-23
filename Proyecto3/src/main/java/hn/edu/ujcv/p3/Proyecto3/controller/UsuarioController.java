package hn.edu.ujcv.p3.Proyecto3.controller;


import hn.edu.ujcv.p3.Proyecto3.entity.Usuario;
import hn.edu.ujcv.p3.Proyecto3.exceptions.BusinessException;
import hn.edu.ujcv.p3.Proyecto3.service.UsuarioService;
import hn.edu.ujcv.p3.Proyecto3.utils.Constants;
import javassist.NotFoundException;
import org.hibernate.mapping.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping("/addUsuario")
    public ResponseEntity<Any> addUsuario(@RequestBody Usuario usuario){
        try{
            service.saveUsuario(usuario);
            HttpHeaders responseHeader = new HttpHeaders();
            responseHeader.set("location", Constants.URL_BASE_USUARIO + usuario.getId());
            return new ResponseEntity(usuario,responseHeader, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/addUsuarios")
    public ResponseEntity<Any> addUsuario(@RequestBody List<Usuario> usuarios){
        try{
            return new ResponseEntity(service.saveUsuarios(usuarios), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Usuario>> findAllUsuario(){
        try{
            return new ResponseEntity(service.getUsuario(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Usuario> findUsuarioById(@PathVariable long id){
        try{
            return new ResponseEntity(service.getUsuarioById(id), HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/nombreUsuario/{nombreUsuario}")
    public ResponseEntity<Usuario> findusuarioByName (@PathVariable String nombreUsuario){
        try{
            return new ResponseEntity(service. getUsuariosByName (nombreUsuario), HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("")
    public ResponseEntity<Any> updateUsuario (@RequestBody Usuario usuario){
        try {
            service.updateUsuario(usuario);
            return new ResponseEntity(usuario,HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Any> deleteUsuario (@PathVariable long id){
        try {
            service.deleteUsuario(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
