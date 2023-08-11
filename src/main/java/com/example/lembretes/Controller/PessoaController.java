package com.example.lembretes.Controller;

import com.example.lembretes.DTO.PessoaDTO;
import com.example.lembretes.Service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/desafio/pessoas")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;
    @GetMapping("/todos")
    public ResponseEntity<?> getAll() {
        try{
            return ResponseEntity.ok(pessoaService.findAll());
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/nome")
    public ResponseEntity<?> getByNome(@RequestParam String nome){
        try{
            return ResponseEntity.ok(pessoaService.GetUmNome(nome));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody PessoaDTO pessoa){
        try {
            return ResponseEntity.ok(pessoaService.cadastrar(pessoa));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping("/editar")
    public ResponseEntity<?> update(@RequestParam Long id, @RequestBody PessoaDTO pessoa){
        try{
            return ResponseEntity.ok(pessoaService.editar(id, pessoa));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping("/deletar")
    public ResponseEntity<?> delete(@RequestParam Long id){
        try{
            pessoaService.deletar(id);
            return ResponseEntity.ok("Sucesso ao deletar.");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
