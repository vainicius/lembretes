package com.example.lembretes;

import com.example.lembretes.Controller.PessoaController;
import com.example.lembretes.Entity.Pessoa;
import com.example.lembretes.Repository.PessoaRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest //TODO: Perguntar pro Prof. se essa annotation substitui @RunWith(SpringRunner.class)
public class PessoaTest {
    @MockBean
    PessoaRepository repository;
    @Autowired
    private PessoaController controller;

    @BeforeEach
    void injectData(){
        Optional<Pessoa> pessoa = Optional.of(new Pessoa(1L, "Vini"));
        Long id = 1L;
        Mockito.when(repository.findById(id)).thenReturn(pessoa);
    }

    @Test
    void testControllerPessoa(){
        var pessoacontroller = controller.ge
    }


}
