package hn.edu.ujcv.p3.Proyecto3.controller;

import hn.edu.ujcv.p3.Proyecto3.entity.VentaComida;
import hn.edu.ujcv.p3.Proyecto3.exceptions.BusinessException;

import hn.edu.ujcv.p3.Proyecto3.service.VentaComidaService;
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
@RequestMapping("/api/v1/ventacomida")
public class VentaComidaController {
    @Autowired
    private VentaComidaService service;

    @PostMapping("/addVentaComida")
    public ResponseEntity<Any> addVentaComida (@RequestBody VentaComida ventaComida) throws Exception {
        try{
            service.saveVentaComida(ventaComida);
            HttpHeaders responseHeader = new HttpHeaders();
            responseHeader.set("location", Constants.URL_BASE_VENTACOMIDA + ventaComida.getId());
            return new ResponseEntity(ventaComida,responseHeader, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        /*service.saveVentaComida(ventaComida);
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("location", Constants.URL_BASE_VENTACOMIDA + ventaComida.getId());
        return new ResponseEntity(ventaComida,responseHeader, HttpStatus.CREATED);*/
    }

    @PostMapping("/addVentaComidas")
    public ResponseEntity<Any> addVentaComida (@RequestBody List<VentaComida> ventacomidas){
        try{
            return new ResponseEntity(service.saveVentaComidas(ventacomidas), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("")
    public ResponseEntity<List<VentaComida>> findAllVentaComida(){
        try{
            return new ResponseEntity(service.getVentaComida(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<VentaComida> findVentaComidaById(@PathVariable long id){
        try{
            return new ResponseEntity(service.getVentaComidaById(id), HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/nombreCliente/{nombreCliente}")
    public ResponseEntity<VentaComida> findventacomidaByName (@PathVariable String nombreCliente){
        try{
            return new ResponseEntity(service. getVentaComidasByName (nombreCliente), HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("")
    public ResponseEntity<Any> updateVentaComida (@RequestBody VentaComida ventaComida){
        try {
            service.updateVentaComida(ventaComida);
            return new ResponseEntity(ventaComida,HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Any> deleteVentaComida (@PathVariable long id){
        try {
            service.deleteVentaComida(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
