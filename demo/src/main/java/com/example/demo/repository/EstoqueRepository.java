package com.example.demo.repository;
import com.example.demo.model.Estoque;
import com.example.demo.model.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

    Optional<Estoque> findByProduto(Produto produto);

    List<Estoque> findByQuantidadeGreaterThan(int quantidade);

    List<Estoque> findByQuantidadeLessThan(int quantidade);

    List<Estoque> findByProdutoNome(String nome);

    List<Estoque> findByProdutoCodigo(String codigo);

    List<Estoque> findByLocalizacao(String localizacao);

    List<Estoque> findByLocalizacaoContaining(String localizacao);

    long countByProdutoId(Long produtoId);

    void deleteByProdutoId(Long produtoId);

}
