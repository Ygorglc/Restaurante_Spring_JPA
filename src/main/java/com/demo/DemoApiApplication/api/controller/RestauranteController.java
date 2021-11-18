package com.demo.DemoApiApplication.api.controller;

import com.demo.DemoApiApplication.domain.exception.EntidadeNaoEncontradaException;
import com.demo.DemoApiApplication.domain.model.Restaurante;
import com.demo.DemoApiApplication.domain.repository.RestauranteRepository;
import com.demo.DemoApiApplication.domain.service.CadastroRestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CadastroRestauranteService cadastroRestaurante;

    @GetMapping
    public List<Restaurante> listar(){
        return restauranteRepository.listar();
    }


    public ResponseEntity<Restaurante> buscar(@PathVariable Long restauranteId){
        Restaurante restaurante = restauranteRepository.buscar(restauranteId);

        if (restaurante != null){
            return ResponseEntity.ok(restaurante);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity <?> adicionar (@RequestBody Restaurante restaurante){
         try {
             restaurante = cadastroRestaurante.salvar(restaurante);

             return ResponseEntity.status(HttpStatus.CREATED)
                     .body(restaurante);
         }catch (EntidadeNaoEncontradaException e){
             return ResponseEntity.badRequest().body(e.getMessage());
         }
    }
}