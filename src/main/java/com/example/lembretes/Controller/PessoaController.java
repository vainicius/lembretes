package com.example.lembretes.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/desafio/pessoas")
public class PessoaController {
    @GetMapping("/nome")
    public ResponseEntity<?> getByNome(@RequestParam String nome){
        try{
            return ResponseEntity.ok(service.getByNome(nome));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
