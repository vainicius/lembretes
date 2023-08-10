package com.example.lembretes.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="")
@Data
public class Lembrete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="conteudo")
    private String conteudo;

    @JoinColumn(name="pessoa")
    @ManyToOne
    private Pessoa pessoa;

}
