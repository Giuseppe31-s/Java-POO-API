package com.example.demo.DTO;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.model.Caixa;
import com.example.demo.model.Produto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VendaDTO {

    private Long id;
    private LocalDate data;
    private double valorTotal;
    private List<Produto> produtosVendidos;
    private Caixa caixa;

    public VendaDTO(Long id, LocalDate data, double valorTotal, List<Produto> produtosVendidos, Caixa caixa) {
        this.id = id;
        this.data = data;
        this.valorTotal = valorTotal;
        this.produtosVendidos = produtosVendidos;
        this.caixa = caixa;
    }
}
