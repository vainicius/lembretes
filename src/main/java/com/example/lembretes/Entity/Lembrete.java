package com.example.lembretes.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
