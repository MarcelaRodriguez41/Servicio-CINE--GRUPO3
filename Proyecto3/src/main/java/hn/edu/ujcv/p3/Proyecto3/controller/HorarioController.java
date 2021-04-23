package hn.edu.ujcv.p3.Proyecto3.controller;

import hn.edu.ujcv.p3.Proyecto3.entity.Actor;
import hn.edu.ujcv.p3.Proyecto3.entity.Horario;
import hn.edu.ujcv.p3.Proyecto3.exceptions.BusinessException;
import hn.edu.ujcv.p3.Proyecto3.service.ActorService;
import hn.edu.ujcv.p3.Proyecto3.service.HorarioService;
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
@RequestMapping("/api/v1/horario")
public class HorarioController {
    @Autowired
    private HorarioService service;

    @PostMapping("/addHorario")
    public ResponseEntity<Any> addHorario (@RequestBody Horario horario){
        try{
            service.saveHorario(horario);
            HttpHeaders responseHeader = new HttpHeaders();
            responseHeader.set("location", Constants.URL_BASE_HORARIO + horario.getId());
            return new ResponseEntity(horario,responseHeader, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/addHorarios")
    public ResponseEntity<Any> addHorario (@RequestBody List<Horario> horarios){
        try{
            return new ResponseEntity(service.saveHorarios(horarios), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Horario>> findAllHorario(){
        try{
            return new ResponseEntity(service.getHorario(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Horario> findHorarioById(@PathVariable long id){
        try{
            return new ResponseEntity(service.getHorarioById(id), HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/nombrePelicula/{nombrePelicula}")
    public ResponseEntity<Horario> findhorarioByName (@PathVariable String nombrePelicula){
        try{
            return new ResponseEntity(service. getHorariosByName (nombrePelicula), HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("")
    public ResponseEntity<Any> updateHorario (@RequestBody Horario horario){
        try {
            service.updateHorario(horario);
            return new ResponseEntity(horario,HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Any> deleteHorario (@PathVariable long id){
        try {
            service.deleteHorario( id);
            return new ResponseEntity(HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
