package hn.edu.ujcv.p3.Proyecto3.controller;
import hn.edu.ujcv.p3.Proyecto3.entity.Genero;
import hn.edu.ujcv.p3.Proyecto3.exceptions.BusinessException;
import hn.edu.ujcv.p3.Proyecto3.service.GeneroService;
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
@RequestMapping("/api/v1/genero")
public class GeneroController {
    @Autowired
    private GeneroService service;

    @PostMapping("/addGenero")
    public ResponseEntity<Any> addGenero (@RequestBody Genero genero){
        try{
            service.saveGenero(genero);
            HttpHeaders responseHeader = new HttpHeaders();
            responseHeader.set("location", Constants.URL_BASE_GENERO + genero.getId());
            return new ResponseEntity(genero,responseHeader, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/addGeneros")
    public ResponseEntity<Any> addGenero (@RequestBody List<Genero> generos){
        try{
            return new ResponseEntity(service.saveGeneros(generos), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("")
    public ResponseEntity<List<Genero>> findAllGenero(){
        try{
            return new ResponseEntity(service.getGenero(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Genero> findGeneroById(@PathVariable long id){
        try{
            return new ResponseEntity(service.getGeneroById(id), HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/categoria/{categora}")
    public ResponseEntity<Genero> findgeneroByCategoria (@PathVariable String categoria){
        try{
            return new ResponseEntity(service. getGenerosByCategoria (categoria), HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("")
    public ResponseEntity<Any> updateGenero (@RequestBody Genero genero){
        try {
            service.updateGenero(genero);
            return new ResponseEntity(genero,HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Any> deleteGenero (@PathVariable long id){
        try {
            service.deleteGenero(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
