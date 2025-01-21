package com.example.MsVenta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MsVenta.model.Venta;
import com.example.MsVenta.repository.VentaRepositorio;
@Service
public class VentaServiceIpm implements IpmVentaService {

    @Autowired
    VentaRepositorio ventarepo;

    @Override
    public List<Venta> mostrarproductos() {
       return (List<Venta>) ventarepo.findAll();
    }

    @Override
    public Venta mostrarProductosID(Integer id) {
        return ventarepo.findById(id).orElse(null);
    }

    @Override
    public Venta crearProducto(Venta venta) {
        return ventarepo.save(venta);
    }

    @Override
    public Venta modificarProducto(Venta venta) {
        return ventarepo.save(venta);
    }

    @Override
    public boolean eliminarProducto(Integer id) {
        ventarepo.existsById(id);
        if(ventarepo.existsById(id)){
            ventarepo.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

}
