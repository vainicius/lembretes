package com.example.lembretes.Service;

import com.example.lembretes.DTO.LembreteDTO;
import com.example.lembretes.DTO.PessoaDTO;
import com.example.lembretes.Entity.Pessoa;
import com.example.lembretes.Repository.PessoaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    private ModelMapper mapper = new ModelMapper();




    public PessoaDTO toDTO(Pessoa pessoa){
        return mapper.map(pessoa, PessoaDTO.class);
    }
    public Pessoa toEntity(PessoaDTO pessoaDTO){
        return mapper.map(pessoaDTO, Pessoa.class);
    }
    public List<PessoaDTO> findAll(){

        List<PessoaDTO> pessoasDTO = pessoaRepository.findAll().stream().map(this::toDTO).toList();

        return  pessoasDTO;
    }
    public PessoaDTO GetUmNome(String nome){
        Pessoa pessoa = this.pessoaRepository.findUmNome(nome);
        return toDTO(pessoa);
    }
    public PessoaDTO cadastrar(final PessoaDTO pessoasDTO){
        Assert.notNull(pessoasDTO.getNome(), "Por favor, informe um nome");

        return toDTO(pessoaRepository.save(toEntity(pessoasDTO)));
    }
    public PessoaDTO editar (final Long id, PessoaDTO pessoasDTO){

        Assert.notNull(pessoasDTO.getId(), "Por favor, informe um ID válido.");
        Assert.notNull(pessoasDTO.getNome(), "Por favor, informe um nome.");
        Assert.hasText(pessoasDTO.getNome(), "Há algo de errado com o campo 'nome'.");

        final Pessoa pessoaBanco = this.pessoaRepository.findById(id).orElse(null);
        Assert.notNull(pessoaBanco, "Pessoa inexistente!");
        Assert.isTrue(pessoaBanco.getId().equals(pessoasDTO.getId()), "Pessoa informada indefere da pessoa a ser atualizada.");


        return toDTO(pessoaRepository.save(toEntity(pessoasDTO)));
    }

    public  String deletar(final Long id){

        final Pessoa pessoaBanco = this.pessoaRepository.findById(id).orElse(null);
        Assert.notNull(pessoaBanco, "Pessoa inexistente!");
        this.pessoaRepository.delete(pessoaBanco);

        return "Deletado com sucesso!";
    }

    public PessoaDTO getById(Long id) {

        return toDTO(pessoaRepository.findById(id).orElse(null));
    }

}
