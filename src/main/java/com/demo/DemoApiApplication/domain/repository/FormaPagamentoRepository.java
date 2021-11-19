package com.demo.DemoApiApplication.domain.repository;

import com.demo.DemoApiApplication.domain.model.FormaPagamento;

import java.text.Normalizer;
import java.util.List;

public interface FormaPagamentoRepository {

    List<FormaPagamento> listar();
    FormaPagamento buscar(Long id);
    FormaPagamento salvar(FormaPagamento formaPagamento);
    void remover(FormaPagamento formaPagamento);

}
