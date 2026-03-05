package com.example.rh.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.rh.Model.Funcionario;
import java.util.List;


public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {
    
    //Metodos para realizar o Crud do Funcionario
    //Crair uma busca pela chave primaria do funcionario

    Funcionario findById (long id);

    //Busca pelo nome 
    Funcionario findByNome (String nome);

    //Busca para Varios Nomes // Não existe no JPA
    @Query(value =  "select u from Funcionario u where u.nome like %?1%")
    List<Funcionario> findByNomes (String nome);

}
