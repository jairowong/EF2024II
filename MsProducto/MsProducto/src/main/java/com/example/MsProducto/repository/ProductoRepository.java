package com.example.MsProducto.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.MsProducto.model.Producto;

public interface ProductoRepository extends CrudRepository<Producto,Integer> {

}
