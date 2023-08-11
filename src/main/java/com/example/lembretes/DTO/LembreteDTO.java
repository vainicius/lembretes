package com.example.lembretes.DTO;

import com.example.lembretes.Entity.Pessoa;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LembreteDTO {

    private Long id;


    private String conteudo;


    private Pessoa pessoa;


}
