package tech.devinhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tech.devinhouse.entity.PessoaEntity;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {
//    @Query("select p from PessoaEntity p where p.status=true")
//    List<PessoaEntity> findByStatus();
    List<PessoaEntity> findByStatus(Boolean status);

    List<PessoaEntity> findByName(String name);
    @Query(value="select * from pessoas where name like %:filter% or email like %:filter%", nativeQuery = true)
    List<PessoaEntity> buscarPorNomeOuEmail(String filter);
}
