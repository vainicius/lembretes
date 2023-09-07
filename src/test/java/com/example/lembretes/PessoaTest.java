package com.example.lembretes;

import com.example.lembretes.Controller.PessoaController;
import com.example.lembretes.DTO.PessoaDTO;
import com.example.lembretes.Entity.Pessoa;
import com.example.lembretes.Repository.PessoaRepository;
import com.example.lembretes.Service.PessoaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;
import static org.mockito.Mockito.when;


@SpringBootTest //TODO: Perguntar pro Prof. se essa annotation substitui @RunWith(SpringRunner.class)
public class PessoaTest {
    @MockBean
    PessoaRepository repository;
    @Autowired
    private PessoaController controller = new PessoaController();
    @Autowired
    private PessoaService service = new PessoaService();

    @BeforeEach
    void injectDataGetId(){
        Optional<Pessoa> pessoa = Optional.of(new Pessoa(1L, "Vini"));
        Long id = 1L;
        when(repository.findById(id)).thenReturn(pessoa);
    }
    @BeforeEach
    void InjectDataPost(){
        PessoaDTO pessoaNome = new PessoaDTO(1L, "Vini");

        when(service.cadastrar(pessoaNome)).thenReturn(pessoaNome);

    }

    @Test
    void testGetIdPessoa(){

        var pessoacontroller = controller.getById(1L);
        Long id = pessoacontroller.getBody().getId().longValue();
        System.out.println(id);
        Assertions.assertEquals(1L, id, 0);
    }

    @Test
    void testPostPessoa() {
    PessoaDTO pessoaNome = new PessoaDTO(1L,"Vini");
    ResponseEntity<PessoaDTO> responseEntity = controller.cadastrar(pessoaNome);
    System.out.println(pessoaNome);
    Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    PessoaDTO pessoaCadastrada = responseEntity.getBody();

    System.out.println(pessoaCadastrada.getNome());
    Assertions.assertEquals(1L,pessoaNome.getId());
}


}



