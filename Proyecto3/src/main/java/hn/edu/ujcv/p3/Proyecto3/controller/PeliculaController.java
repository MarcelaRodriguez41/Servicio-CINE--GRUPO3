package hn.edu.ujcv.p3.Proyecto3.controller;

import hn.edu.ujcv.p3.Proyecto3.entity.Actor;
import hn.edu.ujcv.p3.Proyecto3.entity.Pelicula;
import hn.edu.ujcv.p3.Proyecto3.exceptions.BusinessException;
import hn.edu.ujcv.p3.Proyecto3.service.ActorService;
import hn.edu.ujcv.p3.Proyecto3.service.PeliculaService;
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
@RequestMapping("/api/v1/pelicula")
public class PeliculaController {
    @Autowired
    private PeliculaService service;

    @PostMapping("/addPelicula")
    public ResponseEntity<Any> addPelicula(@RequestBody Pelicula pelicula){
        try{
            service.savePelicula(pelicula);
            HttpHeaders responseHeader = new HttpHeaders();
            responseHeader.set("location", Constants.URL_BASE_PELICULA + pelicula.getId());
            return new ResponseEntity(pelicula,responseHeader, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addPeliculas")
    public ResponseEntity<Any> addPelicula(@RequestBody List<Pelicula> peliculas){
        try{
            return new ResponseEntity(service.savePeliculas(peliculas), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Pelicula>> findAllPelicula(){
        try{
            return new ResponseEntity(service.getPelicula(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Pelicula> findPeliculaById(@PathVariable long id){
        try{
            return new ResponseEntity(service.getPeliculaById(id), HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/nombrePelicula/{nombrePelicula}")
    public ResponseEntity<Pelicula> findpeliculaByName (@PathVariable String nombrePelicula){
        try{
            return new ResponseEntity(service. getPeliculasByName (nombrePelicula), HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("")
    public ResponseEntity<Any> updatePelicula (@RequestBody Pelicula pelicula){
        try {
            service.updatePelicula(pelicula);
            return new ResponseEntity(pelicula,HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Any> deletePelicula (@PathVariable long id){
        try {
            service.deletePelicula(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
