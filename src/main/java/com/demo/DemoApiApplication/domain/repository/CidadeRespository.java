package com.demo.DemoApiApplication.domain.repository;

import com.demo.DemoApiApplication.domain.model.Cidade;

import java.util.List;

public interface CidadeRespository {

    List<Cidade> listar();
    Cidade buscar(Long id);
    Cidade salvar(Cidade cidade);
    void remover(Cidade cidade);

}
