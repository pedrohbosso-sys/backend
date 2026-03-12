package com.example.gerenciamento_de_estoque.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.gerenciamento_de_estoque.model.Funcionario;
import com.example.gerenciamento_de_estoque.service.FuncionarioService;

@Controller
public class AuthController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    @PostMapping("/auth/login")
    public String login(@RequestParam String nif,
                        @RequestParam String senha,
                        HttpSession session,
                        Model model) {

        Funcionario funcionario = funcionarioService.login(nif, senha);

        if (funcionario == null) {
            model.addAttribute("erro", "NIF ou senha inválidos.");
            return "auth/login";
        }

        session.setAttribute("usuarioLogado", true);
        session.setAttribute("nif", nif);
        session.setAttribute("nome", funcionario.getNome());
        return "redirect:/app";
    }

    @GetMapping("/cadastro")
    public String cadastroPage() {
        return "auth/cadastro";
    }

    @PostMapping("/auth/cadastro")
    public String cadastro(@RequestParam String nome,
                           @RequestParam String nif,
                           @RequestParam String senha,
                           Model model) {

        boolean sucesso = funcionarioService.cadastrar(nome, nif, senha);

        if (!sucesso) {
            model.addAttribute("erro", "NIF e nome não autorizados ou já cadastrados.");
            return "auth/cadastro";
        }

        model.addAttribute("sucesso", "Conta criada com sucesso! Faça login.");
        return "auth/cadastro";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}