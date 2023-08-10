package com.example.lembretes.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="")
@Data
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="nome")
    private String nome;

}
