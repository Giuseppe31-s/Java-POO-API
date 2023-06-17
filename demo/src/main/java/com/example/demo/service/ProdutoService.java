package com.example.demo.service;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    public Produto getProdutoById(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Produto não encontrado"));
    }

    public Produto createProduto(String nome, String codigo, double preco, String descricao) {
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setCodigo(codigo);
        produto.setPreco(preco);
        produto.setDescricao(descricao);
        return produtoRepository.save(produto);
    }

    public Produto updateProduto(Long id, String nome, String codigo, double preco, String descricao) {
        Produto existingProduto = produtoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Produto não encontrado"));

        existingProduto.setNome(nome);
        existingProduto.setCodigo(codigo);
        existingProduto.setPreco(preco);
        existingProduto.setDescricao(descricao);

        return produtoRepository.save(existingProduto);
    }

    public void deleteProduto(Long id) {
        if (!produtoRepository.existsById(id)) {
            throw new NotFoundException("Produto não encontrado");
        }
        produtoRepository.deleteById(id);
    }
}
