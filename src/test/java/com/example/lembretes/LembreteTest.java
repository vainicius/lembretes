/*
package com.example.lembretes;

import com.example.lembretes.Controller.LembreteController;
import com.example.lembretes.Entity.Lembrete;
import com.example.lembretes.Entity.Pessoa;
import com.example.lembretes.Repository.LembreteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class LembreteTest {

    @MockBean
    LembreteRepository repository;
    @Autowired
    LembreteController controller;




    @BeforeEach
    void injectData(){
        Lembrete lembrete = new Lembrete(1L, "Vini");
        Optional<Lembrete> lembrete = Optional.of(new Lembrete(1L, "Conteúdo",pessoa));
    }

    @Test
    void testControllerPessoa(){
        var lembretecontroller = controller.getById(1L);
        Long id = lembretecontroller.getBody().getId().longValue();
        System.out.println(id);
        Assertions.assertEquals(1L, id, 0);


    }

}
*/