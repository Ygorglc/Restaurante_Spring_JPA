package com.demo.DemoApiApplication.jpa;

import com.demo.DemoApiApplication.DemoApiApplication;
import com.demo.DemoApiApplication.domain.model.Restaurante;
import com.demo.DemoApiApplication.domain.repository.RestauranteRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.math.BigDecimal;

public class InclusaoRestauranteMain {

    public static void main(String[] args){

        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(DemoApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);


        RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);

        Restaurante restaurante1 = new Restaurante();
        restaurante1.setNome("Dona Jô");
        restaurante1.setTaxaFrete(BigDecimal.valueOf(12.0));

        Restaurante restaurante2 = new Restaurante();
        restaurante2.setNome("Sal e Brasa");
        restaurante2.setTaxaFrete(BigDecimal.valueOf(14.0));

        restauranteRepository.salvar(restaurante1);
        restauranteRepository.salvar(restaurante2);


        System.out.printf("%d - %s\n", restaurante1.getId(), restaurante1.getNome());
        System.out.printf("%d - %s\n", restaurante2.getId(), restaurante2.getNome());
    }

}
