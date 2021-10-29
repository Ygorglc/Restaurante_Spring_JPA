package com.demo.DemoApiApplication.jpa;

import com.demo.DemoApiApplication.DemoApiApplication;
import com.demo.DemoApiApplication.domain.model.Restaurante;
import com.demo.DemoApiApplication.domain.repository.RestauranteRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

public class ConsultaRestauranteMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(DemoApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);


        RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);

//        Para retornar a lista com todos os nomes da tabela cozinha
        List<Restaurante> restaurantes = restauranteRepository.listar();

        for (Restaurante restaurante : restaurantes) {
            System.out.println(restaurante.getNome());
        }
    }
}
