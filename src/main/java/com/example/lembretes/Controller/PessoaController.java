package com.example.lembretes.Controller;

import com.example.lembretes.DTO.PessoaDTO;
import com.example.lembretes.Service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/desafio/pessoas")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDTO> getById(@PathVariable("id") final long id) {
        return ResponseEntity.ok(pessoaService.getById(id));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<PessoaDTO>> getAll() {
            return ResponseEntity.ok(pessoaService.findAll());
    }
    @GetMapping("/nome")
    public ResponseEntity<PessoaDTO> getByNome(@RequestParam String nome){
            return ResponseEntity.ok(pessoaService.GetUmNome(nome));
    }
    @PostMapping("/cadastrar")
    public ResponseEntity<PessoaDTO> cadastrar(@RequestBody PessoaDTO pessoa){
            return ResponseEntity.ok(pessoaService.cadastrar(pessoa));
    }
    @PutMapping("/editar")
    public ResponseEntity<PessoaDTO> update(@RequestParam Long id, @RequestBody PessoaDTO pessoa){
            return ResponseEntity.ok(pessoaService.editar(id, pessoa));
    }
    @DeleteMapping("/deletar")
    public ResponseEntity<String> delete(@RequestParam Long id){

            pessoaService.deletar(id);
            return ResponseEntity.ok("Sucesso ao deletar.");

    }
}
