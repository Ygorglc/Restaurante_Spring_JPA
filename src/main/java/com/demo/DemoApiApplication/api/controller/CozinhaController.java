package com.demo.DemoApiApplication.api.controller;

import com.demo.DemoApiApplication.api.model.CozinhasXmlWrapper;
import com.demo.DemoApiApplication.domain.model.Cozinha;
import com.demo.DemoApiApplication.domain.repository.CozinhaRepository;
import com.demo.DemoApiApplication.domain.service.CadastroCozinhaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Autowired
    private CadastroCozinhaService cadastroCozinha;

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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cozinha adicionar(@RequestBody Cozinha cozinha){
        return cadastroCozinha.salvar(cozinha);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cozinha> atualizar(@PathVariable Long id,
                                             @RequestBody Cozinha cozinha){
        Cozinha cozinhaAtual = cozinhaRepository.buscar(id);

        if(cozinhaAtual != null){
            BeanUtils.copyProperties(cozinha,cozinhaAtual, "id");

            cozinhaRepository.salvar(cozinhaAtual);
            return ResponseEntity.ok(cozinhaAtual);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cozinha> remover(@PathVariable Long id){
        Cozinha cozinha = cozinhaRepository.buscar(id);
        try {
            if (cozinha != null) {
                cozinhaRepository.remover(cozinha);
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.noContent().build();
        } catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build() ;
        }
    }
}
