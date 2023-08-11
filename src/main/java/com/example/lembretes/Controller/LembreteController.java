package com.example.lembretes.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/desafio/lembretes")
public class LembreteController {

    @PostMapping("/cadastrar")
    public ResponseEntity<?> post(@RequestBody LembreteDTO lembrete){
        try {
            return ResponseEntity.ok(service.post(lembrete));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
