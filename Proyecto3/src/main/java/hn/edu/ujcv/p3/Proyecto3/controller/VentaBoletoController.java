package hn.edu.ujcv.p3.Proyecto3.controller;

import hn.edu.ujcv.p3.Proyecto3.entity.Actor;

import hn.edu.ujcv.p3.Proyecto3.entity.VentaBoleto;
import hn.edu.ujcv.p3.Proyecto3.exceptions.BusinessException;
import hn.edu.ujcv.p3.Proyecto3.service.VentaBoletoService;
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
@RequestMapping("/api/v1/ventaboleto")
public class VentaBoletoController {
    @Autowired
    private VentaBoletoService service;


    @PostMapping("/addVentaBoleto")
    public ResponseEntity<Any> addVentaBoleto(@RequestBody VentaBoleto ventaboleto){
        try{
            service.saveVentaBoleto(ventaboleto);
            HttpHeaders responseHeader = new HttpHeaders();
            responseHeader.set("location", Constants.URL_BASE_VENTABOLETO + ventaboleto.getId());
            return new ResponseEntity(ventaboleto,responseHeader, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addVentaBoletos")
    public ResponseEntity<Any> addVentaBoleto (@RequestBody List<VentaBoleto> ventaboletos){
        try{
            return new ResponseEntity(service.saveVentaBoletos(ventaboletos), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listaVentaBoletos")
    public ResponseEntity<List<VentaBoleto>> findAllVentaBoleto(){
        try{
            return new ResponseEntity(service.getVentaBoleto(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<VentaBoleto> findVentaBoletoById(@PathVariable long id){
        try{
            return new ResponseEntity(service.getVentaBoletoById(id), HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/nombreCliente/{nombreCliente}")
    public ResponseEntity<Actor> findventaBoletoByName (@PathVariable String nombreCliente){
        try{
            return new ResponseEntity(service. getVentaBoletosByName (nombreCliente), HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("")
    public ResponseEntity<Any> updateVentaBoleto (@RequestBody VentaBoleto ventaboleto) throws Exception {
        /*try {
            service.updateVentaBoleto(ventaboleto);
            return new ResponseEntity(ventaboleto,HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }*/
        service.updateVentaBoleto(ventaboleto);
        return new ResponseEntity(ventaboleto,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Any> deleteVentaBoleto (@PathVariable long id){
        try {
            service.deleteVentaBoleto(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
