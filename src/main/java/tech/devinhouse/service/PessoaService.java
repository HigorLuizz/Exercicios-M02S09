package tech.devinhouse.service;

import org.springframework.stereotype.Service;
import tech.devinhouse.entity.PessoaEntity;
import tech.devinhouse.repository.PessoaRepository;

import java.util.List;

@Service
public class PessoaService {

    private PessoaRepository repository;

    public PessoaService(PessoaRepository repository){
        this.repository = repository;
    }

    public void save(PessoaEntity pessoa){
        repository.save(pessoa);
    }

    public List<PessoaEntity> buscarPessoas(){
        return repository.findAll();
    }
    public List<PessoaEntity> findByStatus(Boolean status){
        return repository.findByStatus(status);
    }
    public List<PessoaEntity> findByname(String name){
        return repository.findByName(name);
    }
    public PessoaEntity findById(Long id){
        if(repository.findById(id).isPresent()){
            return repository.findById(id).get();
        }else{
            return null;
        }

    }
    public void deleteById(Long id){
        repository.deleteById(id);
    }
    public List<PessoaEntity> findBynameOrEmail(String filter){
        return repository.buscarPorNomeOuEmail(filter);
    }
}
