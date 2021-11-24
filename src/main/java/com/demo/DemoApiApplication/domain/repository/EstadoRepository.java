package com.demo.DemoApiApplication.domain.repository;

import com.demo.DemoApiApplication.domain.model.Estado;

import java.util.List;

public interface EstadoRepository {

    List<Estado> listar();
    Estado buscar(Long id);
    Estado salvar(Estado estado);
    void remover(Long id);

}
