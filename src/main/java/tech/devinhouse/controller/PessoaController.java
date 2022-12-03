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
        service.save(pessoa);
    }
    @PutMapping
    public void update(@RequestBody PessoaEntity pessoa){
        service.save(pessoa);
    }

    @GetMapping
    public List<PessoaEntity> buscarTudo(){
        return service.buscarPessoas();
    }

//    Para fazer a busca por status true
    @GetMapping("/status-true")
    public List<PessoaEntity> buscarStatus(Boolean status){
        return service.findByStatus(true);
    }

//    Para fazer a busca por nome
//    @GetMapping
//    public List<PessoaEntity> findByName(String name){
//        return service.findByname("Higor");
//    }

//    Para fazer a busca por ID
    @GetMapping("/{id}")
    public PessoaEntity findByStatus(@PathVariable("id") Long id){
        return service.findById(id);
    }
    @DeleteMapping("/{id}")
    public void deleById(@PathVariable("id") Long id){
        service.deleteById(id);
    }
    @GetMapping("/filter")
    public List<PessoaEntity> buscarPorNomeOuEmail(@RequestParam("q") String filter){
        return service.findBynameOrEmail(filter);
    }

}
