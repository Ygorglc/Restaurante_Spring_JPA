package com.demo.DemoApiApplication.infrastructure.repository;

import com.demo.DemoApiApplication.domain.model.Permissao;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class PermissaoRepositoryImpl extends Permissao {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Permissao> listar(){
        return manager.createQuery("from Permissao", Permissao.class).getResultList();
    }

    @Override
    public Permissao buscar(Long id){
        return manager.find(Permissao.class,id);
    }

    @Transactional
    @Override
    public Permissao salvar(Permissao permissao){
        return manager.merge(permissao);
    }

    @Transactional
    @Override
    public void remover(Permissao permissao){
        manager.remove(permissao);
    }

}
