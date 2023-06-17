package com.example.demo.controller;

import com.example.demo.model.Caixa;
import com.example.demo.repository.CaixaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/caixas")
public class CaixaController {

    private final CaixaRepository caixaRepository;

    
    public CaixaController(CaixaRepository caixaRepository) {
        this.caixaRepository = caixaRepository;
    }

    @GetMapping
    public List<Caixa> getAllCaixas() {
        return caixaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Caixa getCaixaById(@PathVariable Long id) {
        return caixaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Caixa não encontrada com o ID fornecido"));
    }

    @PostMapping
    public Caixa createCaixa(@RequestBody Caixa caixa) {
        return caixaRepository.save(caixa);
    }

    @PutMapping("/{id}")
    public Caixa updateCaixa(@PathVariable Long id, @RequestBody Caixa caixaAtualizada) {
        Caixa caixa = caixaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Caixa não encontrada com o ID fornecido"));

        caixa.setNumeroIdentificacao(caixaAtualizada.getNumeroIdentificacao());
        caixa.setValorEmCaixa(caixaAtualizada.getValorEmCaixa());
        caixa.setDataEntrada(caixaAtualizada.getDataEntrada());
        caixa.setDataSaida(caixaAtualizada.getDataSaida());

        return caixaRepository.save(caixa);
    }

    @DeleteMapping("/{id}")
    public void deleteCaixa(@PathVariable Long id) {
        Caixa caixa = caixaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Caixa não encontrada com o ID fornecido"));

        caixaRepository.delete(caixa);
    }
}
