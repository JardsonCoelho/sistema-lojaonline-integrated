package com.sistema.lojaonline.service;

import com.sistema.lojaonline.entity.Produto;
import com.sistema.lojaonline.repository.ProdutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import java.math.BigDecimal;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProdutoServiceTest {

    @Mock
    private ProdutoRepository repo;

    @InjectMocks
    private ProdutoService service;

    @BeforeEach
    void setup() {

        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveSalvarProduto() {
        Produto p = new Produto();
        p.setNome("Notebook");
        p.setPreco(BigDecimal.valueOf(3500.00));

        when(repo.save(any(Produto.class))).thenReturn(p);

        Produto salvo = service.salvar(p);
        assertEquals("Notebook", salvo.getNome());
        verify(repo, times(1)).save(p);
    }

    @Test
    void deveListarProdutos() {
        when(repo.findAll()).thenReturn(List.of(new Produto(), new Produto()));
        List<Produto> lista = service.listar();
        assertEquals(2, lista.size());
        verify(repo, times(1)).findAll();
    }
}
