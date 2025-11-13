package com.sistema.lojaonline.repository;

import com.sistema.lojaonline.entity.UsuarioEmpreendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<UsuarioEmpreendedor, UUID> {
    Optional<UsuarioEmpreendedor> findFirstBy();

    Optional<UsuarioEmpreendedor> findByEmail(String email);
}
