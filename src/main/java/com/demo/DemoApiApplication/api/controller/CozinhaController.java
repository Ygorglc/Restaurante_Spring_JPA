package com.demo.DemoApiApplication.api.controller;

import com.demo.DemoApiApplication.api.model.CozinhasXmlWrapper;
import com.demo.DemoApiApplication.domain.model.Cozinha;
import com.demo.DemoApiApplication.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public CozinhasXmlWrapper listarXml(){
        return new CozinhasXmlWrapper(cozinhaRepository.listar());
    }
    @GetMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha> buscar(@PathVariable("cozinhaId") Long id){
        Cozinha cozinha = cozinhaRepository.buscar(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.LOCATION, "http://localhost:8080/cozinhas");

        //return ResponseEntity.status(HttpStatus.OK).body(cozinha);
        //return ResponseEntity.ok(cozinha);
        if (cozinha != null){
            return ResponseEntity.ok(cozinha);
        }
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).build();
    }
}
