package com.univer.inventory.controller;

import com.univer.inventory.Repository.ProductoRepository;
import com.univer.inventory.entity.ProductoEntity;
import com.univer.inventory.model.request.ProductoRequest;
import com.univer.inventory.model.response.ProductoResponse;
import com.univer.inventory.model.response.Notificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductosController {

    @Autowired
    private ProductoRepository repository;

    @GetMapping("all")
    public List<String> productos(){
        return Arrays.asList("tornillos, tuercas, clavos");
    }

    @GetMapping("/producto/{id}")
    public ResponseEntity prductos(@PathVariable Integer id){

        Optional<ProductoEntity> entity = this.repository.findById(id);

        if (entity.isPresent()){
            ProductoResponse response = new ProductoResponse();
            response.setName(entity.get().getNombre());
            response.setSku(entity.get().getSku());
            response.setCantidad(entity.get().getCantidad());
            this.repository.findById(id).get();
            return new ResponseEntity(response,HttpStatus.OK);
        }else {
            return new ResponseEntity("No hay informacion ligada al ID", HttpStatus.NO_CONTENT);
        }

       // return new ResponseEntity(response, Httpstatus.ok);
    }

    @CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
    @PostMapping("/save/product")
    public ResponseEntity save(@RequestBody ProductoRequest request){
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        //responseHeaders.setAccessControlAllowOrigin("http://localhost:5173");



        ProductoEntity entity = new ProductoEntity();
        entity.setNombre(request.getName());
        entity.setSku(request.getSku());
        entity.setCantidad(request.getCantidad());

        ProductoResponse response = new ProductoResponse();
        response.setName(entity.getNombre());

        Notificacion notificacion = new Notificacion();
        notificacion.setLevel("success");
        notificacion.setReason("Exitoso");
        notificacion.setMessage("El producto " + request.getName() + "se resgitro de manera correcta");
        response.setNotificacion(notificacion);



        repository.save(entity);

        return ResponseEntity.ok(response);
    }
}

