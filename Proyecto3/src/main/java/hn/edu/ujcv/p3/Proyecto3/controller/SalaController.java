package hn.edu.ujcv.p3.Proyecto3.controller;

import hn.edu.ujcv.p3.Proyecto3.entity.Actor;
import hn.edu.ujcv.p3.Proyecto3.entity.Sala;
import hn.edu.ujcv.p3.Proyecto3.exceptions.BusinessException;
import hn.edu.ujcv.p3.Proyecto3.service.ActorService;
import hn.edu.ujcv.p3.Proyecto3.service.SalaService;
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
@RequestMapping("/api/v1/sala")
public class SalaController {
    @Autowired
    private SalaService service;

    @PostMapping("/addSala")
    public ResponseEntity<Any> addASala(@RequestBody Sala sala){
        try{
            service.saveSala(sala);
            HttpHeaders responseHeader = new HttpHeaders();
            responseHeader.set("location", Constants.URL_BASE_SALA + sala.getId());
            return new ResponseEntity(sala,responseHeader, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/addSalas")
    public ResponseEntity<Any> addSala (@RequestBody List<Sala> salas){
        try{
            return new ResponseEntity(service.saveSalas(salas), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("")
    public ResponseEntity<List<Sala>> findAllSala(){
        try{
            return new ResponseEntity(service.getSala(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Sala> findSalaById(@PathVariable long id){
        try{
            return new ResponseEntity(service.getSalaById(id), HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/nombreSala/{nombreSala}")
    public ResponseEntity<Sala> findsalaByName (@PathVariable String nombreSala){
        try{
            return new ResponseEntity(service. getSalasByName (nombreSala), HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("")
    public ResponseEntity<Any> updateSala (@RequestBody Sala sala){
        try {
            service.updateSala(sala);
            return new ResponseEntity(sala,HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Any> deleteSala (@PathVariable long id){
        try {
            service.deleteSala(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
