package com.sistema.lojaonline.service;

import com.sistema.lojaonline.entity.Produto;
import com.sistema.lojaonline.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class ProdutoService {
    private final ProdutoRepository repo;
    public ProdutoService(ProdutoRepository repo) { this.repo = repo; }

    public List<Produto> listar() { return repo.findAll(); }

    public Produto salvar(Produto p) { return repo.save(p); }

    public Produto buscarPorId(UUID id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado: " + id));
    }

    public void excluir(UUID id) { repo.deleteById(id); }
}
