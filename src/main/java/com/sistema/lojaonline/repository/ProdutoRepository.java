package com.sistema.lojaonline.repository;

import com.sistema.lojaonline.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {}
