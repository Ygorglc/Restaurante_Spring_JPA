package com.demo.DemoApiApplication.infrastructure.repository;

import com.demo.DemoApiApplication.domain.model.FormaPagamento;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.text.html.parser.Entity;
import java.util.List;

@Component
public class FormaPagamentoRepositoryImpl extends FormaPagamento {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<FormaPagamento> listar(){
        return manager.createQuery("from FormaPagamento" , FormaPagamento.class)
                .getResultList();
    }

    @Override
    public FormaPagamento buscar (Long id){
        return manager.find(FormaPagamento.class,id);
    }

    @Transactional
    @Override
    public FormaPagamento salvar(FormaPagamento formaPagamento){
        return manager.merge(formaPagamento);
    }

    @Transactional
    @Override
    public void remover(FormaPagamento formaPagamento){
        formaPagamento = buscar(formaPagamento.getId());
        manager.remove(formaPagamento);
    }

}
