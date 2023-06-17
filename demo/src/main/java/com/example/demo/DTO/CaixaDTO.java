package com.example.demo.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class CaixaDTO {
    private Long id;
    private String numeroIdentificacao;
    private BigDecimal valorEmCaixa;
    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;

    public CaixaDTO(Long id, String numeroIdentificacao, BigDecimal valorEmCaixa, LocalDateTime dataEntrada, LocalDateTime dataSaida) {
        this.id = id;
        this.numeroIdentificacao = numeroIdentificacao;
        this.valorEmCaixa = valorEmCaixa;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }
}
