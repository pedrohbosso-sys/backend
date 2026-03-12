package com.example.gerenciamento_de_estoque.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.gerenciamento_de_estoque.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Optional<Funcionario> findByNif(String nif);
    boolean existsByNif(String nif);
}