package com.example.demo.controller;

import com.example.demo.model.Venda;
import com.example.demo.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.management.relation.RelationNotFoundException;

@RestController
@RequestMapping("api/vendas")
public class VendaController {

    private final VendaService vendaService;

    @Autowired
    public VendaController(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    @GetMapping
    public List<Venda> getAllVendas() {
        return vendaService.getAllVendas();
    }

    @GetMapping("/{id}")
    public Venda getVendaById(@PathVariable Long id) throws RelationNotFoundException {
        return vendaService.getVendaById(id);
    }

    @PostMapping
    public ResponseEntity<?> createVenda(@RequestBody Venda venda) {
        try {
            Venda createdVenda = vendaService.createVenda(venda);
            return ResponseEntity.ok(createdVenda);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("Erro ao criar estoque: " + e.getMessage()););
        }
    }


    @PutMapping("/{id}")
    public Venda updateVenda(@PathVariable Long id, @RequestBody Venda venda) throws RelationNotFoundException {
        return vendaService.updateVenda(id, venda);
    }

    @DeleteMapping("/{id}")
    public void deleteVenda(@PathVariable Long id) throws RelationNotFoundException {
        vendaService.deleteVenda(id);
    }
}
