package com.demo.DemoApiApplication.api.controller;

import com.demo.DemoApiApplication.domain.exception.EntidadeEmUsoException;
import com.demo.DemoApiApplication.domain.exception.EntidadeNaoEncontradaException;
import com.demo.DemoApiApplication.domain.model.Estado;
import com.demo.DemoApiApplication.domain.repository.EstadoRepository;
import com.demo.DemoApiApplication.domain.service.CadastroEstadoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CadastroEstadoService cadastroEstado;

    @GetMapping
    public List<Estado> listar(){
        return estadoRepository.listar();
    }

    @GetMapping("/{estadoId}")
    public ResponseEntity<Estado> buscar(@PathVariable Long estadoId) {
        Estado estado = estadoRepository.buscar(estadoId);

        if(estado !=null){
            return ResponseEntity.ok(estado);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Estado adicionar(@RequestBody Estado estado){
        return cadastroEstado.salvar(estado);
    }

    @PostMapping("/{estadoId}")
    public ResponseEntity<Estado> atualizar(@PathVariable Long estadoId,
                                            @RequestBody Estado estado){
        Estado estadoAtual = estadoRepository.buscar(estadoId);

        if(estadoAtual != null){
            BeanUtils.copyProperties(estado,estadoAtual, "id");

            estadoAtual = cadastroEstado.salvar(estadoAtual);
            return ResponseEntity.ok(estadoAtual);
        }

        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{estadoId}")
    public ResponseEntity<?> remover(@PathVariable Long estadoId){
        try{
            cadastroEstado.excluir(estadoId);
            return ResponseEntity.notFound().build();
        } catch (EntidadeNaoEncontradaException e){
            return ResponseEntity.notFound().build();
        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }

    }

}
