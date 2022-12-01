package tech.devinhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tech.devinhouse.entity.PessoaEntity;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {
    @Query("select p from pessoas p where p.status=true")
    List<PessoaEntity> findByStatus();

    List<PessoaEntity> findByName(String name);
}
