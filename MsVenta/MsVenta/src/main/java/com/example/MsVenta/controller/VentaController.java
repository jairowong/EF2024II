package com.example.MsVenta.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.MsVenta.model.Venta;
import com.example.MsVenta.service.VentaServiceIpm;

@Controller
@RequestMapping("/venta")
public class VentaController {
    private static final Logger logger= LoggerFactory.getLogger(VentaController.class);
    @Autowired
    VentaServiceIpm ventaservice;

        @GetMapping("/mostrar")
    public ResponseEntity<List<Venta>> buscarMatricula(){
        try{
            logger.info("ventas realizadas");
            List<Venta> ventas= ventaservice.mostrarproductos();
            if(ventas.isEmpty()){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(ventas);
        }catch(Exception e){
            logger.error("listado de ventas");
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

      @PostMapping("/crear")
    public ResponseEntity<?> crearDetalle(@RequestBody Venta venta){
        try {
            if (venta.getCantidad()==0 || venta.getPrecio()==0 || venta.getProducto()==null) {
                logger.error("no se creo el detalle de la matricula");
                return ResponseEntity.status(HttpStatus.CONFLICT).body("detalle no creado");
            }
                logger.info("creando el detalle de la Matricula");
                return ResponseEntity.status(HttpStatus.CREATED).body(ventaservice.crearProducto(venta));
        } catch (Exception e) {
            logger.error("error al crear detalle");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("no se creo el detalle");
        }
    }
    
}
