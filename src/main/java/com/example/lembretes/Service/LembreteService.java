package com.example.lembretes.Service;

import com.example.lembretes.DTO.LembreteDTO;
import com.example.lembretes.Entity.Lembrete;
import com.example.lembretes.Repository.LembreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class LembreteService {

    @Autowired
    private LembreteRepository lembreteRepository;
    public Lembrete ControleLembrete(LembreteDTO lembreteDTO){
        Lembrete lembrete = new Lembrete();

        lembrete.setId(lembreteDTO.getId());
        lembrete.setConteudo(lembreteDTO.getConteudo());
        lembrete.setPessoa(lembreteDTO.getPessoa());

        return lembrete;
    }
    public Lembrete cadastrar(final LembreteDTO lembreteDTO ){

        Assert.notNull(lembreteDTO.getPessoa(), "Por favor, insira uma pessoa.");

        Assert.notNull(lembreteDTO.getConteudo(), "Por favor, insira um conteúdo.");
        Assert.hasText(lembreteDTO.getConteudo(), "Conteúdo inválido.");

        Lembrete lembrete = ControleLembrete(lembreteDTO);

        return this.lembreteRepository.save(lembrete);
    }
    public Lembrete editar(Long id, final LembreteDTO lembreteDTO){

        Assert.notNull(lembreteDTO.getId(), "Por favor, informe um ID.");
        Assert.notNull(lembreteDTO.getConteudo(), "Por favor, insira um conteúdo");
        Assert.hasText(lembreteDTO.getConteudo(), "Conteúdo inválido");
        Assert.notNull(lembreteDTO.getPessoa(), "Pessoa não informada");

        Lembrete lembrete = ControleLembrete(lembreteDTO);

        return this.lembreteRepository.save(lembrete);
    }
    public String deletar(final Long id){

        final Lembrete lembreteBanco = this.lembreteRepository.findById(id).orElse(null);
        Assert.notNull(lembreteBanco, "Lembrete não localizado.");
        this.lembreteRepository.delete(lembreteBanco);

        return "Esse lembrete não está mais entre nós.";
    }

}
