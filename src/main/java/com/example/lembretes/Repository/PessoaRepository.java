package com.example.lembretes.Repository;

import com.example.lembretes.Entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa,Long> {



}
