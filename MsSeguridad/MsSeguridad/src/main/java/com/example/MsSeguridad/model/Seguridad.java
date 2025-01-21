package com.example.MsSeguridad.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "security")
public class Seguridad {
    private String nombre;
    private String apellido;

    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    



}
