package com.example.lembretes.Controller;

import com.example.lembretes.DTO.LembreteDTO;
import com.example.lembretes.Entity.Lembrete;
import com.example.lembretes.Service.LembreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/desafio/lembretes")
public class LembreteController {
    @Autowired
    private LembreteService lembreteService;

    @GetMapping("/{id}")
    public ResponseEntity<LembreteDTO> getById(@PathVariable("id") final Long id){
            return ResponseEntity.ok(lembreteService.getById(id));
    }


    @PostMapping("/cadastrar")
    public ResponseEntity<LembreteDTO> post(@RequestBody LembreteDTO lembrete){
            return ResponseEntity.ok(lembreteService.cadastrar(lembrete));
    }
    @PutMapping("/editar")
    public ResponseEntity<LembreteDTO> update(@RequestParam Long id, @RequestBody LembreteDTO lembrete){
            return ResponseEntity.ok(lembreteService.editar(id, lembrete));
    }
    @DeleteMapping("/deletar")
    public ResponseEntity<String> delete(@RequestParam Long id){

            lembreteService.deletar(id);
            return ResponseEntity.ok(String.format("Usuário com id [%s] deletado.",id));

        }
    }


