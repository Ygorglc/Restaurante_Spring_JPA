package com.demo.DemoApiApplication.jpa;

import com.demo.DemoApiApplication.DemoApiApplication;
import com.demo.DemoApiApplication.domain.model.Cozinha;
import com.demo.DemoApiApplication.domain.repository.CozinhaRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

public class BuscaCozinhaMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(DemoApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);
        Cozinha cozinha = cozinhaRepository.buscar(1L);

        System.out.println(cozinha.getNome());

    }
}
