package hn.edu.ujcv.p3.Proyecto3.controller;

import hn.edu.ujcv.p3.Proyecto3.entity.Actor;
import hn.edu.ujcv.p3.Proyecto3.entity.Sucursal;
import hn.edu.ujcv.p3.Proyecto3.exceptions.BusinessException;
import hn.edu.ujcv.p3.Proyecto3.service.ActorService;
import hn.edu.ujcv.p3.Proyecto3.service.SucursalService;
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
@RequestMapping("/api/v1/sucursal")
public class SucursalController {
    @Autowired
    private SucursalService service;

    @PostMapping("/addSucursal")
    public ResponseEntity<Any> addSucursal(@RequestBody Sucursal sucursal){
        try{
            service.saveSucursal(sucursal);
            HttpHeaders responseHeader = new HttpHeaders();
            responseHeader.set("location", Constants.URL_BASE_SUCURSAL + sucursal.getId());
            return new ResponseEntity(sucursal,responseHeader, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addSucursales")
    public ResponseEntity<Any> addSucursal (@RequestBody List<Sucursal> sucursales){
        try{
            return new ResponseEntity(service.saveSucursales(sucursales), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Sucursal>> findAllSucursal(){
        try{
            return new ResponseEntity(service.getSucursal(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Sucursal> findSucursalById(@PathVariable long id){
        try{
            return new ResponseEntity(service.getSucursalById(id), HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/direccion/{direccion}")
    public ResponseEntity<Sucursal> findsucursalByDireccion (@PathVariable String direccion){
        try{
            return new ResponseEntity(service. getSucursalesByDireccion(direccion), HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("")
    public ResponseEntity<Any> updateSucursal (@RequestBody Sucursal sucursal){
        try {
            service.updateSucursal(sucursal);
            return new ResponseEntity(sucursal,HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Any> deleteSucursal (@PathVariable long id){
        try {
            service.deleteSucursal(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
