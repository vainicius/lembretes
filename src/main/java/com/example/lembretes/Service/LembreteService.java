package com.example.lembretes.Service;

import com.example.lembretes.DTO.LembreteDTO;
import com.example.lembretes.Entity.Lembrete;
import com.example.lembretes.Repository.LembreteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;

@Service
public class LembreteService {

    @Autowired
    private LembreteRepository lembreteRepository;

    private final ModelMapper mapper = new ModelMapper();




    public LembreteDTO toLembreteDTO(Lembrete lembrete){
        return mapper.map(lembrete, LembreteDTO.class);
    }


    public Lembrete toLembrete(LembreteDTO lembreteDTO){
        return mapper.map(lembreteDTO,Lembrete.class);
    }
    public LembreteDTO cadastrar(final LembreteDTO lembreteDTO ){

        Assert.notNull(lembreteDTO.getPessoa(), "Por favor, insira uma pessoa.");

        Assert.notNull(lembreteDTO.getConteudo(), "Por favor, insira um conteúdo.");
        Assert.hasText(lembreteDTO.getConteudo(), "Conteúdo inválido.");

        return toLembreteDTO(lembreteRepository.save(toLembrete(lembreteDTO)));
    }
    public LembreteDTO editar(Long id, final LembreteDTO lembreteDTO){

        Assert.notNull(lembreteDTO.getId(), "Por favor, informe um ID.");
        Assert.notNull(lembreteDTO.getConteudo(), "Por favor, insira um conteúdo");
        Assert.hasText(lembreteDTO.getConteudo(), "Conteúdo inválido");
        Assert.notNull(lembreteDTO.getPessoa(), "Pessoa não informada");

        return toLembreteDTO(lembreteRepository.save(toLembrete(lembreteDTO)));
    }
    public void deletar(final Long id){

        final Lembrete lembreteBanco = this.lembreteRepository.findById(id).orElse(null);
        Assert.notNull(lembreteBanco, "Lembrete não localizado.");
        this.lembreteRepository.delete(lembreteBanco);
        lembreteRepository.deleteById(id);

        return;
    }

    public LembreteDTO getById(Long id) {

        return toLembreteDTO(lembreteRepository.findById(id).orElse(null));
    }
}
