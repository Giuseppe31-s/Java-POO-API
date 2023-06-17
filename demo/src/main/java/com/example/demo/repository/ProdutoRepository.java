package com.example.demo.repository;

import com.example.demo.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByNome(String nome);
    List<Produto> findByPrecoLessThan(double preco);
    List<Produto> findByPrecoGreaterThan(double preco);
    List<Produto> findByDescricaoContaining(String descricao);
    List<Produto> findByCodigoStartingWith(String codigo);
    List<Produto> findByEstoqueQuantidadeGreaterThan(int quantidade);
    List<Produto> findByEstoqueLocalizacao(String localizacao);

    long countByNome(String nome);

    void deleteByCodigo(String codigo);
}
