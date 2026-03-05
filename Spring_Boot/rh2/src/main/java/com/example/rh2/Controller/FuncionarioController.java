package com.example.rh2.Controller;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.rh2.Model.funcionario;
import java.util.List;


public interface FuncionarioController extends CrudRepository<funcionario, Long> {
    
    //permitir a urilização dos métodos do crud do JPA

    //métodos auxiliares

    funcionario findById(long id); // buscar um funcionario pelo id

    funcionario findByNome(String nome); //buscar funcionario pelo nome

    //Buscar funcionário por parte do nome
    @Query(value = "select u from Funcionario u where u.nome like %?1%")
    List<funcionario> findByLetras(String letras);


}

    

