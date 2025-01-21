package com.example.MsSeguridad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.MsSeguridad.model.Seguridad;
import com.example.MsSeguridad.repository.SeguridadRepositorio;

public class ServiceSeguridad {
    @Autowired
    SeguridadRepositorio securitiRepo;

    public List<Seguridad> findAll() {
        return (List<Seguridad>) securitiRepo.findAll();
    }

}
