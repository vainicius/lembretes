package com.example.lembretes.Repository;

import com.example.lembretes.Entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa,Long> {

    @Query("from Pessoa where nome =: nome")
    public List<Pessoa> getByNome(@Param("nome") final String nome);

    @Query("from Pessoa where nome Like :nome")
    public Pessoa findUmNome(@Param("nome")final String nome);


}
