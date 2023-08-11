package com.example.lembretes.Repository;

import com.example.lembretes.Entity.Lembrete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LembreteRepository extends JpaRepository<Lembrete, Long> {
    @Query("from Lembrete where pessoa.nome Like :nome")
    public List<Lembrete> findByNome(@Param("nome") final String nome);

}
