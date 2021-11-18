package com.demo.DemoApiApplication.domain.service;

import com.demo.DemoApiApplication.domain.model.Restaurante;
import com.demo.DemoApiApplication.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroRestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    public Restaurante salvar(Restaurante restaurante){
        return restauranteRepository.salvar(restaurante);
    }




}
