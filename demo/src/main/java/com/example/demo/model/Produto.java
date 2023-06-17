package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String codigo;
    private double preco;
    private String descricao;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "estoque_id")
    private Estoque estoque;

    public Produto(String nome, String codigo, double preco, String descricao) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.descricao = descricao;
    }

    public void diminuirEstoque(int quantidade) {
        if (estoque != null) {
            estoque.diminuirEstoque(quantidade);
        } else {
            throw new IllegalStateException("Estoque não definido para o produto");
        }
    }
}
