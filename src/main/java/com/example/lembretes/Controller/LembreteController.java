package com.example.lembretes.Controller;

import com.example.lembretes.DTO.LembreteDTO;
import com.example.lembretes.Service.LembreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/desafio/lembretes")
public class LembreteController {
    @Autowired
    private LembreteService lembreteService;
    @PostMapping("/cadastrar")
    public ResponseEntity<?> post(@RequestBody LembreteDTO lembrete){
        try {
            return ResponseEntity.ok(lembreteService.cadastrar(lembrete));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping("/editar")
    public ResponseEntity<?> update(@RequestParam Long id, @RequestBody LembreteDTO lembrete){
        try{
            return ResponseEntity.ok(lembreteService.atualizar(id, lembrete));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping("/deletar")
    public ResponseEntity<?> delete(@RequestParam Long id){
        try{
            lembreteService.deletar(id);
            return ResponseEntity.ok("Sucesso ao deletar.");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
