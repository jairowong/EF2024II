package com.example.MsProducto.service;

import java.util.List;
import com.example.MsProducto.model.Producto;

public interface IProductoService {

    public List<Producto> mostrarproductos();
    public Producto mostrarProductosID(Integer id);
    public Producto crearProducto(Producto vacante);
    public Producto modificarProducto(Producto vacam);
    public boolean eliminarProducto(Integer id);

}
