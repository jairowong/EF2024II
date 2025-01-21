package com.example.MsProducto.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.MsProducto.model.Producto;
import com.example.MsProducto.routes.rutas;
import com.example.MsProducto.service.ProductoServiceImp;

@Controller
@RequestMapping(rutas.producto)
public class ProductoController {

        private static final Logger logger= LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    ProductoServiceImp serviceProducto;

    @GetMapping(rutas.mostrarProducto)
    public ResponseEntity<List<Producto>> buscarMatricula(){
        try{
            logger.info("productos encontrados");
            List<Producto> produc= serviceProducto.mostrarproductos();
            if(produc.isEmpty()){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(produc);
        }catch(Exception e){
            logger.error("lista de Productos no encontrado");
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/mostrar/{id}")
    public ResponseEntity<?> buscarporId(@PathVariable Integer id){
        try {
            Producto produc= serviceProducto.mostrarProductosID(id);
            if (produc !=null) {
                logger.info("se encontro el id del producto");
                return ResponseEntity.ok(produc);
                
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no se encontro el id del producto");
            }
        } catch (Exception e) {
            logger.error(null, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("no existe el id");
        }
    }

      @PostMapping(rutas.crearProducto)
    public ResponseEntity<?> crearDetalle(@RequestBody Producto producto){
        try {
            if (producto.getNombreProducto()==null || producto.getPrecio()==0 || producto.getStock()==0) {
                logger.error("no se creo el detalle de la matricula");
                return ResponseEntity.status(HttpStatus.CONFLICT).body("detalle no creado");
            }
                logger.info("creando el detalle de la Matricula");
                return ResponseEntity.status(HttpStatus.CREATED).body(serviceProducto.crearProducto(producto));
        } catch (Exception e) {
            logger.error("error al crear detalle");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("no se creo el detalle");
        }
    }

     @PutMapping("/modificar/{id}")
    public ResponseEntity<String> modificarDetalle(@PathVariable Integer id, @RequestBody Producto producto) {
        if (producto.getNombreProducto()==null || producto.getPrecio()==0 || producto.getStock()==0) {
            logger.error("Datos incompletos para modificar el detalle.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Datos incompletos.");
        }
        try {
            producto.setIdProducto(id); // Asegurarse de que el ID sea correcto
            Producto actualizado = serviceProducto.modificarProducto(producto);
            if (actualizado == null) {
                logger.error("No se encontró el detalle con ID: " + id);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el detalle.");
            }
            logger.info("Detalle modificado correctamente.");
            return ResponseEntity.status(HttpStatus.OK).body("Detalle modificado con éxito.");
        } catch (Exception e) {
            logger.error("Error al modificar el detalle: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor.");
        }
    }

        @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id){
        try {
            boolean elininar=serviceProducto.eliminarProducto(id);
            if (elininar) {
                logger.info("producto eliminado");
                return ResponseEntity.ok("se elimino el detalle");
            }else{
                logger.warn("no existe el id del producto para elininar"+id);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("id no encontrado");
            }
        } catch (Exception e) {
           logger.error("error al eliminar producto");
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ocurrio un error");
        }
    }
}
