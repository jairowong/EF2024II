package com.example.MsVenta.service;

import java.util.List;

import com.example.MsVenta.model.Venta;

public interface IpmVentaService {

    public List<Venta> mostrarproductos();
    public Venta mostrarProductosID(Integer id);
    public Venta crearProducto(Venta venta);
    public Venta modificarProducto(Venta venta);
    public boolean eliminarProducto(Integer id);

}
