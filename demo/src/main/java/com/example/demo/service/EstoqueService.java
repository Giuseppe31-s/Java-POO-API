package com.example.demo.service;

import com.example.demo.model.Estoque;
import com.example.demo.model.Produto;
import com.example.demo.repository.EstoqueRepository;
import com.example.demo.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstoqueService {

    private final EstoqueRepository estoqueRepository;
    private final ProdutoRepository produtoRepository;

    public EstoqueService(EstoqueRepository estoqueRepository, ProdutoRepository produtoRepository) {
        this.estoqueRepository = estoqueRepository;
        this.produtoRepository = produtoRepository;
    }

    public Estoque createEstoque(Estoque estoque) {
        Produto produto = estoque.getProduto();

        // Verificar se o produto existe
        if (produto == null) {
            throw new IllegalArgumentException("O produto não pode ser nulo");
        }

        // Verificar se o produto existe no banco de dados
        if (!produtoRepository.existsById(produto.getId())) {
            throw new IllegalArgumentException("Produto não encontrado com o ID fornecido");
        }

        // Outras verificações de validação do produto podem ser adicionadas aqui

        return estoqueRepository.save(estoque);
    }

    public Estoque updateEstoque(Long id, Estoque estoqueAtualizado) {
        Estoque estoque = estoqueRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Estoque não encontrado com o ID fornecido"));

        Produto produto = estoqueAtualizado.getProduto();

        // Verificar se o produto existe
        if (produto == null) {
            throw new IllegalArgumentException("O produto não pode ser nulo");
        }

        // Verificar se o produto existe no banco de dados
        if (!produtoRepository.existsById(produto.getId())) {
            throw new IllegalArgumentException("Produto não encontrado com o ID fornecido");
        }

        // Outras verificações de validação do produto podem ser adicionadas aqui

        estoque.setQuantidade(estoqueAtualizado.getQuantidade());
        estoque.setLocalizacao(estoqueAtualizado.getLocalizacao());
        estoque.setProduto(estoqueAtualizado.getProduto());

        return estoqueRepository.save(estoque);
    }

    public void deleteEstoque(Long id) {
        Estoque estoque = estoqueRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Estoque não encontrado com o ID fornecido"));

        estoqueRepository.delete(estoque);
    }

    public List<Estoque> getAllEstoques() {
        return estoqueRepository.findAll();
    }

    public Estoque getEstoqueById(Long id) {
        Optional<Estoque> estoque = estoqueRepository.findById(id);
        return estoque.orElseThrow(() -> new IllegalArgumentException("Estoque não encontrado com o ID fornecido"));
    }
}
