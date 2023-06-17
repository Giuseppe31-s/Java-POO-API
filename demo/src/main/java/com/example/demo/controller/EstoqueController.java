package com.example.demo.controller;

import com.example.demo.model.Estoque;
import com.example.demo.service.EstoqueService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/estoques")
public class EstoqueController {

    private final EstoqueService estoqueService;

    public EstoqueController(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }

    @GetMapping
    public ResponseEntity<?> getAllEstoques() {
        try {
            List<Estoque> estoques = estoqueService.getAllEstoques();
            return ResponseEntity.ok(estoques);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao obter a lista de estoques: " + e.getMessage());
        }
    }


    @GetMapping("/{id}")
    public Estoque getEstoqueById(@PathVariable Long id) {
        return estoqueService.getEstoqueById(id);
    }

    /**
     * @param estoque
     * @return
     * @throws URISyntaxException
     */
    @PostMapping
    public ResponseEntity<?> createEstoque(@RequestBody @Validated Estoque estoque) throws URISyntaxException {
        try {
            Estoque createdEstoque = estoqueService.createEstoque(estoque);
            return ResponseEntity
                    .created(new URI("/api/estoques/" + createdEstoque.getId()))
                    .body(createdEstoque);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao criar estoque: " + e.getMessage());
        }
    }


    @PutMapping("/{id}")
    public Estoque updateEstoque(@PathVariable Long id, @RequestBody @Validated Estoque estoqueAtualizado) {
        return estoqueService.updateEstoque(id, estoqueAtualizado);
    }

    @DeleteMapping("/{id}")
    public void deleteEstoque(@PathVariable Long id) {
        estoqueService.deleteEstoque(id);
    }
}
