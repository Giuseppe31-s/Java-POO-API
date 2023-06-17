package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
    List<Funcionario> findByCargo(String cargo);
    List<Funcionario> findBySalarioLessThan(BigDecimal salario);
    List<Funcionario> findBySalarioGreaterThan(BigDecimal salario);
    List<Funcionario> findByDataContratacaoBetween(LocalDate start, LocalDate end);
    List<Funcionario> findByNomeLike(String nome);
    List<Funcionario> findByNomeNotLike(String nome);
    List<Funcionario> findByNomeOrderByDataContratacaoDesc(String nome);
    long countByCargo(String cargo);
    void deleteByNome(String nome);
}
