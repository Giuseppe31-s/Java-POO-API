package com.example.demo.service;

import com.example.demo.model.Produto;
import com.example.demo.model.Venda;
import com.example.demo.repository.VendaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService {
    private final VendaRepository vendaRepository;

    public VendaService(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    public List<Venda> obterVendasPorProdutos(List<Produto> produtos) {
        return vendaRepository.findByProdutosIn(produtos);
    }

    public List<Venda> getAllVendas() {
        return vendaRepository.findAll();
    }

    public Venda getVendaById(Long id) {
        return vendaRepository.findById(id).orElse(null);
    }

    public Venda createVenda(Venda venda) {
        return vendaRepository.save(venda);
    }

    public Venda updateVenda(Long id, Venda venda) {
        Venda vendaExistente = vendaRepository.findById(id).orElse(null);
        if (vendaExistente != null) {
            // Atualiza os campos da vendaExistente com base na venda recebida
            vendaExistente.setData(venda.getData());
            vendaExistente.setValorTotal(venda.getValorTotal());
            vendaExistente.setCaixaId(venda.getCaixaId());
            vendaExistente.setProdutos(venda.getProdutos());

            return vendaRepository.save(vendaExistente);
        } else {
            return null;
        }
    }

    public void deleteVenda(Long id) {
        vendaRepository.deleteById(id);
    }
}
