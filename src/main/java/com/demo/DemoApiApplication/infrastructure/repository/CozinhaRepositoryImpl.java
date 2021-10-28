package com.demo.DemoApiApplication.infrastructure.repository;

import com.demo.DemoApiApplication.domain.model.Cozinha;
import com.demo.DemoApiApplication.domain.repository.CozinhaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CozinhaRepositoryImpl implements CozinhaRepository {
    @Override
    public List<Cozinha> listar() {
        return null;
    }

    @Override
    public Cozinha buscar(Long id) {
        return null;
    }

    @Override
    public Cozinha salvar(Cozinha cozinha) {
        return null;
    }

    @Override
    public void remover(Cozinha cozinha) {

    }
}
