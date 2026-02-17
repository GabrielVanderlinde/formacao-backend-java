package com.example.produtosapi.controller;

import com.example.produtosapi.model.Produto;
import com.example.produtosapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        System.out.println("Produto Recebido" + produto);

        var id = UUID.randomUUID().toString();
        produto.setId(id);

        produtoRepository.save(produto);
        return produto;
    }

    @GetMapping("/{id}")
    public Produto findById(@PathVariable("id") String id) /*PathVariable para receber o ID via Url*/ {
        return produtoRepository.findById(id).orElse(null);
    }

    @GetMapping("/read-all")
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") String id) /*PathVariable para receber o ID via Url*/ {
        produtoRepository.deleteById(id);
    }

}
