package com.example.MsSeguridad.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.MsSeguridad.model.Seguridad;

public interface SeguridadRepositorio extends MongoRepository<Seguridad, Integer>  {
    
}
