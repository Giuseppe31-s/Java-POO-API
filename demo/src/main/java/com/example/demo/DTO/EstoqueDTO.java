package com.example.demo.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.demo.model.Produto;

@Data
@NoArgsConstructor
public class EstoqueDTO {
    private Long id;
    private int quantidade;
    private String localizacao;
    private Produto produto;

    public EstoqueDTO(Long id, int quantidade, String localizacao, Produto produto) {
        this.id = id;
        this.quantidade = quantidade;
        this.localizacao = localizacao;
        this.produto = produto;
    }
}
