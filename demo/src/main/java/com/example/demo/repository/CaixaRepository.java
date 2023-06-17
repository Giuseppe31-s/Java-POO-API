package com.example.demo.repository;
import com.example.demo.model.Caixa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CaixaRepository extends JpaRepository<Caixa, Long> {

    List<Caixa> findByNumeroIdentificacao(String numeroIdentificacao);

    List<Caixa> findByDataEntradaBetween(LocalDateTime start, LocalDateTime end);

    List<Caixa> findByDataSaidaIsNull();

    List<Caixa> findByValorEmCaixaGreaterThanEqual(BigDecimal valor);

    List<Caixa> findByValorEmCaixaLessThanEqual(BigDecimal valor);

    long countByValorEmCaixaGreaterThanEqual(BigDecimal valor);

    long countByValorEmCaixaLessThanEqual(BigDecimal valor);

    void deleteByNumeroIdentificacao(String numeroIdentificacao);

}
