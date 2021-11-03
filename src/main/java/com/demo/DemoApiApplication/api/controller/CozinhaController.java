package com.demo.DemoApiApplication.api.controller;

import com.demo.DemoApiApplication.domain.model.Cozinha;
import com.demo.DemoApiApplication.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cozinha> listar(){
        return cozinhaRepository.listar();
    }

    
    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public List<Cozinha> listar2(){
        return cozinhaRepository.listar();
    }
    @GetMapping("/{cozinhaId}")
    public Cozinha buscar(@PathVariable("cozinhaId") Long id){
        return cozinhaRepository.buscar(id);
    }
}
