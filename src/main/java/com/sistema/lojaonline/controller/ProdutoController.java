package com.sistema.lojaonline.controller;

import com.sistema.lojaonline.entity.Produto;
import com.sistema.lojaonline.service.ProdutoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin(origins = "*")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Produto> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Produto getById(@PathVariable UUID id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Produto criar(@RequestBody Produto produto) {
        return service.salvar(produto);
    }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable UUID id, @RequestBody Produto p) {
        Produto existente = service.buscarPorId(id);
        existente.setNome(p.getNome());
        existente.setPreco(p.getPreco());
        existente.setDescricao(p.getDescricao());
        existente.setEstoque(p.getEstoque());
        existente.setAtivo(p.isAtivo());
        return service.salvar(existente);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable UUID id) {
        service.excluir(id);
    }
}
