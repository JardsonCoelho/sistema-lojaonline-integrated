package com.sistema.lojaonline.repository;

import com.sistema.lojaonline.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface CategoriaRepository extends JpaRepository<Categoria, UUID> {}
