package com.demo.DemoApiApplication.infrastructure.repository;

import com.demo.DemoApiApplication.domain.model.Cidade;
import com.demo.DemoApiApplication.domain.repository.CidadeRespository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class CidadeRepositoryImpl implements CidadeRespository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Cidade> listar(){
        return manager.createQuery("from Cidade", Cidade.class)
                .getResultList();
    }

    @Override
    public Cidade buscar(Long id){
        return manager.find(Cidade.class, id);
    }

    @Transactional
    @Override
    public Cidade salvar(Cidade cidade){
        return manager.merge(cidade);
    }

    @Transactional
    @Override
    public void remover(Cidade cidade){
        cidade = buscar(cidade.getId());
        manager.remove(cidade);
    }


}