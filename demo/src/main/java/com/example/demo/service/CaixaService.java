package com.example.demo.service;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Caixa;
import com.example.demo.repository.CaixaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CaixaService {

    private final CaixaRepository caixaRepository;

    @Autowired
    public CaixaService(CaixaRepository caixaRepository) {
        this.caixaRepository = caixaRepository;
    }

    public List<Caixa> getAllCaixas() {
        return caixaRepository.findAll();
    }

    public Caixa getCaixaById(Long id) {
        return caixaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Caixa não encontrada"));
    }

    public Caixa createCaixa(String numeroIdentificacao, BigDecimal valorEmCaixa, LocalDateTime dataEntrada, LocalDateTime dataSaida) {
        Caixa caixa = new Caixa();
        caixa.setNumeroIdentificacao(numeroIdentificacao);
        caixa.setValorEmCaixa(valorEmCaixa);
        caixa.setDataEntrada(dataEntrada);
        caixa.setDataSaida(dataSaida);
        return caixaRepository.save(caixa);
    }

    public Caixa updateCaixa(Long id, String numeroIdentificacao, BigDecimal valorEmCaixa, LocalDateTime dataEntrada, LocalDateTime dataSaida) {
        Caixa existingCaixa = caixaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Caixa não encontrada"));

        existingCaixa.setNumeroIdentificacao(numeroIdentificacao);
        existingCaixa.setValorEmCaixa(valorEmCaixa);
        existingCaixa.setDataEntrada(dataEntrada);
        existingCaixa.setDataSaida(dataSaida);

        return caixaRepository.save(existingCaixa);
    }

    public void deleteCaixa(Long id) {
        if (!caixaRepository.existsById(id)) {
            throw new NotFoundException("Caixa não encontrada");
        }
        caixaRepository.deleteById(id);
    }
}
