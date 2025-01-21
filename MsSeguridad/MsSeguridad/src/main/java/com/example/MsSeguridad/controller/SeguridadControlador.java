package com.example.MsSeguridad.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.swing.text.Utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MsSeguridad.model.Seguridad;
import com.example.MsSeguridad.service.ServiceSeguridad;

@RestController
@RequestMapping("/seguridad")
public class SeguridadControlador {

    	private Logger logger = LoggerFactory.getLogger(SeguridadControlador.class);

        @Autowired
        ServiceSeguridad seguridaService;


        	

}
