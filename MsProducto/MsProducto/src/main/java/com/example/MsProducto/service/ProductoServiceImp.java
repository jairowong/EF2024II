package com.example.MsProducto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MsProducto.model.Producto;
import com.example.MsProducto.repository.ProductoRepository;

@Service
public class ProductoServiceImp implements IProductoService {

    @Autowired
    ProductoRepository produRepository;

    @Override
    public List<Producto> mostrarproductos() {
        return (List<Producto>) produRepository.findAll();
    }

    @Override
    public Producto mostrarProductosID(Integer id) {
        return produRepository.findById(id).orElse(null);
    }

    @Override
    public Producto crearProducto(Producto vacante) {
       return produRepository.save(vacante);
    }

    @Override
    public Producto modificarProducto(Producto vacante) {
       return produRepository.save(vacante);
    }

    @Override
    public boolean eliminarProducto(Integer id) {
        produRepository.existsById(id);
        if(produRepository.existsById(id)){
            produRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

}
