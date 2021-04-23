package hn.edu.ujcv.p3.Proyecto3.controller;


import hn.edu.ujcv.p3.Proyecto3.entity.Empleado;
import hn.edu.ujcv.p3.Proyecto3.exceptions.BusinessException;
import hn.edu.ujcv.p3.Proyecto3.service.EmpleadoService;
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
@RequestMapping("/api/v1/empleado")
public class EmpleadoController {

    @Autowired
    private EmpleadoService service;

    @PostMapping("/addEmpleado")
    public ResponseEntity<Any> addEmpleado (@RequestBody Empleado empleado){
        try{
            service.saveEmpleado(empleado);
            HttpHeaders responseHeader = new HttpHeaders();
            responseHeader.set("location", Constants.URL_BASE_EMPLEADO + empleado.getId());
            return new ResponseEntity(empleado,responseHeader, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/addEmpleados")
    public ResponseEntity<Any> addEmpleado (@RequestBody List<Empleado> empleados){
        try{
            return new ResponseEntity(service.saveEmpleados(empleados), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Empleado>> findAllEmpleado(){
        try{
            return new ResponseEntity(service.getEmpleado(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Empleado> findEmpleadoById(@PathVariable long id){
        try{
            return new ResponseEntity(service.getEmpleadoById(id), HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/nombreEmpleado/{nombreEmpleado}")
    public ResponseEntity<Empleado> findempleadoByName (@PathVariable String nombreEmpleado){
        try{
            return new ResponseEntity(service. getEmpleadosByName (nombreEmpleado), HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("")
    public ResponseEntity<Any> updateEmpleado (@RequestBody Empleado empleado){
        try {
            service.updateEmpleado(empleado);
            return new ResponseEntity(empleado,HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Any> deleteEmpleado (@PathVariable long id){
        try {
            service.deleteEmpleado(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
