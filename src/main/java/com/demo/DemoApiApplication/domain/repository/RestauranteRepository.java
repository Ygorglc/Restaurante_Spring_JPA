package com.demo.DemoApiApplication.domain.repository;

import com.demo.DemoApiApplication.domain.model.Restaurante;

import java.math.BigDecimal;
import java.util.List;

public interface RestauranteRepository {

    List<Restaurante> listar();
    Restaurante buscar(Long id);
    Restaurante salvar(Restaurante restaurante);
    Restaurante buscarFrete(BigDecimal taxaFrete);
    void remover(Restaurante restaurante);

}
