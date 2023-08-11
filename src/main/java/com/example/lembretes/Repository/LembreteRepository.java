package com.example.lembretes.Repository;

import com.example.lembretes.Entity.Lembrete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LembreteRepository extends JpaRepository<Lembrete, Long> {
@Query("SELECT nome from")


}
