package com.example.lembretes.Service;

import com.example.lembretes.DTO.PessoaDTO;
import com.example.lembretes.Entity.Pessoa;
import com.example.lembretes.Repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaDTO ControlePessoasDTO(Pessoa pessoa){
        PessoaDTO pessoaDTO = new PessoaDTO();

        pessoaDTO.setNome(pessoa.getNome());
        pessoaDTO.setId(pessoa.getId());

        return pessoaDTO;
    }
    public Pessoa ControlePessoa(PessoaDTO pessoaDTO){
        Pessoa pessoa = new Pessoa();

        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setId(pessoaDTO.getId());

        return  pessoa;
    }
    public List<PessoaDTO> findAll(){

        List<PessoaDTO> pessoasDTO = pessoaRepository.findAll().stream().map(this::ControlePessoasDTO).toList();

        return  pessoasDTO;
    }
    public PessoaDTO GetUmNome(String nome){
        Pessoa pessoa = this.pessoaRepository.findUmNome(nome);

        PessoaDTO pessoaDTO = ControlePessoasDTO(pessoa);

        return pessoaDTO;
    }
    public Pessoa cadastrar(final PessoaDTO pessoasDTO){
        Assert.notNull(pessoasDTO.getNome(), "Por favor, informe um nome");

        Pessoa pessoa = new Pessoa();

        return this.pessoaRepository.save(pessoa);
    }
    public Pessoa editar (final Long id, PessoaDTO pessoasDTO){

        Assert.notNull(pessoasDTO.getId(), "Por favor, informe um ID válido.");
        Assert.notNull(pessoasDTO.getNome(), "Por favor, informe um nome.");
        Assert.hasText(pessoasDTO.getNome(), "Há algo de errado com o campo 'nome'.");

        final Pessoa pessoaBanco = this.pessoaRepository.findById(id).orElse(null);
        Assert.notNull(pessoaBanco, "Pessoa inexistente!");
        Assert.isTrue(pessoaBanco.getId().equals(pessoasDTO.getId()), "Pessoa informada indefere da pessoa a ser atualizada.");


        Pessoa pessoa = ControlePessoa(pessoasDTO);
        return this.pessoaRepository.save(pessoa);
    }

    public  String deletar(final Long id){

        final Pessoa pessoaBanco = this.pessoaRepository.findById(id).orElse(null);
        Assert.notNull(pessoaBanco, "Pessoa inexistente!");
        this.pessoaRepository.delete(pessoaBanco);

        return "Deletado com sucesso!";
    }

}
