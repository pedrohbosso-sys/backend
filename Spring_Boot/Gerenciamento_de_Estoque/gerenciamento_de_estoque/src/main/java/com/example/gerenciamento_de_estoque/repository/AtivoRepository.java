package com.example.gerenciamento_de_estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.gerenciamento_de_estoque.model.Ativo;

public interface AtivoRepository extends JpaRepository<Ativo, Long> {
}