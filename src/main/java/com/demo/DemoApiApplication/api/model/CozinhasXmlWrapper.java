package com.demo.DemoApiApplication.api.model;

import com.demo.DemoApiApplication.domain.model.Cozinha;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class CozinhasXmlWrapper {

    @NonNull
    private List<Cozinha> cozinhas;

}
