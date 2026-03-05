package com.example.rh2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.rh2.repository.funcionarioRepository;
import com.example.rh2.repository.funcionarioRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class IndexController {
    //atributo
    @Autowired
    funcionarioRepository fr; // Executar o CRUD

    @GetMapping("/")
    public String abrirIndex() {
        //será criado futuramente uma mensagem de saudação
        return "index";
    }

    
}
