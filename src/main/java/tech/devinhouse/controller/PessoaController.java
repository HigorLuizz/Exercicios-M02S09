package tech.devinhouse.controller;


import org.springframework.web.bind.annotation.*;
import tech.devinhouse.entity.PessoaEntity;
import tech.devinhouse.service.PessoaService;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private PessoaService service;

    public PessoaController(PessoaService service){
        this.service = service;
    }

    @PostMapping
    public void save(@RequestBody PessoaEntity pessoa){
        service.insert(pessoa);
    }

//    @GetMapping
//    public List<PessoaEntity> buscarTudo(){
//        return service.buscarPessoas();
//    }
//    @GetMapping
//    public List<PessoaEntity> buscarStatusTrue(){
//        return service.findByStatus();
//    }
    @GetMapping
    public List<PessoaEntity> findByName(){
        return service.findByname();
    }

}
