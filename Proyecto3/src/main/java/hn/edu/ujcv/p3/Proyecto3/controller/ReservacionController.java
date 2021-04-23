package hn.edu.ujcv.p3.Proyecto3.controller;


import hn.edu.ujcv.p3.Proyecto3.entity.Reservacion;
import hn.edu.ujcv.p3.Proyecto3.exceptions.BusinessException;
import hn.edu.ujcv.p3.Proyecto3.service.ReservacionService;
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
@RequestMapping("/api/v1/reservacion")
public class ReservacionController {
    @Autowired
    private ReservacionService service;

    @PostMapping("/addReservacion")
    public ResponseEntity<Any> addReservacion (@RequestBody Reservacion reservacion){
        try{
            service.saveReservacion(reservacion);
            HttpHeaders responseHeader = new HttpHeaders();
            responseHeader.set("location", Constants.URL_BASE_RESERVACION + reservacion.getId());
            return new ResponseEntity(reservacion,responseHeader, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/addReservaciones")
    public ResponseEntity<Any> addReservaciones (@RequestBody List<Reservacion> reservaciones){
        try{
            return new ResponseEntity(service.saveReservaciones(reservaciones), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Reservacion>> findAllReservacion(){
        try{
            return new ResponseEntity(service.getReservacion(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Reservacion> findReservacionById(@PathVariable long id){
        try{
            return new ResponseEntity(service.getReservacionById(id), HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/nombreCliente/{nombreCliente}")
    public ResponseEntity<Reservacion> findreservacionByName (@PathVariable String nombreCliente){
        try{
            return new ResponseEntity(service. getReservacionesByName (nombreCliente), HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("")
    public ResponseEntity<Any> updateReservacion (@RequestBody Reservacion reservacion){
        try {
            service.updateReservacion(reservacion);
            return new ResponseEntity(reservacion,HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Any> deleteReservacion (@PathVariable long id){
        try {
            service.deleteReservacion(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
