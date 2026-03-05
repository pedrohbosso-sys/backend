package com.example.rh2.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.rh2.Model.funcionario;
import java.util.List;

//Classe abstrata
public interface funcionarioRepository extends CrudRepository<funcionario, Long> {
    //permitir a urilização dos métodos do crud do JPA

    //métodos auxiliares
    
    funcionario findbyID(long id); // buscar um funcionario pelo id
    funcionario findByNome(String nome); //buscar funcionario pelo nome

    //Buscar funcionário por parte do nome
    @Query(value = "select u from Funcionario u where u.nome like %?1%")
    List<funcionario> findByLetras(String letras);
    
}